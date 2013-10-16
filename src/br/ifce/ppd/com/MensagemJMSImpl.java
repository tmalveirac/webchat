/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.com;
import br.ifce.ppd.com.corba.*;


public class MensagemJMSImpl extends MensagemJMSPOA{
        public boolean criarFila(String nome){
                System.out.println("Método CriarFila");
                return true;
        }

        public String getMensagem(String nome){
                System.out.println("Método getMensagem");
                return "";
        }

	public String escreverMensagem(String nome, String msg){
                System.out.println("Método escreverMensagem");
                return "";
        }
}