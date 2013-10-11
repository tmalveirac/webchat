
package br.ifce.ppd.com;

import java.util.ArrayList;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ifce.ppd.com.ServidorItf")
public class ServidorImpl implements ServidorItf{
    
    //Armazena o login e as mensagens correspondentes num array de arrays
    private static ArrayList<ArrayList<String>> listaLoginMensagem = new ArrayList<ArrayList<String>>();
    
    
    public String inverter(String msg) {
        StringBuffer strbuf = new StringBuffer(msg);
        System.out.println("Recebido: "+msg);
        String retorno = (strbuf.reverse()).toString();
        return retorno;
    }

    @Override
    public String cadastrar(String nome) {
        //Primeiro elemento de cada lista é o login. Após o login, são add as mensagens
        ArrayList<String> listaMensagem = new ArrayList<String>();
        listaMensagem.add(nome);
        listaLoginMensagem.add(listaMensagem);
        return nome+"-cadastrado";
    }

    @Override
    public String login(String nome) {
        return nome+"-logado";
    }

    @Override
    public String enviarMensagem(String nome, String msg) {
        for (ArrayList l : listaLoginMensagem){
            if (l.get(0).equals(nome)){
                l.add(msg);
                break;
            }
        }
                
        return "msg enviada";
    }

    @Override
    public String getMensagem(String nome) {
        String res = "";
        for (ArrayList l : listaLoginMensagem){
            if (l.get(0).equals(nome)){           
                //As Mensagens começam no índice 1
                for (int i=1; i<l.size();i++){
                    res = res + l.get(i);
                }
                l.clear();
                l.add(nome);
                break;
            }
        }
        return res;
    }

    @Override
    public ArrayList<String> getUsuarios() {
        ArrayList<String> res = new ArrayList<String>();
        
        for (ArrayList l : listaLoginMensagem){
            res.add((String) l.get(0));
        }
        
        return res;
    }

}

