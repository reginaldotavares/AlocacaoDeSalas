/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.modelos;

import java.sql.Timestamp;

/**
 *
 * @author Reginaldo
 */
public class EventoAlocacao {
    private Timestamp inicio;
    private Timestamp fim;
    private String nomeEvento;
    private String local;

    public EventoAlocacao() {
    }

    public EventoAlocacao(Timestamp inicio, Timestamp fim, String nomeEvento, String local) {
        this.inicio = inicio;
        this.fim = fim;
        this.nomeEvento = nomeEvento;
        this.local = local;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public Timestamp getFim() {
        return fim;
    }

    public void setFim(Timestamp fim) {
        this.fim = fim;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    
    
    
    
}
