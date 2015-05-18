/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import javax.swing.JOptionPane;

/**
 *
 * @author Atendimento
 */
public class ValidaValores {

    public static boolean ehTelefone(String telefone) {
        if(telefone == null){
            return true;
        }
        try {
            Double nr = Double.parseDouble(telefone);
            Double limite = 9999999999.0;
            if (nr < limite) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No campo telefone/celular, informe até 10 digitos");
            }
        } catch (NumberFormatException nfe) {
            //JOptionPane.showMessageDialog(null, "No campo telefone, digite apenas números");
        }
        return false;
    }
    
    public static boolean ehCPF(String cpf) {
        if(cpf == null || cpf.equals("")){
            //JOptionPane.showMessageDialog(null, "No campo CPF, não pode estar em branco");
            return false;
        }
        try {
            Double nr = Double.parseDouble(cpf);
            Double limite = 99999999999.0;
            if (nr < limite) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(null, "No campo CPF, digite apenas números");
            }
        } catch (NumberFormatException nfe) {
            //JOptionPane.showMessageDialog(null, "No campo CPF, digite apenas números");
        }
        return false;
    }
    
    public static boolean ehNome(String nome){
        if(nome == null){
            JOptionPane.showMessageDialog(null, "O campo nome não pode ser vazio");
            return false;
        }
        return true;
    
    }
    
}
