
package br.ifce.ppd.com;

import java.util.Vector;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ifce.ppd.com.ServidorItf")
public class ServidorImpl implements ServidorItf{
    
    //Armazena o login e as mensagens correspondentes num array de arrays
    private static Vector<Vector<String>> listaLoginMensagem = new Vector<Vector<String>>();
    
    
    public String inverter(String msg) {
        StringBuffer strbuf = new StringBuffer(msg);
        System.out.println("Recebido: "+msg);
        String retorno = (strbuf.reverse()).toString();
        return retorno;
    }

    @Override
    public String cadastrar(String nome) {
        //Primeiro elemento de cada lista é o login. Após o login, são add as mensagens
        Vector<String> listaMensagem = new Vector<String>();
        listaMensagem.add(nome);
        listaLoginMensagem.add(listaMensagem);
        return nome+"-cadastrado";
    }

    @Override
    public String login(String nome) {
        return nome+"-logado";
    }

    @Override
    public String enviarMensagem(String origem, String destino, String msg) {
        for (Vector l : listaLoginMensagem){
            if (l.get(0).equals(destino)){
                l.add(origem+"#"+msg); //tiago|mesagem
                System.err.println("Mensagem enviada - Origem: " + origem + "Mensagem: "+msg);
                break;
            }
        }
                
        return "msg enviada";
    }

    @Override
    public Vector<String> getMensagens(String nome) {
        Vector<String> array = new Vector<String>();
        for (Vector l : listaLoginMensagem){
            if (l.get(0).equals(nome)){           
                for (int i=1; i<l.size();i++)  {
                    array.add((String) l.get(i));
                }
                l.clear();
                l.add(nome);
                break;
            }
        }
        return array;
    }

    @Override
    public Vector<String> getUsuarios() {
        Vector<String> res = new Vector<String>();
        
        for (Vector l : listaLoginMensagem){
            res.add((String) l.get(0));
        }
        
        return res;
    }

    @Override
    public boolean usuarioJaCadastrado(String nome) {
                
        for (Vector l : listaLoginMensagem){
            if (l.get(0).equals(nome)){
                return true;
            }
        }
        
        return false;
    }

}

