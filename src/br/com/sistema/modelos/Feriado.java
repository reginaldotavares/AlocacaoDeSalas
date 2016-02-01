/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.modelos;

import java.sql.Date;

/**
 *
 * @author Reginaldo
 */
public class Feriado {
    private String nomeFeriado;
    private Date data;

    public Feriado() {
    }

    public Feriado(String nomeFeriado, Date data) {
        this.nomeFeriado = nomeFeriado;
        this.data = data;
    }

    public String getNomeFeriado() {
        return nomeFeriado;
    }

    public void setNomeFeriado(String nomeFeriado) {
        this.nomeFeriado = nomeFeriado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
