package br.ifce.ppd.com.corba;


/**
* br/ifce/ppd/com/corba/_MensagemJMSStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MensagemIDL.idl
* Tuesday, October 15, 2013 11:12:10 PM BRT
*/

public class _MensagemJMSStub extends org.omg.CORBA.portable.ObjectImpl implements br.ifce.ppd.com.corba.MensagemJMS
{

  public boolean criarFila (String arg1)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("criarFila", true);
                $out.write_string (arg1);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return criarFila (arg1        );
            } finally {
                _releaseReply ($in);
            }
  } // criarFila

  public String getMensagem (String nome)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getMensagem", true);
                $out.write_string (nome);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getMensagem (nome        );
            } finally {
                _releaseReply ($in);
            }
  } // getMensagem

  public String escreverMensagem (String nome, String msg)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("escreverMensagem", true);
                $out.write_string (nome);
                $out.write_string (msg);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return escreverMensagem (nome, msg        );
            } finally {
                _releaseReply ($in);
            }
  } // escreverMensagem

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Mensagem/MensagemJMS:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _MensagemJMSStub
