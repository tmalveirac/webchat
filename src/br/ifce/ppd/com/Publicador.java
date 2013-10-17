package br.ifce.ppd.com;

/**
 * Classe: Publicador.java
 * Publicador do serviço (WS)
 * @author Tiago Malveira
 * 
 */

import javax.xml.ws.Endpoint;

public class Publicador {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/inverter", new ServidorImpl());  
	}
}
