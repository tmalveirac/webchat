package Mensagem;


/**
* Mensagem/MensagemJMSPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MensagemIDL.idl
* Tuesday, October 15, 2013 10:55:24 PM BRT
*/

public abstract class MensagemJMSPOA extends org.omg.PortableServer.Servant
 implements Mensagem.MensagemJMSOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("criarFila", new java.lang.Integer (0));
    _methods.put ("getMensagem", new java.lang.Integer (1));
    _methods.put ("escreverMensagem", new java.lang.Integer (2));
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
       case 0:  // Mensagem/MensagemJMS/criarFila
       {
         String arg1 = in.read_string ();
         boolean $result = false;
         $result = this.criarFila (arg1);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // Mensagem/MensagemJMS/getMensagem
       {
         String nome = in.read_string ();
         String $result = null;
         $result = this.getMensagem (nome);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // Mensagem/MensagemJMS/escreverMensagem
       {
         String nome = in.read_string ();
         String msg = in.read_string ();
         String $result = null;
         $result = this.escreverMensagem (nome, msg);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Mensagem/MensagemJMS:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public MensagemJMS _this() 
  {
    return MensagemJMSHelper.narrow(
    super._this_object());
  }

  public MensagemJMS _this(org.omg.CORBA.ORB orb) 
  {
    return MensagemJMSHelper.narrow(
    super._this_object(orb));
  }


} // class MensagemJMSPOA
