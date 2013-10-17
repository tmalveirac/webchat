import br.ifce.ppd.com.corba.*;

/**
 * Classe: MensagemJMSImpl.java
 * Implementação da IDL Corba da aplicação
 * @author Tiago Malveira
 * 
 */

import java.io.*;
import java.util.*;

import javax.jms.*;
import javax.naming.*;

import org.exolab.jms.administration.AdminConnectionFactory;
import org.exolab.jms.administration.JmsAdminServerIfc;

public class MensagemJMSImpl extends MensagemJMSPOA{
	
	/**
	* Verifica se existe uma fila no JMS
	*
	* @param    nome        nome da fila
	* @return               true, se existe. False, cc.             
	*/
	public boolean existeFila(String nome){
		try{
			String url = "tcp://localhost:3035/";
                	JmsAdminServerIfc admin = AdminConnectionFactory.create(url);
			String queue = nome;
			Boolean isQueue = Boolean.TRUE;
			if (admin.destinationExists(queue)) {
				System.out.println(queue + " já existe!");
				return true;
			} 
			else{
				System.out.println(queue + " não existe!");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
                
                return false;
	}        

	/**
	* Cria uma fila JMS
	*
	* @param    nome        nome da fila
	* @return               true, se foi criada. False, cc.             
	*/	
	public boolean criarFila(String nome){
                try{
			String url = "tcp://localhost:3035/";
                	JmsAdminServerIfc admin = AdminConnectionFactory.create(url);
			String queue = nome;
			Boolean isQueue = Boolean.TRUE;
			if (!admin.destinationExists(queue)) {
				if (!admin.addDestination(queue, isQueue)) {
		        		System.err.println("Falha ao criar queue " + queue);
					return false;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
                
                return true;
        }

	/**
	* Recebe uma mensagem do JMS
	*
	* @param    nome        nome da fila
	* @return               mensagem lida             
	*/
        public String getMensagem(String nome){

		try{
			Hashtable properties = new Hashtable();
		        properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.exolab.jms.jndi.InitialContextFactory");
		        properties.put(Context.PROVIDER_URL, "tcp://localhost:3035/");

		        Context context = new InitialContext(properties);

		        QueueConnectionFactory qfactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");


		        QueueConnection qconnection = qfactory.createQueueConnection();
		        QueueSession qsession = qconnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		        qconnection.start();

		        javax.jms.Queue dest = (javax.jms.Queue)context.lookup(nome);
		        QueueReceiver qreceiver = qsession.createReceiver(dest);


		        TextMessage textMessage = null;

		        textMessage = (TextMessage) qreceiver.receive();
			return textMessage.getText();

		}catch(Exception e){
			e.printStackTrace();
		}



                return "";
        }

	/**
	* Envia uma mensagem do JMS 
	*
	* @param    nome        nome da fila
	* @param    msg		mensagem a ser enviada	
	* @return                     
	*/
	public String escreverMensagem(String nome, String msg){
		try{
		        Hashtable properties = new Hashtable();
		        properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.exolab.jms.jndi.InitialContextFactory");
		        properties.put(Context.PROVIDER_URL, "tcp://localhost:3035/");

		        Context context = new InitialContext(properties);

		        QueueConnectionFactory qfactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");

		        QueueConnection qconnection = qfactory.createQueueConnection();
		        QueueSession qsession = qconnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		        TextMessage message = qsession.createTextMessage();
		        message.setText(msg);

		        javax.jms.Queue dest = (javax.jms.Queue) context.lookup(nome);
		        QueueSender sender = qsession.createSender(dest);
		        sender.send(message);

		        context.close();
		        qconnection.close();

		}catch(Exception e){
			e.printStackTrace();
		}

                return "";
        }
}
