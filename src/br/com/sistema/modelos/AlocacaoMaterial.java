/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.modelos;

/**
 *
 * @author Reginaldo
 */
public class AlocacaoMaterial {
    private Integer id;
    private Integer tombamento;
    private String nomeEvento;
    private String local;

    public AlocacaoMaterial() {
    }

    public AlocacaoMaterial(Integer id, Integer tombamento, String nomeEvento, String local) {
        this.id = id;
        this.tombamento = tombamento;
        this.nomeEvento = nomeEvento;
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTombamento() {
        return tombamento;
    }

    public void setTombamento(Integer tombamento) {
        this.tombamento = tombamento;
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
