/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.com;

import javax.xml.ws.Endpoint;

public class Publicador {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/inverter", new ServidorImpl());
                //Endpoint.publish("http://localhost:9999/tiago", new Cliente("tiago"));
                
                
	}
}
