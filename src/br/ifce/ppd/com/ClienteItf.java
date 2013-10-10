/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.com;

import javax.jws.WebMethod;
import javax.jws.WebService;
  
@WebService
public interface ClienteItf {
    
     @WebMethod void publicarMensagem(String nome);
}
