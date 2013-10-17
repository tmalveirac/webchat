package br.ifce.ppd.com;

/**
 * Classe: ServidorImpl.java
 * Implementação do serviço (WebService) da aplicação
 * @author Tiago Malveira
 * 
 */

import br.ifce.ppd.com.corba.MensagemJMSHelper;
import br.ifce.ppd.com.corba.MensagemJMS;
import java.util.Vector;
import javax.jws.WebService;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;


@WebService(endpointInterface = "br.ifce.ppd.com.ServidorItf")
public class ServidorImpl implements ServidorItf{
   
    private static Vector<String> listaLogin = new Vector<String>();
    private static Vector<String> listaLogados = new Vector<String>();
    
   
    /**
    * Cadastra um usupario via WebService
    *
    * @param    nome        nome da fila
    * @return                            
    */
    @Override
    public String cadastrar(String nome) {
        
        
        //Criar uma fila no JMS
        if (!existeFilaJMS(nome)){
            System.err.println(nome+" Não está na Fila");
             if(criarFilaJMS(nome)){
                listaLogin.add(nome);
            }
        }
        else{
            System.err.println(nome+" Está na Fila");
            boolean estaNaLista = false;
            for (String s : listaLogin){
                if(s.equals(nome)){
                    estaNaLista=true;
                }
            }
            if (!estaNaLista)
                listaLogin.add(nome);
        }
              
        System.out.println("Chamou Corba!");
        
        return nome+"-cadastrado";
    }

    @Override
    public String login(String nome) {
        listaLogados.add(nome);
        return nome+"-logado";
    }
    
    @Override
    public String logout(String nome) {
        listaLogados.remove(nome);
        return nome+"-logado";
    }

    /**
    * Envia uma mensagem via WebService
    *
    * @param    nome        nome da fila
    * @return                            
    */
    @Override
    public String enviarMensagem(String origem, String destino, String msg) {
        
        //Envia mensagem para uma fila JMS
        enviarMensagemJMS(destino, origem+"#"+msg);
                
        return "msg enviada";

    }

    /**
    * Recebe uma mensagem via WebService
    *
    * @param    nome        nome da fila
    * @return               Vector de mensagens             
    */
    @Override
    public Vector<String> getMensagens(String nome) {
        Vector<String> array = new Vector<String>();
        
        //Busca mensagem na fila do JMS
        String msg = receberMensagensJMS(nome);
        
        System.out.println("Mensagem : " + msg);
       
        array.add(msg);
        return array;
       
    }

    @Override
    public Vector<String> getUsuarios() {       
        return listaLogin;
    }
    
    /**
    * Verifica se um usuário está cadastrado
    *
    * @param    nome        nome do usuário
    * @return               true, se o usuário está cadastrado. Caso contrário, false             
    */
    @Override
    public boolean usuarioJaCadastrado(String nome) {
         
        for (String l : listaLogin){
            if (l.equals(nome)){
                return true;
            }
        }
        
        if (existeFilaJMS(nome)){
            listaLogin.add(nome);
            return true;
        }
        
        return false;
    }
   
    /**
    * Verifica se uma fila existe no JMS via corba
    *
    * @param    nome        nome da fila
    * @return               true, caso exista. Caso contrário, false             
    */    
    public boolean existeFilaJMS(String nome) {
       try{
            ORB orb = ORB.init(new String[]{},null);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            NameComponent[] name = {new NameComponent("MensagemJMS","Exemplo")};
            org.omg.CORBA.Object objRef = naming.resolve(name);
            MensagemJMS msgJMS = MensagemJMSHelper.narrow(objRef);
            
            System.out.println("Executou o Cliente!");
            return msgJMS.existeFila(nome);
            

        }
        catch (Exception e){
            System.out.println("ERRO Existe FILA!");
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
            
        }
        return false;
    }
    
    /**
    * Cria uma fila JMS via corba
    *
    * @param    nome        nome da fila
    * @return               true, se a fila foi criada. Caso contrário, false.          
    */ 
    public boolean criarFilaJMS(String nome) {
       try{
            ORB orb = ORB.init(new String[]{},null);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            NameComponent[] name = {new NameComponent("MensagemJMS","Exemplo")};
            org.omg.CORBA.Object objRef = naming.resolve(name);
            MensagemJMS msgJMS = MensagemJMSHelper.narrow(objRef);
            
            System.out.println("Executou o Cliente!");
            return msgJMS.criarFila(nome);
            

        }
        catch (Exception e){
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
        return false;
    }
    
    /**
    * Envia uma mensagem do JMS via corba
    *
    * @param    dest        nome da fila
    * @param    msg         mensagem
    * @return   void         
    */
    public void enviarMensagemJMS(String dest, String msg) {
        try{
            ORB orb = ORB.init(new String[]{},null);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            NameComponent[] name = {new NameComponent("MensagemJMS","Exemplo")};
            org.omg.CORBA.Object objRef = naming.resolve(name);
            MensagemJMS msgJMS = MensagemJMSHelper.narrow(objRef);
            
            System.out.println("Executou o Cliente!");
          
            
            msgJMS.escreverMensagem(dest,msg);

        }
        catch (Exception e){
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
        
    }
    
    /**
    * Recebe uma mensagem do JMS via corba
    *
    * @param    nome        nome da fila
    * @return               mensagem lida             
    */
    public String receberMensagensJMS(String nome) {
        try{
            ORB orb = ORB.init(new String[]{},null);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            NameComponent[] name = {new NameComponent("MensagemJMS","Exemplo")};
            org.omg.CORBA.Object objRef = naming.resolve(name);
            MensagemJMS msgJMS = MensagemJMSHelper.narrow(objRef);
            
            System.out.println("Executou o Cliente!");
           
            return msgJMS.getMensagem(nome);       

        }
        catch (Exception e){
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
        
        return "";
        
    }

    @Override
    public Vector<String> getUsuariosLogados() {
        return listaLogados;
    }
   
}

