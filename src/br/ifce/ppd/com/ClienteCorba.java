/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.com;

import br.ifce.ppd.com.corba.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class ClienteCorba{
        public static void main(String args[]){
                try {
                        ORB orb = ORB.init(args,null);
                        org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
                        NamingContext naming = NamingContextHelper.narrow(obj);
                        NameComponent[] name = {new NameComponent("MensagemJMS","Exemplo")};
                        org.omg.CORBA.Object objRef = naming.resolve(name);
                        MensagemJMS msgJMS = MensagemJMSHelper.narrow(objRef);
                      
                        System.out.println("Executando o Cliente!");
			msgJMS.criarFila("tiago");
			msgJMS.getMensagem("tiago");
			msgJMS.escreverMensagem("","");
                        

                }catch (Exception e) {
                        System.out.println("ERROR : " + e);
                        e.printStackTrace(System.out);
                }
        }
}
