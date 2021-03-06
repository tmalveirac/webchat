import java.io.*;
import java.util.*;
 
import javax.jms.*;
import javax.naming.*;
 
import org.exolab.jms.administration.AdminConnectionFactory;
import org.exolab.jms.administration.JmsAdminServerIfc;

public class ReceiverQueue {
     
     public static void main(String args[]){
     
         try{


		String url = "tcp://localhost:3035/";
		JmsAdminServerIfc admin = AdminConnectionFactory.create(url);
		
		String queue = "filaTeste";
    		Boolean isQueue = Boolean.TRUE;
    		if (!admin.addDestination(queue, isQueue)) {
        		System.err.println("Failed to create queue " + queue);
    		}

		Hashtable properties = new Hashtable();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.exolab.jms.jndi.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, "tcp://localhost:3035/");

		Context context = new InitialContext(properties);

		QueueConnectionFactory qfactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");


		QueueConnection qconnection = qfactory.createQueueConnection();
		QueueSession qsession = qconnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		qconnection.start();

	        javax.jms.Queue dest = (javax.jms.Queue)context.lookup("queue1");
        	QueueReceiver qreceiver = qsession.createReceiver(dest);
         
                
		TextMessage textMessage = null;

		while (true) {
                   textMessage = (TextMessage) qreceiver.receive();
	           System.out.println(" Mensagem Recebida: " + textMessage.getText());  
		}
        	
			 
         }catch(Exception e){
             e.printStackTrace();
         }       
     }     
 }
