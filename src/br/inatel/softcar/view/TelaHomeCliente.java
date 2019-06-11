/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.softcar.view;

import br.inatel.softcar.model.UsuarioDAO;
import br.inatel.softcar.model.Vagas;
import br.inatel.softcar.model.VagasDAO;
import br.inatel.softcar.model.VeiculoDAO;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Brener
 */
public class TelaHomeCliente extends javax.swing.JFrame {

    int idUsuarioLogado;
    int idVagaOcupada;
    JRadioButton[] vetorBotoes = new JRadioButton[12];

    /**
     * Creates new form TelaHomeCliente
     */
    public TelaHomeCliente(int id) {
        initComponents();
        setLocationRelativeTo(null);
        idUsuarioLogado = id;
        vetorBotoes[0] = jRadioButton1;
        vetorBotoes[1] = jRadioButton2;
        vetorBotoes[2] = jRadioButton3;
        vetorBotoes[3] = jRadioButton4;
        vetorBotoes[4] = jRadioButton5;
        vetorBotoes[5] = jRadioButton6;
        vetorBotoes[6] = jRadioButton7;
        vetorBotoes[7] = jRadioButton8;
        vetorBotoes[8] = jRadioButton9;
        vetorBotoes[9] = jRadioButton10;
        vetorBotoes[10] = jRadioButton11;
        vetorBotoes[11] = jRadioButton12;
        carregaDadosTela();
        carregarDadosVagas();
        carregaDadosVeiculo();

    }

    private TelaHomeCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void carregaDadosTela() {
        UsuarioDAO dao = new UsuarioDAO();
        jLabelPilotoVeiculo.setText(dao.carregaDadosTelaCliente(idUsuarioLogado));
    }

    private void carregaDadosVeiculo() {
        ArrayList<String> listaVeiculos = new ArrayList();
        DefaultListModel model = new DefaultListModel();

        UsuarioDAO dao = new UsuarioDAO();
        listaVeiculos = dao.carregarVeiculos(idUsuarioLogado);
        for (int i = 0; i < listaVeiculos.size(); i++) {
            model.add(i, listaVeiculos.get(i));
        }
        jListVeiculos.setModel(model);
    }

    private void carregarDadosVagas() {

        ArrayList<Integer> listaVagas = new ArrayList();

        ButtonGroup jRadioGroupLivres = new javax.swing.ButtonGroup();

        VagasDAO dao = new VagasDAO();
        listaVagas = dao.lerEstacionamento();

        for (int i = 0; i < 12; i++) {
            if (listaVagas.get(i) == 1) {
                vetorBotoes[i].setSelected(true);
                vetorBotoes[i].setEnabled(false);
            } else if (listaVagas.get(i) == 0) {
                jRadioGroupLivres.add(vetorBotoes[i]);
                vetorBotoes[i].setSelected(false);
                vetorBotoes[i].setEnabled(true);
            }
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

        jPanelOverviewEstacionamento = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonOcuparVaga = new javax.swing.JButton();
        jButtonDesocuparVaga = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelModeloVeiculo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelPlacaVeiculo = new javax.swing.JLabel();
        jButtonTrocarVeiculo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabelTipoVeiculo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelPilotoVeiculo = new javax.swing.JLabel();
        jButtonSairCliente = new javax.swing.JButton();
        jButtonCadastrarVeiculo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListVeiculos = new javax.swing.JList<>();
        jButtonDeletarVeiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelOverviewEstacionamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton1.setText("A1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanelOverviewEstacionamento.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 40, 20));

        jRadioButton2.setText("A2");
        jPanelOverviewEstacionamento.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 40, -1));

        jRadioButton3.setText("A3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanelOverviewEstacionamento.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 50, -1));

        jRadioButton4.setText("A4");
        jPanelOverviewEstacionamento.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 50, -1));

