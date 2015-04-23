/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
    private static String dbName;
    private static String dbHost;
    private static String dbDataBase;
    private static String dbUser;
    private static String password;

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        ConfigurationFactory.dbName = dbName;
    }

    public static String getDbHost() {
        return dbHost;
    }

    public static void setDbHost(String dbHost) {
        ConfigurationFactory.dbHost = dbHost;
    }

    public static String getDbDataBase() {
        return dbDataBase;
    }

    public static void setDbDataBase(String dbDataBase) {
        ConfigurationFactory.dbDataBase = dbDataBase;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static void setDbUser(String dbUser) {
        ConfigurationFactory.dbUser = dbUser;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConfigurationFactory.password = password;
    }
    
    
    public static Section getConfiguration(String section)  {
        if(ini != null){
            
            return ini.get(section);
        }
        Ini ini = getIni(); 
        Section sect = ini.get(section);
        return sect;
    }
    
    public static Section getConfiguration()  {
       
        
        if(ini != null){
            return ini.get("main");
        }
        Ini ini = getIni();
        Section sect = ini.get("main");
        return sect;
    }

    private static Ini getIni() {
        Ini ini = new Ini();
        try {
            FileReader arq = new FileReader("config.ini");
            ini.load(arq);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo de configuração");
            Logger.getLogger(ConfigurationFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ini;
    }
    
    
    
}
