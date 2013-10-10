
package br.ifce.ppd.com;

import br.ifce.ppd.view.Principal;

    
public class Cliente implements ClienteItf{
    
    private String nome;
    private ServidorImplService service;
    ServidorItf inverterservice;
    
    public Cliente(String nome){
        this.nome=nome;
        service = new ServidorImplService();
        inverterservice = service.getServidorImplPort();
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ServidorImplService getService() {
        return service;
    }

    public void setService(ServidorImplService service) {
        this.service = service;
    }

    public ServidorItf getInverterservice() {
        return inverterservice;
    }

    public void setInverterservice(ServidorItf inverterservice) {
        this.inverterservice = inverterservice;
    }



    @Override
    public void publicarMensagem(String nome) {
        Principal.escreveMensagemChat(nome);
    }
    
    
}

