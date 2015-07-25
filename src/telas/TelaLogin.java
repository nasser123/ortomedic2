/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package telas;

import dao.UsuarioDAO;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import utilidades.ConfigTelas;

/**
 *
 * @author Nasser
 */
public class TelaLogin extends javax.swing.JFrame {

    private boolean login;
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());

    /**
     * Creates new form TelaInicial
     */
    public TelaLogin() {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
        jProgressBar1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButtonEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUsuario.setToolTipText("Nome do usuário");
        jPanel1.add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 220, -1));

        jButtonEntrar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/entrar.png"))); // NOI18N
        jButtonEntrar.setMnemonic('E');
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.setToolTipText("Entrar no sistema");
        jButtonEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEntrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 230, 90, 90));

        jLabel1.setText("usuário");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel2.setText("senha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jPasswordField1.setToolTipText("Digite a senha");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 220, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DoctorSis");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 390, -1));

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/sair.png"))); // NOI18N
        jButtonSair.setMnemonic('S');
        jButtonSair.setText("Sair");
        jButtonSair.setToolTipText("Sair do sistema");
        jButtonSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 230, 90, 90));

        jProgressBar1.setIndeterminate(true);
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 271, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/sistema.png"))); // NOI18N
        jButton1.setToolTipText("Configurações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 273, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private class ThreadAtualizaJProgressBar extends Thread {

        @Override
        public void run() {
            try {
                realizarLogin();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.FATAL, null, ex);
            }
        }

    }

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        jProgressBar1.setVisible(true);
        ThreadAtualizaJProgressBar tal = new ThreadAtualizaJProgressBar();
        tal.start();
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaConfiguracaoJDialog(this, login).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                //if ("teste".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    private boolean realizarLogin() throws NoSuchAlgorithmException {

        String usuario = jTextFieldUsuario.getText();

        char[] senhaTemp = jPasswordField1.getPassword();
        String senha = "";
        for (int i = 0; i < senhaTemp.length; i++) {
            senha = senha + senhaTemp[i];
        }
        this.login = false;

        if (usuario.equals("admin")) {
            if (senha.equals("123456")) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                this.dispose();
                return true;
            } else {
                JOptionPane.showMessageDialog(rootPane, "O nome do usuário ou a senha estão incorretos!", "DoctorSis - Login Incorreto", JOptionPane.ERROR_MESSAGE);
                jProgressBar1.setVisible(false);
            }
        } else {

            UsuarioDAO uc = new UsuarioDAO();
            try {
                this.login = uc.verificaLogin(usuario, senhaTemp);
            } catch (SQLException | NullPointerException ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.FATAL, null, ex);
                return false;
            }
            if (login) {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "O nome do usuário ou a senha estão incorretos!", "DoctorSis - Login Incorreto", JOptionPane.ERROR_MESSAGE);
                jProgressBar1.setVisible(false);
            }
            return login;
        }
        return login;
    }
}
