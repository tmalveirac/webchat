package br.ifce.ppd.view;

/**
 * Classe: Principal.java
 * View Principal do Chat
 * @author Tiago Malveira
 * 
 */

import br.ifce.ppd.com.Cliente;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class Principal extends javax.swing.JFrame {

    public Principal(final Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        cliente.getInverterservice().cadastrar(cliente.getNome());
        Vector<String> lista = cliente.getInverterservice().getUsuarios();
        insereListaChat(lista);   

        jltUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setTitle(cliente.getNome());
        
        
        //Thread que escuta se chegou mensagens 
        new Thread(new Runnable() {
            public void run() {
                //System.err.println(jltUsuario.getSelectedValue().toString());
                while(true){
                    Vector<String> resp =  cliente.getInverterservice().getMensagens(cliente.getNome());
                    insereListaChat(cliente.getInverterservice().getUsuarios());
                    if (resp.size()>0){
                         for (String s : resp){
                             String msg[] = s.split("#");
                             String origem = msg[0];
                             String mensagem = msg[1];
                             System.out.println("Origem: " + origem + " mensagem: "+mensagem);
                             Boolean existeAba = false;
                             for (Aba2 a : listaAbas){
                                 if(a.getLoginRemoto().equals(origem)){
                                     a.getJtaMensagem().append(origem+" enviou: "+mensagem+"\n");
                                     existeAba=true;
                                     break;
                                 }                     
                                 
                             }
                             if (!existeAba) {
                                Aba2 aba = new Aba2(origem,cliente);
                                jtpPainelAbas.addTab(origem,aba);
                                listaAbas.add(aba);
                                aba.getJtaMensagem().append(origem+" enviou: "+mensagem+"\n");
                             }
                             
                         }
                    }                  
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jbtIniciarConversa = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jltUsuario = new javax.swing.JList();
        jtpPainelAbas = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jbtIniciarConversa.setText("Iniciar Conversa");
        jbtIniciarConversa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIniciarConversaActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jltUsuario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtIniciarConversa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtIniciarConversa))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtpPainelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtpPainelAbas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtIniciarConversaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIniciarConversaActionPerformed
        if (jltUsuario.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um contato!"
                    ,"Aviso",  JOptionPane.WARNING_MESSAGE);
            return;
        }
        String nomeSelecionado = jltUsuario.getSelectedValue().toString();
        
        boolean existeAba = false;
        //Verifica se já há aba aberta
        for (Aba2 a : listaAbas){
            if(a.getLoginRemoto().equals(nomeSelecionado)){
                existeAba = true;
                break;
            }
        }
        if (!existeAba){
            Aba2 aba = new Aba2(nomeSelecionado,cliente);
            jtpPainelAbas.addTab(nomeSelecionado,aba);
            listaAbas.add(aba);
        }
        else{
            JOptionPane.showMessageDialog(null, "Já existe uma aba aberta com este contato!"
                    ,"Aviso",  JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbtIniciarConversaActionPerformed


    
   
    
    /**
    * Insere um nome na lista de login do Chat
    *             
    * @param nome   nome a ser inserido na lista do chat
    * @return       void
    */
    public  void insereListaChat(Vector<String> listaLogin){
        
        for (String s : listaLogin){
            if (idNomeListaChat(s) == -1 && !s.equals(this.cliente.getNome())) {
                listModel.addElement(s);
                jltUsuario.setModel(listModel);
            }
        }
        
        
    }    
    
   
    
    /**
    * Identifica o id de um nome na lista do chat
    *             
    * @param    nome   nome a ser buscado na lista de login do chat
    * @return   void   indice i do nome da lista, se existir. -1, caso contrário 
    */
    public static int idNomeListaChat(String nome){
        
        for (int i=0; i<listModel.getSize();i++){
            if (listModel.get(i).toString().equals(nome)){
                return i;
            }
        }
        return -1;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtIniciarConversa;
    private static javax.swing.JList jltUsuario;
    private javax.swing.JTabbedPane jtpPainelAbas;
    // End of variables declaration//GEN-END:variables
    private Cliente cliente;
    private static Vector<Aba2> listaAbas = new  Vector<Aba2>();
    private static DefaultListModel  listModel = new DefaultListModel();    

    public Cliente getCliente() {
        return cliente;
    }

    public static Vector<Aba2> getListaAbas() {
        return listaAbas;
    }
    
    
}
