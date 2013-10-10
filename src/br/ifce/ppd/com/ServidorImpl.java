
package br.ifce.ppd.com;

import java.util.ArrayList;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ifce.ppd.com.ServidorItf")
public class ServidorImpl implements ServidorItf{
    
    private static ArrayList<String> listaLogin = new ArrayList<String>();
    
    
    public String inverter(String msg) {
            StringBuffer strbuf = new StringBuffer(msg);
            System.out.println("Recebido: "+msg);
            String retorno = (strbuf.reverse()).toString();
            return retorno;
    }

    @Override
    public String cadastrar(String nome) {
        listaLogin.add(nome);
        return nome+"-cadastrado";
    }

    @Override
    public String login(String nome) {
        return nome+"-logado";
    }

    @Override
    public String enviarMensagem(String nome, String msg) {
        for (String s : listaLogin){
            if (s.equals(nome)){
               
            }
        }
        return "msg enviada";
    }

}

