package utilidades;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe para a manipulação das senhas do banco de dados e do java.
 *
 * @author Nasser
 */

public class Senhas {
    public static boolean testaSenhasCadastro(char[] pass1, char[] pass2){
        String s1 = charToString(pass1);
        String s2 = charToString(pass2);
        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    
    }
    
    public static boolean testaSenhasCadastro(String pass1, String pass2){
        if (pass1.equals(pass2)) {
            return true;
        } else {
            return false;
        }
    
    }
    
    private static String charToString(char[] senha){
        String s = "";
        for(int i = 0 ; i < senha.length; i++){
            s = s + senha[i];
        }
        return s;
    }
    
    public static String toMD5(char[] s) throws NoSuchAlgorithmException{
        String senhaDigitada = charToString(s);
        String senhaBanco = "";
        if (s != null) {
//            transforma a senha texto em md5
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(senhaDigitada.getBytes(), 0, senhaDigitada.length());
            senhaBanco = new BigInteger(1, m.digest()).toString(16);
        }

        return senhaBanco;
    }
    
    
}
