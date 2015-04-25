/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultaDAO;
import dao.PacienteDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Consulta;
import utilidades.ConfigTelas;
import utilidades.ConnectionFactory;
import utilidades.Datas;

/**
 *
 * @author Nasser
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPadrao
     */
    Date data;

    public TelaPrincipal() {
        this.data = Datas.getCurrentTime();
        initComponents();
        jDateChooserData.setDate(this.data);
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
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
        consultaQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createNamedQuery("Consulta.findByDataConsulta").setParameter("dataConsulta", this.data);
        consultaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(consultaQuery.getResultList());
        consultaColunaHoraRenderer1 = new renderizadores.ConsultaColunaHoraRenderer();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonVisualizar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonConvenios = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonPacientes = new javax.swing.JButton();
        jButtonNovaConsulta = new javax.swing.JButton();
        jButtonListaConsulta = new javax.swing.JButton();
        jDateChooserData = new com.toedter.calendar.JDateChooser();
        jButtonPesquisaConsulta = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ortomedic");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 697, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButtonVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/status_32.png"))); // NOI18N
        jButtonVisualizar.setMnemonic('I');
        jButtonVisualizar.setText("Visualizar");
        jButtonVisualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVisualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonVisualizar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/agenda_editar_32.png"))); // NOI18N
        jButtonEditar.setMnemonic('D');
        jButtonEditar.setText("Editar");
        jButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButtonEditar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/sair.png"))); // NOI18N
        jButtonSair.setMnemonic('S');
        jButtonSair.setText("Sair");
        jButtonSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/salvar.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setEnabled(true);
        jButtonGravar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGravar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVisualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGravar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 477, 740, -1));

        jButtonConvenios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/contato.png"))); // NOI18N
        jButtonConvenios.setText("Convênios");
        jButtonConvenios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonConvenios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConveniosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonConvenios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 175, 40));

        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/usuarios.png"))); // NOI18N
        jButtonUsuarios.setText("Usuários");
        jButtonUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 175, 40));

        jButtonPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/paciente_32.png"))); // NOI18N
        jButtonPacientes.setText("Pacientes");
        jButtonPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPacientesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 295, 175, 40));

        jButtonNovaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/agenda_adiciona.png"))); // NOI18N
        jButtonNovaConsulta.setText("Cadastrar Consulta");
        jButtonNovaConsulta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonNovaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNovaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, 175, 40));

        jButtonListaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/agenda.png"))); // NOI18N
        jButtonListaConsulta.setText("Lista Consultas");
        jButtonListaConsulta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonListaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonListaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 175, 40));
        jPanel1.add(jDateChooserData, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 90, 187, -1));

        jButtonPesquisaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones32/pesquisar2.png"))); // NOI18N
        jButtonPesquisaConsulta.setText("Pesquisar");
        jButtonPesquisaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPesquisaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 116, -1));

        jComboBox1.setVisible(false);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, consultaList, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 423, 125, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setMaximumSize(new java.awt.Dimension(330, 0));
        jTable1.setMinimumSize(new java.awt.Dimension(330, 0));
        jTable1.setRequestFocusEnabled(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, consultaList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idpaciente.nome}"));
        columnBinding.setColumnName("Paciente");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataConsulta}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${horaConsulta}"));
        columnBinding.setColumnName("Hora");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${compareceu}"));
        columnBinding.setColumnName("Compareceu");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idtipoConsulta.descricao}"));
        columnBinding.setColumnName("Tipo Consulta");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(consultaColunaHoraRenderer1);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 530, 333));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 600, 355));

        jLabel2.setText("Consultas maracadas para o dia:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        new TelaListaUsuarios().setVisible(true);
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonConveniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConveniosActionPerformed
        new TelaListaConvenio().setVisible(true);
    }//GEN-LAST:event_jButtonConveniosActionPerformed

    private void jButtonPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPacientesActionPerformed
        new TelaListaPacientes().setVisible(true);
    }//GEN-LAST:event_jButtonPacientesActionPerformed

    private void jButtonNovaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaConsultaActionPerformed
        new TelaCadastroConsulta().setVisible(true);
    }//GEN-LAST:event_jButtonNovaConsultaActionPerformed

    private void jButtonListaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaConsultaActionPerformed
        new TelaListaConsultas().setVisible(true);
    }//GEN-LAST:event_jButtonListaConsultaActionPerformed

    private void jButtonPesquisaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaConsultaActionPerformed
        this.data = jDateChooserData.getDate();
        consultaQuery.setParameter("dataConsulta", this.data);
        consultaList.clear();
        consultaList.addAll(consultaQuery.getResultList());
        atualizaLista();
    }//GEN-LAST:event_jButtonPesquisaConsultaActionPerformed

    private void atualizaLista(){
        for(int i = 0 ; i < consultaList.size() ; i ++){
            this.entityManager.refresh(consultaList.get(i));
        }
    
    }
    private void jButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarActionPerformed
        if(jComboBox1.getSelectedIndex() != -1){
            PacienteDAO pdao = new PacienteDAO();
            Consulta c = (Consulta) jComboBox1.getSelectedItem();
            try {
                pdao.alterar(c.getIdpaciente(), false);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            new TelaConsultasPaciente(c.getIdpaciente(), c).setVisible(true);
        }

    }//GEN-LAST:event_jButtonVisualizarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed

        int sair = JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja sair do programa?");
        if (sair == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() > 1) {
            if(jComboBox1.getSelectedIndex() != -1){
            PacienteDAO pdao = new PacienteDAO();
            Consulta c = (Consulta) jComboBox1.getSelectedItem();
            try {
                pdao.alterar(c.getIdpaciente(), false);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            new TelaConsultasPaciente(c.getIdpaciente(), c).setVisible(true);
        }
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (jComboBox1.getSelectedIndex() != -1) {
                Consulta c = (Consulta) jComboBox1.getSelectedItem();
                new TelaCadastroConsulta(c).setVisible(true);
            }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        ConsultaDAO cDao = new ConsultaDAO();
        for(int i = 0 ; i < consultaList.size() ; i ++){
            try {
                cDao.alterar(consultaList.get(i), false);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Consultas atualizadas com êxito");
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private renderizadores.ConsultaColunaHoraRenderer consultaColunaHoraRenderer1;
    private java.util.List<model.Consulta> consultaList;
    private javax.persistence.Query consultaQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonConvenios;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonListaConsulta;
    private javax.swing.JButton jButtonNovaConsulta;
    private javax.swing.JButton jButtonPacientes;
    private javax.swing.JButton jButtonPesquisaConsulta;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JButton jButtonVisualizar;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooserData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}