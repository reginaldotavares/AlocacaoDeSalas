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
public class Alocacao {
    private String descricao;
    private String sala;
    private Integer id_sala;
    private Integer id_evento;

    public Alocacao() {
    }

    public Alocacao(String descricao, String sala, Integer id_sala, Integer id_evento) {
        this.descricao = descricao;
        this.sala = sala;
        this.id_sala = id_sala;
        this.id_evento = id_evento;
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public Integer getId_sala() {
        return id_sala;
    }

    public void setId_sala(Integer id_sala) {
        this.id_sala = id_sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
