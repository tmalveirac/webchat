/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.view;

import javax.swing.JPanel;

/**
 *
 * @author malveira
 */
public class Aba2 extends JPanel{
    

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtEnviar;
    private javax.swing.JTextArea jtaMensagem;
    private javax.swing.JTextField jtfMensagem;
    
    
    public Aba2(){
       
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMensagem = new javax.swing.JTextArea();
        jtfMensagem = new javax.swing.JTextField();
        jbtEnviar = new javax.swing.JButton();

       

        jtaMensagem.setColumns(20);
        jtaMensagem.setRows(5);
        jScrollPane1.setViewportView(jtaMensagem);

        jbtEnviar.setText("Enviar");

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
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtEnviar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

    }
    
}
