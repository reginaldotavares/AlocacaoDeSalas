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
public class Material {
   
    private Integer tombamento;
    private String descricao;
    private boolean status;

    public Material() {
    }

    public Material(String descricao, boolean status) {
        this.descricao = descricao;
        this.status = status;
    }

    public Integer getTombamento() {
        return tombamento;
    }

    public void setTombamento(Integer tombamento) {
        this.tombamento = tombamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

   
    
}
