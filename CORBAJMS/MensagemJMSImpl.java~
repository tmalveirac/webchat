/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import br.ifce.ppd.com.corba.*;

import java.io.*;
import java.util.*;

import javax.jms.*;
import javax.naming.*;

import org.exolab.jms.administration.AdminConnectionFactory;
import org.exolab.jms.administration.JmsAdminServerIfc;

//Servidor JMS

public class MensagemJMSImpl extends MensagemJMSPOA{
	

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
