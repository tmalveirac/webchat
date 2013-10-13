/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.view;

import br.ifce.ppd.com.Cliente;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author malveira
 */
public class Aba2 extends JPanel{
    

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtEnviar;
    private javax.swing.JTextArea jtaMensagem;
    private javax.swing.JTextField jtfMensagem;
    private javax.swing.JButton jbtFecharAba;
    private Cliente cliente;
    private String loginRemoto;
    
    
    public Aba2(String loginRemoto, Cliente cliente){
       
        this.cliente=cliente;
        this.loginRemoto=loginRemoto;
               
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMensagem = new javax.swing.JTextArea();
        jtfMensagem = new javax.swing.JTextField();
        jbtEnviar = new javax.swing.JButton();
        jbtFecharAba = new javax.swing.JButton();

        jtaMensagem.setColumns(20);
        jtaMensagem.setRows(5);
        jScrollPane1.setViewportView(jtaMensagem);
        
        jtaMensagem.setCaretPosition(jtaMensagem.getDocument().getLength());


        jbtEnviar.setText("Enviar");
        jbtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEnviarActionPerformed(evt);
            }
        });
        
        jtfMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMensagemActionPerformed(evt);
            }
        });
        
        jbtFecharAba.setText("Fechar Aba");
        jbtFecharAba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFecharAbaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
        setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfMensagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtEnviar)
                        .addGap(26, 26, 26))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtFecharAba)
                .addContainerGap())
        );
        
       
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbtFecharAba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtEnviar))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        
        
        
    }
    
    private void jbtEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                          
         cliente.getInverterservice().enviarMensagem(cliente.getNome(),loginRemoto, jtfMensagem.getText());
         jtaMensagem.append(this.cliente.getNome() + " enviou: " + jtfMensagem.getText()+ "\n");
         jtfMensagem.setText("");
         
    }                                         

    private void jtfMensagemActionPerformed(java.awt.event.ActionEvent evt) {                                            
        jbtEnviarActionPerformed(evt);
    }
     
    private void jbtFecharAbaActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.err.println("clicou Fechar Aba");
        
        getParent().remove(this);
        Principal.getListaAbas().remove(this);
    }    
    

    public JTextArea getJtaMensagem() {
        return jtaMensagem;
    }

    public String getLoginRemoto() {
        return loginRemoto;
    }
    
    
    
    
}
