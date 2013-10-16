/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifce.ppd.com;

import br.ifce.ppd.com.corba.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class ServidorCorba{
        public static void main(String args[]){
                try{
                        ORB orb = ORB.init(args, null);
                        org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");
                        POA rootPOA = POAHelper.narrow(objPoa);
                        org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

                        NamingContext naming = NamingContextHelper.narrow(obj);
                        MensagemJMSImpl msgJMS = new MensagemJMSImpl();
                        org.omg.CORBA.Object objRef = rootPOA.servant_to_reference(msgJMS);

                        NameComponent[] name = {new NameComponent("MensagemJMS","Exemplo")};
                        naming.rebind(name,objRef);
                        rootPOA.the_POAManager().activate();
                        System.out.println("Servidor Pronto ...");
                        orb.run();
                }catch (Exception ex){
                        System.out.println("Erro");
                        ex.printStackTrace();
                }
        }
}
