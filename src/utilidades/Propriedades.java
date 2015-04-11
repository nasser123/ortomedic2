/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.util.Properties;
import org.ini4j.Config;

/**
 *
 * @author Nasser
 */
public class Propriedades {

    private String emailUser;
    private String emailHost;
    private Boolean emailAuth;

    public Propriedades() {
        Properties properties = new Properties();
        try {
            properties.load(Config.class.getResourceAsStream("/config.properties"));
            emailUser = properties.getProperty("email.user");
            emailHost = properties.getProperty("email.host");
            emailAuth = Boolean.valueOf(properties.getProperty("email.auth"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //parametros no arquivo armazenado
//    email.user=user
//email.host=smtp.email.com
//email.auth=true  
    
    //Somente Gets

}
    

