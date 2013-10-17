package br.ifce.ppd.view;

/**
 * Classe: Login.java
 * View Login do chat
 * @author Tiago Malveira
 * 
 */

import br.ifce.ppd.com.Cliente;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    private Cliente cliente;

    public Login() {
        initComponents();
        cliente = new Cliente();
        
        getRootPane().setDefaultButton(jbtEntrar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfLogin = new javax.swing.JTextField();
        jbtEntrar = new javax.swing.JButton();
        jbtCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtEntrar.setText("Entrar");
        jbtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEntrarActionPerformed(evt);
            }
        });

        jbtCadastrar.setText("Cadastrar");
        jbtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Login:");

        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jtfLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jbtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtEntrar)
                    .addComponent(jbtCadastrar)
                    .addComponent(jbtSair))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastrarActionPerformed
        String nome = jtfLogin.getText();
        if (cliente.getInverterservice().usuarioJaCadastrado(nome)){
            cliente.setNome(nome);
            JOptionPane.showMessageDialog(null, "Usuário Já Cadastrado! "
                    + "Clique em entrar! ","Aviso",  JOptionPane.WARNING_MESSAGE);
        }
        else{
            cliente.getInverterservice().cadastrar(nome);
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso! "
                    + "Clique em entrar! ","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
                   
        
    }//GEN-LAST:event_jbtCadastrarActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEntrarActionPerformed
        String nome = jtfLogin.getText();
         if (cliente.getInverterservice().usuarioJaCadastrado(nome)){
            cliente.setNome(nome);
            this.setVisible(false);
            new Principal(cliente).setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuário não Cadastrado! "
                    + "Clique em Cadastrar! ","Aviso",  JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jbtEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtCadastrar;
    private javax.swing.JButton jbtEntrar;
    private javax.swing.JButton jbtSair;
    private javax.swing.JTextField jtfLogin;
    // End of variables declaration//GEN-END:variables
}
