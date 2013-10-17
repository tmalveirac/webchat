
package br.ifce.ppd.com;
import br.ifce.ppd.com.corba.MensagemJMSPOA;

/**
 * Classe: MensagemJMSImpl.java
 * Implementação da Interface IDL Corba (Lado Servidor) (Apenas para Teste!)
 * @author Tiago Malveira
 * 
 */

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

        @Override
        public boolean existeFila(String nome) {
            return true;
        }
}