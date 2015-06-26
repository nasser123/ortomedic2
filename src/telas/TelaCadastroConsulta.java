/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultaDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Consulta;
import model.Paciente;
import model.TipoConsulta;
import utilidades.ConfigTelas;
import utilidades.ConnectionFactory;
import utilidades.Datas;

/**
 *
 * @author Nasser
 */
public class TelaCadastroConsulta extends javax.swing.JFrame {

    /**
     * Creates new form TelaPadrao
     */
    Paciente pac;
    Consulta con;

    public TelaCadastroConsulta() {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
        this.con = new Consulta();
        jTextFieldCodigo.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldTelefone.setEnabled(false);
        if (this.pac == null) {
            jButtonSalvar.setEnabled(false);
        }
    }

    public TelaCadastroConsulta(Paciente paciente) {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
        this.pac = paciente;
        this.con = new Consulta();
        jTextFieldCodigo.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldTelefone.setEnabled(false);

        jTextFieldCodigo.setText(this.pac.getIdpaciente().toString());
        jTextFieldNome.setText(this.pac.getNome());
        jTextFieldTelefone.setText(this.pac.getTelefone1());
    }

    public TelaCadastroConsulta(Consulta consulta) {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
        this.con = consulta;
        this.pac = this.con.getIdpaciente();
        jTextFieldCodigo.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldTelefone.setEnabled(false);

        jButtonPesquisar.setEnabled(false);
        jTextFieldCodigo.setText(this.pac.getIdpaciente().toString());
        jTextFieldNome.setText(this.pac.getNome());
        jTextFieldTelefone.setText(this.pac.getTelefone1());
        jDateChooserData.setDate(this.con.getDataConsulta());
        selecionaHora(this.con.getHoraConsulta());
        jCheckBox1.setSelected(this.con.getCompareceu());

    }

    private void selecionaHora(Date hora) {
        Date dHora = hora;
        int iHora = 0;
        int iMin = 0;
        iHora = Datas.getHour(dHora);
        iMin = Datas.getMinute(dHora);

        for (int i = 0; i < jComboBoxHora.getItemCount(); i++) {
            Integer sHora = Integer.parseInt(jComboBoxHora.getItemAt(i).toString());
            if (sHora.equals(iHora)) {
                jComboBoxHora.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < jComboBoxMin.getItemCount(); i++) {
            Integer sMin = Integer.parseInt(jComboBoxMin.getItemAt(i).toString());
            if (sMin.equals(iMin)) {
                jComboBoxMin.setSelectedIndex(i);
                break;
            }
        }

    }

    private void preecheComboMinutos() {
        Vector<String> minutos = new Vector();
        for (Integer i = 0; i < 60; i++) {
            jComboBoxMin.addItem(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = ConnectionFactory.getEntityManager();
        tipoConsultaQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT t FROM TipoConsulta t");
        tipoConsultaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tipoConsultaQuery.getResultList();
        tipoConsultaListCellRenderer1 = new renderizadores.TipoConsultaListCellRenderer();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBoxTipoConsulta = new javax.swing.JComboBox();
        jDateChooserData = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxHora = new javax.swing.JComboBox();
        jComboBoxMin = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        tipoConsultaListCellRenderer1.setText("tipoConsultaListCellRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 390));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 350));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Consulta");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/agenda_remover_32.png"))); // NOI18N
        jButtonExcluir.setMnemonic('x');
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setToolTipText("Excluir consulta");
        jButtonExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/salvar.png"))); // NOI18N
        jButtonSalvar.setMnemonic('A');
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setToolTipText("Salvar consulta");
        jButtonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/sair.png"))); // NOI18N
        jButtonSair.setMnemonic('S');
        jButtonSair.setText("Sair");
        jButtonSair.setToolTipText("Sair");
        jButtonSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/paciente_pesquisar32.png"))); // NOI18N
        jButtonPesquisar.setMnemonic('P');
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setToolTipText("Pesquisar paciente");
        jButtonPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jComboBoxTipoConsulta.setRenderer(tipoConsultaListCellRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tipoConsultaList, jComboBoxTipoConsulta);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel2.setText("Tipo de Consulta");

        jLabel3.setText("Data");

        jComboBoxHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        jComboBoxMin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "15", "30", "45" }));
        jComboBoxMin.removeAllItems();
        this.preecheComboMinutos();

        jLabel4.setText("Hora");

        jLabel5.setText("Código");

        jLabel6.setText("Nome");

        jLabel7.setText("Telefone");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Compareceu");
        jCheckBox1.setToolTipText("Marcar se o paciente compareceu à consulta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBoxTipoConsulta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(121, 121, 121))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(52, 52, 52)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (this.pac != null) {
            Consulta c;
            if (this.con.getIdconsulta() == null) {
                c = new Consulta();
            } else {
                c = this.con;
            }

            ConsultaDAO cDAO = new ConsultaDAO();
            c.setIdpaciente(this.pac);
            c.setIdtipoConsulta((TipoConsulta) jComboBoxTipoConsulta.getSelectedItem());
            c.setDataConsulta(jDateChooserData.getDate());
            c.setHoraConsulta(Datas.getTimeDataBase((String) jComboBoxHora.getSelectedItem(), jComboBoxMin.getSelectedItem().toString(), "00"));
            c.setCompareceu(jCheckBox1.isSelected());
            boolean inseriu = false;
            try {
                if (c.getIdconsulta() == null) {
                    inseriu = cDAO.inserir(c);
                } else {
                    inseriu = cDAO.alterar(c, true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastroConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (inseriu) {
                this.dispose();
            }
        }


    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int excluir = JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja excluir essa consulta?");
        if (excluir == 0) {
            if (this.pac.getIdpaciente() != null) {
                ConsultaDAO cDAO = new ConsultaDAO();
                try {
                    cDAO.excluir(this.con);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        new TelaListaPacientes("cadastro_consulta").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBoxHora;
    private javax.swing.JComboBox jComboBoxMin;
    private javax.swing.JComboBox jComboBoxTipoConsulta;
    private com.toedter.calendar.JDateChooser jDateChooserData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTelefone;
    private java.util.List<model.TipoConsulta> tipoConsultaList;
    private renderizadores.TipoConsultaListCellRenderer tipoConsultaListCellRenderer1;
    private javax.persistence.Query tipoConsultaQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
