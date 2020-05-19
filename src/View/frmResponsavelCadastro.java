/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.ResponsavelModel;
import Negocio.ResponsavelNegocio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johns
 */
public class frmResponsavelCadastro extends javax.swing.JDialog {

    private DefaultTableModel modelo = new DefaultTableModel();
    private ResponsavelNegocio responsavelNegocio = new ResponsavelNegocio();
    ResponsavelModel responsavelModel = new ResponsavelModel();

    private static Date CriarNovaData(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String ConvertaData(Date dataConsulta) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return formatter.format(dataConsulta);

        } catch (Exception e) {
            return null;
        }
    }
    
    private void CriarTblResponsavel() {
        tblResponsavel = new JTable(modelo);
        modelo.addColumn("Matricula");
        modelo.addColumn("CPF");
        modelo.addColumn("Nome");
        modelo.addColumn("Sobrenome");
        modelo.addColumn("Data Nasc.");
        modelo.addColumn("E-mail");
        modelo.addColumn("Telefone");

        tblResponsavel.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblResponsavel.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblResponsavel.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblResponsavel.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblResponsavel.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblResponsavel.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblResponsavel.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void ConsultaResponsavel() {

        modelo.setNumRows(0);
        List<ResponsavelModel> listaResponsavel = new ArrayList<ResponsavelModel>();

        listaResponsavel = responsavelNegocio.ObterConsulta();

        if (listaResponsavel.size() > 0) {

            for (int i = 0; i < listaResponsavel.size(); i++) {
                modelo.addRow(new Object[]{listaResponsavel.get(i).getId(),
                    listaResponsavel.get(i).getCpf(),
                    listaResponsavel.get(i).getFirstName(),
                    listaResponsavel.get(i).getLastName(),
                    listaResponsavel.get(i).getDob(),
                    listaResponsavel.get(i).getEmail(),
                    listaResponsavel.get(i).getTelefone()});
            }
        } else {
            modelo.setNumRows(0);
        }
    }

    private void LimparCampos() {
        responsavelModel = new ResponsavelModel();

        txtCPF.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        txtDataNascimento.setText(new String());
        txtEmail.setText("");
        txtTelefone.setText("");

        btnSalvar.setLabel("SALVAR");
    }

    private void PreencheCampos(int id) {
        if (id > 0) {
            responsavelModel = responsavelNegocio.ObterResponsavelPorId(id);
            txtCPF.setText(responsavelModel.getFirstName());
            txtNome.setText(responsavelModel.getFirstName());
            txtSobrenome.setText(responsavelModel.getLastName());
            txtDataNascimento.setText(ConvertaData(responsavelModel.getDob()));
            txtEmail.setText(responsavelModel.getEmail());
            txtTelefone.setText(responsavelModel.getTelefone());

            btnSalvar.setLabel("EDITAR");

        } else {
            btnSalvar.setLabel("SALVAR");
        }
    }

    
    /**
     * Creates new form frmResponsavelCadastro
     */
    public frmResponsavelCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        CriarTblResponsavel();
        ConsultaResponsavel();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSobrenome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResponsavel = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setText("E-Mail:");

        tblResponsavel.setModel(modelo);
        tblResponsavel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResponsavelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResponsavel);

        btnNovo.setText("LIMPAR");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Responsavel");

        jLabel2.setText("Nome:");

        jLabel3.setText("Data de Nascimento:");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("CPF:");

        jLabel5.setText("Sobrenome:");

        jLabel7.setText("Telefone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtCPF))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSobrenome)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtTelefone))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(228, 228, 228))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResponsavelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResponsavelMouseClicked
        // TODO add your handling code here:
        int linha = tblResponsavel.getSelectedRow();
        Integer codigo = (Integer) tblResponsavel.getValueAt(linha, 0);
        PreencheCampos((int) codigo);
    }//GEN-LAST:event_tblResponsavelMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        LimparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        try {

            responsavelModel.setCpf(txtCPF.getText());
            responsavelModel.setFirstName(txtNome.getText());
            responsavelModel.setLastName(txtSobrenome.getText());
            responsavelModel.setDob(CriarNovaData(txtDataNascimento.getText()));
            responsavelModel.setEmail(txtEmail.getText());
            responsavelModel.setTelefone(txtTelefone.getText());

            if (btnSalvar.getLabel().equals("SALVAR")) {
                responsavelNegocio.Adicionar(responsavelModel);
            } else {
                responsavelNegocio.Alterar(responsavelModel);
            }

            ConsultaResponsavel();
            LimparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção!!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            responsavelNegocio.Remover(responsavelNegocio.ObterResponsavelPorId(responsavelModel.getId()));
        } catch (Exception ex) {
            Logger.getLogger(frmAlunoCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConsultaResponsavel();
        LimparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(frmResponsavelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmResponsavelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmResponsavelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmResponsavelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmResponsavelCadastro dialog = new frmResponsavelCadastro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResponsavel;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSobrenome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
