package br.ifce.ppd.com.corba;


/**
* br/ifce/ppd/com/corba/MensagemJMSHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MensagemIDL.idl
* Tuesday, October 15, 2013 11:12:10 PM BRT
*/

abstract public class MensagemJMSHelper
{
  private static String  _id = "IDL:Mensagem/MensagemJMS:1.0";

  public static void insert (org.omg.CORBA.Any a, br.ifce.ppd.com.corba.MensagemJMS that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static br.ifce.ppd.com.corba.MensagemJMS extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (br.ifce.ppd.com.corba.MensagemJMSHelper.id (), "MensagemJMS");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static br.ifce.ppd.com.corba.MensagemJMS read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MensagemJMSStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, br.ifce.ppd.com.corba.MensagemJMS value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static br.ifce.ppd.com.corba.MensagemJMS narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof br.ifce.ppd.com.corba.MensagemJMS)
      return (br.ifce.ppd.com.corba.MensagemJMS)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      br.ifce.ppd.com.corba._MensagemJMSStub stub = new br.ifce.ppd.com.corba._MensagemJMSStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static br.ifce.ppd.com.corba.MensagemJMS unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof br.ifce.ppd.com.corba.MensagemJMS)
      return (br.ifce.ppd.com.corba.MensagemJMS)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      br.ifce.ppd.com.corba._MensagemJMSStub stub = new br.ifce.ppd.com.corba._MensagemJMSStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
