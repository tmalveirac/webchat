
package br.ifce.ppd.com;

import br.ifce.ppd.com.corba.MensagemJMSHelper;
import br.ifce.ppd.com.corba.MensagemJMS;
import java.util.Vector;
import javax.jws.WebService;
//Corba
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
//

@WebService(endpointInterface = "br.ifce.ppd.com.ServidorItf")
public class ServidorImpl implements ServidorItf{
    
    //Armazena o login e as mensagens correspondentes num array de arrays
    private static Vector<Vector<String>> listaLoginMensagem = new Vector<Vector<String>>();
    private static Vector<String> listaLogin = new Vector<String>();
    
    @Override
    public String inverter(String msg) {
        StringBuffer strbuf = new StringBuffer(msg);
        System.out.println("Recebido: "+msg);
        String retorno = (strbuf.reverse()).toString();
        return retorno;
    }

    @Override
    public String cadastrar(String nome) {
        //Primeiro elemento de cada lista é o login. Após o login, são add as mensagens
        //Vector<String> listaMensagem = new Vector<String>();
        //listaMensagem.add(nome);
        //listaLoginMensagem.add(listaMensagem);
        
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
        return nome+"-logado";
    }

    @Override
    public String enviarMensagem(String origem, String destino, String msg) {
        /*
        for (Vector l : listaLoginMensagem){
            if (l.get(0).equals(destino)){
                l.add(origem+"#"+msg); //tiago|mesagem
                System.err.println("Mensagem enviada - Origem: " + origem + "Mensagem: "+msg);
                enviarMensagemJMS(destino, origem+"#"+msg);
                break;
            }
        }
        */
        
        enviarMensagemJMS(destino, origem+"#"+msg);
                
        return "msg enviada";

    }

    @Override
    public Vector<String> getMensagens(String nome) {
        Vector<String> array = new Vector<String>();
        
        String msg = receberMensagensJMS(nome);
        
        System.err.println("Mensagem : " + msg);
        /*
        for (Vector l : listaLoginMensagem){
            if (l.get(0).equals(nome)){  
                System.err.println("getMensagens " + l.get(0));
                for (int i=1; i<l.size();i++)  {
                    array.add(l.get(i).toString());
                }
                l.clear();
                l.add(nome);
                break;
            }
        }
        */
        array.add(msg);
        return array;
        
        //Buscar mensagens na Fila
    }

    @Override
    public Vector<String> getUsuarios() {
        //Vector<String> res = new Vector<String>();
        /*
        for (Vector l : listaLoginMensagem){
            res.add((String) l.get(0));
        }
        * */
        
        return listaLogin;
    }

    @Override
    public boolean usuarioJaCadastrado(String nome) {
        /*        
        for (Vector l : listaLoginMensagem){
            if (l.get(0).equals(nome)){
                return true;
            }
        }
        */ 
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
    
    

}

