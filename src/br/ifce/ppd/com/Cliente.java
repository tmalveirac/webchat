package br.ifce.ppd.com;

/**
 * Classe: Cliente.java
 * Código do Cliente (WebService) da aplicação
 * @author Tiago Malveira
 * 
 */

import java.util.Vector;
    
public class Cliente {
    
    private String nome;
    private ServidorImplService service;
    ServidorItf inverterservice;
    
    public Cliente(String nome){
        this.nome=nome;
        service = new ServidorImplService();
        inverterservice = service.getServidorImplPort();
    }

    public Cliente() {
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
    
    public Vector<String> getMensagem(){
        return inverterservice.getMensagens(nome);
    }
    
}

