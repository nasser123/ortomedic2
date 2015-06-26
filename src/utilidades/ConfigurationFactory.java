/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

/**
 *
 * @author Nasser
 */
public class ConfigurationFactory {

    private static final Ini ini = null;
    public static String DBNAME;
    public static String DBHOST;
    public static String DATABASE;
    public static String DBUSER;
    public static String DBPASSWORD;
    public static String DBPORT;
    public static String DBDIR;
    public static File DBFILE;
    public static String ARCHITECTURE;
    private static Section config;

    public ConfigurationFactory(String secao) throws FileNotFoundException {
        if (secao == null) {
            config = getConfiguration();
        } else {
            config = getConfiguration(secao);
        }
    }

    public static Section getConfiguration(String section) throws FileNotFoundException {
        if (ini != null) {

            return ini.get(section);
        }
        Ini ini = getIni();
        config = ini.get(section);
        if (ini.size() != 0) {
            DBNAME = config.get("db.name");
            DBHOST = config.get("db.host");
            DATABASE = config.get("db.database");
            DBPORT = config.get("db.port");
            DBUSER = config.get("db.user");
            DBPASSWORD = config.get("db.password");
            ARCHITECTURE = System.getProperty("os.arch");
            DBDIR = "mysql";
            DBFILE = new File(DBDIR);
        }
        if(DBDIR == null){
            DBDIR = "mysql";
            DBFILE = new File(DBDIR);
        }
        return config;
    }

    private static String preencheArquivo(String arquivo) {
        String temp = arquivo;
        String arquivoFinal = "";
        char[] tempChar = temp.toCharArray();
        for(int i = 0 ; i < temp.length() ; i ++){
            String teste = "" + tempChar[i];
            if(teste.equals("\\")){
                arquivoFinal = arquivoFinal + "/";
            }else{
            arquivoFinal = arquivoFinal + tempChar[i];
            }
        }
        return arquivoFinal;
    }
    public static Section getConfiguration()  {

        if (ini != null) {
            return ini.get("main");
        }
        Ini ini = getIni();
        if (ini.size() != 0) {
            config = ini.get("main");
            DBNAME = config.get("db.name");
            DATABASE = config.get("db.database");
            DBHOST = config.get("db.host");
            DBPORT = config.get("db.port");
            DBUSER = config.get("db.user");
            DBPASSWORD = config.get("db.password");
            ARCHITECTURE = System.getProperty("os.arch");
            DBDIR = "mysql";
            DBFILE = new File(DBDIR);
        }
        return config;
    }

    private static Ini getIni() {
        Ini ini = new Ini();
        try {

            FileReader arq = new FileReader("./config.ini");
            ini.load(arq);

        } catch (FileNotFoundException ex) {
            File arquivo1 = new File("config.ini");//cria o file do arquivo informado 
            try {
                arquivo1.createNewFile();
                ini.load(arquivo1);
            } catch (IOException ex1) {
                Logger.getLogger(ConfigurationFactory.class.getName()).log(Level.SEVERE, null, ex1);
            }
            JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo de configuração");
            Logger.getLogger(ConfigurationFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ini;
    }

    public static void gravaConfiguracao() {

        DBDIR = preencheArquivo(DBDIR);
        
        File arquivo1 = new File("config.ini");//cria o file do arquivo informado  
        try {
            arquivo1.createNewFile();//arquivo criado  
           /*LEITURA*/
            FileReader fileR = new FileReader(arquivo1);//arquivo ppara ser lido  
            BufferedReader buffR = new BufferedReader(fileR);//arquivo buferizado  
           /*ESCREVER*/
            FileWriter fileW = new FileWriter(arquivo1);//arquivo para escrita  
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write("[main]");
            buffW.newLine();
            buffW.write("db.name=" + DBNAME);
            buffW.newLine();
            buffW.write("db.host=" + DBHOST);
            buffW.newLine();
            buffW.write("db.port=" + DBPORT);
            buffW.newLine();
            buffW.write("db.database=" + DATABASE);
            buffW.newLine();
            buffW.write("db.user=" + DBUSER);
            buffW.newLine();
            buffW.write("db.password=" + DBPASSWORD);
            buffW.newLine();
            buffW.write("db.dir=" + DBDIR);
            buffW.newLine();

            buffR.close();
            buffW.close();

            JOptionPane.showMessageDialog(null, "Configurações gravadas com êxito");
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possível gravar as alterações");
        }

    }
}