        jRadioButton5.setText("A5");
        jPanelOverviewEstacionamento.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 50, -1));

        jRadioButton6.setText("A6");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        jPanelOverviewEstacionamento.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 50, -1));

        jRadioButton7.setText("B7");
        jPanelOverviewEstacionamento.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        jRadioButton8.setText("B8");
        jPanelOverviewEstacionamento.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jRadioButton9.setText("B9");
        jPanelOverviewEstacionamento.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        jRadioButton10.setText("B10");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });
        jPanelOverviewEstacionamento.add(jRadioButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        jRadioButton11.setText("B11");
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });
        jPanelOverviewEstacionamento.add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));

        jRadioButton12.setText("B12");
        jPanelOverviewEstacionamento.add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brener\\Desktop\\INATEL\\EC 206 - Engenharia de Software II\\Projeto\\SoftCar\\Screenshot_1.png")); // NOI18N
        jPanelOverviewEstacionamento.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 780, 330));

        jLabel1.setText("Mapa do Estacionamento");

        jButtonOcuparVaga.setText("Ocupar Vaga");
        jButtonOcuparVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOcuparVagaActionPerformed(evt);
            }
        });

        jButtonDesocuparVaga.setText("Desocupar Vaga");
        jButtonDesocuparVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesocuparVagaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estacionamento cliente");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Modelo do Veículo:");

        jLabelModeloVeiculo.setText("    ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Placa:");

        jLabelPlacaVeiculo.setText("               ");

        jButtonTrocarVeiculo.setText("Trocar de Veículo");
        jButtonTrocarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrocarVeiculoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tipo:");

        jLabelTipoVeiculo.setText("                 ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Piloto:");

        jLabelPilotoVeiculo.setText("      ");

        jButtonSairCliente.setText("Sair");
        jButtonSairCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairClienteActionPerformed(evt);
            }
        });

        jButtonCadastrarVeiculo.setText("Cadastrar Veículo");
        jButtonCadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarVeiculoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListVeiculos);

        jButtonDeletarVeiculo.setText("Deletar Veículo");
        jButtonDeletarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarVeiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addGap(289, 289, 289)
                .addComponent(jButtonDeletarVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelOverviewEstacionamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(jButtonOcuparVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(jButtonDesocuparVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(251, 251, 251)
                                        .addComponent(jLabel2)
                                        .addGap(245, 245, 245))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(242, 242, 242)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelTipoVeiculo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelPilotoVeiculo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelPlacaVeiculo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButtonTrocarVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonSairCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonCadastrarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(89, 89, 89)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonTrocarVeiculo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCadastrarVeiculo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSairCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelModeloVeiculo)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPlacaVeiculo)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabelTipoVeiculo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPilotoVeiculo)
                                    .addComponent(jLabel9))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonDeletarVeiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelOverviewEstacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDesocuparVaga)
                    .addComponent(jButtonOcuparVaga))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTrocarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrocarVeiculoActionPerformed
        // TODO add your handling code here:
        String modelo = jListVeiculos.getSelectedValue();
        String tipo = jListVeiculos.getSelectedValue();
        String placa = jListVeiculos.getSelectedValue();
        modelo = modelo.substring(8, modelo.length() - 5).trim();
        placa = placa.substring(0, 8).trim();
        tipo = tipo.substring(tipo.length() - 5, tipo.length()).trim();
        jLabelModeloVeiculo.setText(modelo);
        jLabelPlacaVeiculo.setText(placa);
        jLabelTipoVeiculo.setText(tipo);
    }//GEN-LAST:event_jButtonTrocarVeiculoActionPerformed

    private void jButtonSairClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairClienteActionPerformed
        TelaInicial ti = new TelaInicial();
        ti.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSairClienteActionPerformed

    private void jButtonCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarVeiculoActionPerformed
        // TODO add your handling code here:
        CadastroVeiculo cv = new CadastroVeiculo(idUsuarioLogado);
        cv.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonCadastrarVeiculoActionPerformed

    private void jButtonOcuparVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOcuparVagaActionPerformed
        // TODO add your handling code here:

        VagasDAO dao = new VagasDAO();

        for (int i = 0; i < 12; i++) {
            if (vetorBotoes[i].isSelected() && vetorBotoes[i].isEnabled()) {
                //idVagaOcupada = i;
                dao.alterarEstacionamento(i + 1, idUsuarioLogado);
            }
        }

        carregarDadosVagas();


    }//GEN-LAST:event_jButtonOcuparVagaActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jButtonDesocuparVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesocuparVagaActionPerformed
        // TODO add your handling code here:
        VagasDAO dao = new VagasDAO();
        dao.desocuparVaga(idUsuarioLogado);
        carregarDadosVagas();
    }//GEN-LAST:event_jButtonDesocuparVagaActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private void jButtonDeletarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarVeiculoActionPerformed
        // TODO add your handling code here:
        if (jListVeiculos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione algum campo");
        } else {
            VeiculoDAO dao = new VeiculoDAO();
            String placa = jListVeiculos.getSelectedValue();
            placa = placa.substring(0, 8);
            dao.deletarVeiculo(placa);

            carregaDadosVeiculo();

        }


    }//GEN-LAST:event_jButtonDeletarVeiculoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaHomeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHomeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHomeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHomeCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Pegar no banco as vagas ocupadas
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaHomeCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarVeiculo;
    private javax.swing.JButton jButtonDeletarVeiculo;
    private javax.swing.JButton jButtonDesocuparVaga;
    private javax.swing.JButton jButtonOcuparVaga;
    private javax.swing.JButton jButtonSairCliente;
    private javax.swing.JButton jButtonTrocarVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelModeloVeiculo;
    private javax.swing.JLabel jLabelPilotoVeiculo;
    private javax.swing.JLabel jLabelPlacaVeiculo;
    private javax.swing.JLabel jLabelTipoVeiculo;
    private javax.swing.JList<String> jListVeiculos;
    private javax.swing.JPanel jPanelOverviewEstacionamento;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
