package utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe para a manipulação das datas do banco de dados e do java.
 *
 * @author thiago
 * @see Data
 * @see GregorianCalendar
 * @see SimpleDateFormat
 */
public class Datas {

    private static String DATE = "dd/MM/yyyy";
    private static String DIA = "dd";
    private static String MES = "MM";
    private static String ANO = "yyyy";
    private static String TIME = "HHH:mm:ss";
    private static String TIME_DATABASE = "HH:mm:ss";
    private static String HOUR = "H";
    private static String MINUTE = "m";
    private static String DATE_DATABASE = "yyyy-MM-dd";

    /**
     * Método para converter uma data do tipo Date para uma String. O formato de
     * saída da String será "dd/MM/yyyy"
     *
     * @param data a data no tipo Date
     * @return {@link String} no formato "dd/MM/yyyy"
     */
    public static String getDate(Date data) {
        DateFormat date = new SimpleDateFormat(DATE);
        return date.format(data);
    }

    /**
     * Método para converter uma data do tipo Date para uma String. O formato de
     * saída da String será "dd/MM/yyyy"
     *
     * @param data a data no tipo Date
     * @return {@link String} no formato "dd/MM/yyyy"
     */
    public static boolean ehDate(Date data) {
        try {
            //DateFormat date = new SimpleDateFormat(DATE);
            Date novaData = data;
            if (novaData != null) {
                return true;
            }
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return false;
    }

    /**
     * Método para retornar a hora no formato HH:MM:SS
     *
     * @param hora
     * @param min
     * @param seg
     * @return {@link Date} no formato HH:MM:SS
     */
    public static Date getTimeDataBase(String hora, String min, String seg) {
        String sData = hora + ":" + min + ":" + seg;
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_DATABASE);

        Date date = null;
        try {
            date = sdf.parse(sData);
        } catch (ParseException ex) {
            Logger.getLogger(Datas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    /**
     * Método para retornar a hora no formato HH:MM:SS
     *
     * @param hora a hora a ser convertida
     * @return {@link String} no formato "HH:MM:SS"
     */
    public static String getTimeDataBase(Date hora) {

        DateFormat date = DateFormat.getTimeInstance();
        return date.format(hora);
    }

    /**
     * Retorna a hora atual no formato hh:mm
     *
     * @return retorna uma string com a hora formatada
     */
    public static String getHoraCompletaToString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String hora = format.format(new Date());
        return hora;
    }

//    public static Integer getHora(Date hora){
//        Integer retorno = 0;
//        retorno = hora.getTime();
//        return retorno;
//    }
    /**
     * Método para converter uma data do tipo Date para uma String. O formato de
     * saída da String será "yyyy-MM-dd"
     *
     * @param data a data no tipo Date
     * @return {@link String} no formato "yyyy-MM-dd"
     */
    public static String getDateDatabase(Date data) {
        DateFormat date = new SimpleDateFormat(DATE_DATABASE);
        return date.format(data);
    }

    /**
     * Método para converter uma hora do tipo Date para uma String. O formato de
     * saída da String será "HH:mm:ss"
     *
     * @param hora a hora no tipo Date
     * @return {@link String} no formato "HH:mm:ss"
     */
    public static String getTime(Date hora) {
        DateFormat date = new SimpleDateFormat(TIME);
        return date.format(hora);
    }

    /**
     * Método para pegar a hora de um objeto Date.
     *
     * @param time a hora no tipo Date
     * @return {@link int} a hora da data de 0-23
     */
    public static int getHour(Date time) {
        DateFormat date = new SimpleDateFormat(HOUR);
        return Integer.parseInt(date.format(time));
    }

    /**
     * Método para pegar o minuto de um objeto Date.
     *
     * @param time a hora no tipo Date
     * @return {@link int} o minuto da data de 0-23
     */
    public static int getMinute(Date time) {
        DateFormat date = new SimpleDateFormat(MINUTE);
        return Integer.parseInt(date.format(time));
    }

    /**
     * Rebece uma String de uma data no seguinte formato: "dd/MM/yyyy" e outra
     * String no seguinte formato: "HH:mm:ss" e converte para Date.
     *
     * @param date uma String de uma data no formato "dd/MM/yyyy"
     * @param time uma String de uma hora no formato "HH:mm:ss"
     * @return {@link Date}
     */
    /**
     * Pega o dia e hora atual do sistema e retorna como um Date
     *
     * @return a data e hora atual em Date.
     */
    public static Date getCurrentTime() {
        return new Date(System.currentTimeMillis());
    }

    public static String getDiferenca(long d) {
        DateFormat date = new SimpleDateFormat(TIME);
        return date.format(d);
    }

    public static Integer getDia(Date d) {
        DateFormat date = new SimpleDateFormat(DIA);
        return Integer.parseInt(date.format(d));

    }

    public static Integer getMes(Date d) {
        DateFormat date = new SimpleDateFormat(MES);
        return Integer.parseInt(date.format(d));

    }

    public static Integer getAno(Date d) {
        DateFormat date = new SimpleDateFormat(ANO);
        return Integer.parseInt(date.format(d));

    }

    public static Date transformaStringDate(String d) {
        String sData = d;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);

        Date date = null;
        try {
            date = sdf.parse(d);
        } catch (ParseException ex) {
            Logger.getLogger(Datas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return date;

    }

    /**
     * Recebe uma String de uma data no seguinte formato: "dd/MM/yyyy" e
     * converte para Date.
     *
     * @param data uma String de uma data no formato "dd/MM/yyyy"
     * @return {@link Date}
     */
    public static Date getData(String data) {
        int[] numeros = getDataNumbers(data);
        if (numeros != null) {
            Calendar calendar = new GregorianCalendar(numeros[2], (numeros[1] - 1), numeros[0]);
            return (calendar.getTime());
        }
        return null;
    }

    public static String getDataBanco(Date data) {
        if (data != null) {
            DateFormat date = new SimpleDateFormat(DATE_DATABASE);
            return date.format(data);
        } else {
            return "";
        }
    }

    public static Date addDias(Date data, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, dias);
        return calendar.getTime();

    }

    /**
     * Recebe uma String de uma data no seguinte formato: "dd/MM/yyyy" e
     * converte para os números da data. O resultado será um vetor com o dia,
     * mês e ano.
     *
     * @param data uma String de uma data no formato "dd/MM/yyyy"
     * @return int[] um vetor com o dia, mês e ano
     */
    private static int[] getDataNumbers(String data) {
        if (data != null) {
            String[] string = data.split("/");
            if (string.length == 3) {
                int[] numeros = new int[3];
                for (int i = 0; i < string.length; i++) {
                    try {
                        numeros[i] = Integer.parseInt(string[i]);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Falha ao converter a data!\n", "Data/getData",
                                JOptionPane.ERROR_MESSAGE);
                        return null;
                    }
                }
                return new int[]{numeros[0], numeros[1], numeros[2]};
            } else {
                JOptionPane.showMessageDialog(null,
                        "Falha ao converter a data!\n", "Data/getData",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } else {
            return null;
        }
    }

    //Calcula a Idade baseado em java.util.Date
    public static int calculaIdade(java.util.Date dataNasc) {
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNasc);
// Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();
// Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, age);
//se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }

    public static String getDataString(Date data) {
        String retorno = "";
        retorno = getDia(data) + "-"
                + getMes(data) + "-"
                + getAno(data);
        return retorno;

    }

}
