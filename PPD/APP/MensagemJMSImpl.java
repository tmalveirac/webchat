import Mensagem.*;
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

