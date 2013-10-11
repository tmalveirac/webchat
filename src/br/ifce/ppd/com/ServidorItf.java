/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.com;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
  
@WebService
public interface ServidorItf{
    @WebMethod String inverter(String nome);
    
    @WebMethod String cadastrar(String nome);
    
    @WebMethod String login(String nome);
    
    @WebMethod String enviarMensagem(String nome, String msg);
    
    @WebMethod String getMensagem(String nome);
    
    @WebMethod ArrayList<String> getUsuarios();
}
  
