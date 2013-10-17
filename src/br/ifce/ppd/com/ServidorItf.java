package br.ifce.ppd.com;

/**
 * Classe: ServidorItf.java
 * Interface WebService
 * @author Tiago Malveira
 * 
 */

import java.util.Vector;
import javax.jws.WebMethod;
import javax.jws.WebService;
  
// WSDL: http://localhost:9999/inverter?wsdl

@WebService
public interface ServidorItf{
    @WebMethod String inverter(String nome);
    
    @WebMethod String cadastrar(String nome);
    
    @WebMethod String login(String nome);
    
    @WebMethod String enviarMensagem(String origem, String destino, String msg);
    
    @WebMethod Vector<String> getMensagens(String nome);
    
    @WebMethod Vector<String> getUsuarios();
    
    @WebMethod boolean usuarioJaCadastrado(String nome);
    
}
  
