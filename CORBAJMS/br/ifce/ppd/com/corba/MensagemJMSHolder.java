package br.ifce.ppd.com.corba;

/**
* br/ifce/ppd/com/corba/MensagemJMSHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from MensagemIDL.idl
* Tuesday, October 15, 2013 11:12:10 PM BRT
*/

public final class MensagemJMSHolder implements org.omg.CORBA.portable.Streamable
{
  public br.ifce.ppd.com.corba.MensagemJMS value = null;

  public MensagemJMSHolder ()
  {
  }

  public MensagemJMSHolder (br.ifce.ppd.com.corba.MensagemJMS initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = br.ifce.ppd.com.corba.MensagemJMSHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.ifce.ppd.com.corba.MensagemJMSHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.ifce.ppd.com.corba.MensagemJMSHelper.type ();
  }

}
