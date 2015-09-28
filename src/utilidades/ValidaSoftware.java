package utilidades;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.NewJFrameUUID;

/**
 * Classe para a manipulação da validação do sistema.
 *
 * @author Nasser
 */
public class ValidaSoftware {

    public static boolean verificaValidacao(String serialBanco) {
        boolean validado = false;
        
        return validado;
    }

    public static String geraSerialSistema() {
        String serial = "";
        Integer serialDisco = getSerialDisco();
        try {
            serial = toMD5(serialDisco);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ValidaSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        // busca os 10 primeiros caracteres
        char[] serialTemp = serial.toCharArray();
        serial = "";
        for (int i = 0; i < 10 ; i++){
            serial = serial + (serialTemp[i]);
        }
        
        return serial;
    }

    private static Integer getSerialDisco() {
        FileSystem fileSystem = FileSystems.getDefault();
        Integer volId = 0;

        for (FileStore store : fileSystem.getFileStores()) {
            try {
                volId = (Integer) store.getAttribute("volume:vsn");
                System.out.println("serial disco: " + volId);
                break;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrameUUID.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return volId;
    }

    private static String charToString(char[] senha) {
        String s = "";
        for (int i = 0; i < senha.length; i++) {
            s = s + senha[i];
        }
        return s;
    }

    private static char[] integerToChar(Integer serial) {
        char[] charSerial;

        charSerial = serial.toString().toCharArray();
        return charSerial;

    }

    private static String toMD5(char[] s) throws NoSuchAlgorithmException {
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

    /**
     */
    private static String toMD5(Integer serial) throws NoSuchAlgorithmException {
        String serialDisco = serial.toString();
        if (serial != null) {
//            transforma a senha texto em md5
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(serialDisco.getBytes(), 0, serialDisco.length());
            serialDisco = new BigInteger(1, m.digest()).toString(16);
        }
        System.out.println("serial disco em MD5: " + serialDisco);
        return serialDisco;
    }
}
