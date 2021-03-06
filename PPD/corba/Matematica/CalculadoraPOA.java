package Matematica;


/**
* Matematica/CalculadoraPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcIDL.idl
* Tuesday, October 15, 2013 10:09:22 PM BRT
*/

public abstract class CalculadoraPOA extends org.omg.PortableServer.Servant
 implements Matematica.CalculadoraOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("soma", new java.lang.Integer (0));
    _methods.put ("divisao", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Matematica/Calculadora/soma
       {
         float arg1 = in.read_float ();
         float arg2 = in.read_float ();
         float $result = (float)0;
         $result = this.soma (arg1, arg2);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 1:  // Matematica/Calculadora/divisao
       {
         try {
           float arg1 = in.read_float ();
           float arg2 = in.read_float ();
           float $result = (float)0;
           $result = this.divisao (arg1, arg2);
           out = $rh.createReply();
           out.write_float ($result);
         } catch (Matematica.DivisaoPorZero $ex) {
           out = $rh.createExceptionReply ();
           Matematica.DivisaoPorZeroHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Matematica/Calculadora:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calculadora _this() 
  {
    return CalculadoraHelper.narrow(
    super._this_object());
  }

  public Calculadora _this(org.omg.CORBA.ORB orb) 
  {
    return CalculadoraHelper.narrow(
    super._this_object(orb));
  }


} // class CalculadoraPOA
