package utilidades;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.ini4j.Profile.Section;
import telas.TelaConfiguracaoJDialog;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {

    private static Connection connection;
    private static Connection connectionNoDatabase;
    private static EntityManager entityManager;

    public static Connection getConnection() {
        if (connection == null) {
            Section config = ConfigurationFactory.getConfiguration();
            try {
                //aqui colocamos os dados de acesso ao banco
                if (config.get("db.name").equalsIgnoreCase("mysql")) {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection("jdbc:mysql://" + config.get("db.host") + ":3306/" + config.get("db.database") + "?autoReconnect=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8",
                            config.get("db.user"), config.get("db.password"));
                }
            } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public static Connection getConnectionWithNoDatabase() {
        if (connectionNoDatabase == null) {
            Section config = ConfigurationFactory.getConfiguration();
            try {
                //aqui colocamos os dados de acesso ao banco
                if (config.get("db.name").equalsIgnoreCase("mysql")) {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connectionNoDatabase = DriverManager.getConnection("jdbc:mysql://" + config.get("db.host") + ":3306/?autoReconnect=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8",
                            config.get("db.user"), config.get("db.password"));
                }
            } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connectionNoDatabase;
    }

    public static EntityManager getEntityManager() {
        Section config = ConfigurationFactory.getConfiguration();
        Map prop = new HashMap();
        if (entityManager == null) {
            EntityManagerFactory emf;
            prop.put("javax.persistence.jdbc.url", "jdbc:mysql://" + config.get("db.host") + ":3306/" + config.get("db.database"));
            prop.put("javax.persistence.jdbc.password", config.get("db.password"));
            prop.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            prop.put("javax.persistence.jdbc.user", config.get("db.user"));
            emf = Persistence.createEntityManagerFactory("ortomedicPU", prop);
            try {
                entityManager = emf.createEntityManager();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sem acesso ao banco de dados");
            }

            return entityManager;
        } else {

            return entityManager;
        }
    }

    public static boolean geraBackup() {
        boolean gravou = false;
        if (!existeExecutavel("mysqldump.exe")) {
            try {
                File file = new File("Backup");
                file.mkdir();
                Date data = Datas.getCurrentTime();
                String nomeBkp = "Backup(" + Datas.getDataString(data) + ").sql";

                String dump = "cmd.exe /c " + ConfigurationFactory.DBFILE.getCanonicalPath() + File.separator + "mysqldump "
                        + " --user=" + ConfigurationFactory.DBUSER
                        + " --password=" + ConfigurationFactory.DBPASSWORD
                        + " --host=" + ConfigurationFactory.DBHOST
                        + "  " + ConfigurationFactory.DATABASE + " > Backup\\" + nomeBkp;

                System.out.println(dump);
                Runtime bkp = Runtime.getRuntime();
                bkp.exec(dump);
                JOptionPane.showMessageDialog(null, "gravou");
                gravou = true;
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "não gravou");
                gravou = false;
            }
        } else {

            return gravou;
        }
        return gravou;
    }

    private static boolean existeExecutavel(String arquivo) {
        File testeMySqlDump = new File(ConfigurationFactory.DBFILE.getAbsolutePath() + File.separator + arquivo);
        File[] arquivos = ConfigurationFactory.DBFILE.listFiles();
        for (int i = 0; i < arquivos.length; i++) {
                System.out.println(arquivos[i].isFile());
        }
        System.out.println(testeMySqlDump.getAbsolutePath());
        JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo " + arquivo);
        return testeMySqlDump.isFile();
    }

    public static boolean restauraBackup(String arquivo) {
        Statement s = null;
        try {
            s = getConnectionWithNoDatabase().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(TelaConfiguracaoJDialog.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            s.execute("CREATE DATABASE IF NOT EXISTS `ortomedic` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;");

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(TelaConfiguracaoJDialog.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if (existeExecutavel("mysql.exe")) {
            try {

                String dump = "cmd.exe /c " + ConfigurationFactory.DBFILE.getCanonicalPath() + File.separator + "mysql "
                        + " --user=" + ConfigurationFactory.DBUSER
                        + " --password=" + ConfigurationFactory.DBPASSWORD
                        + " --host=" + ConfigurationFactory.DBHOST + " ortomedic < " + arquivo;
                System.out.println(dump);
                Runtime bkp = Runtime.getRuntime();
                bkp.exec(dump);
                JOptionPane.showMessageDialog(null, "gravou");
                return true;
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "não gravou");
                return false;
            }
        }
        return false;
    }
}
