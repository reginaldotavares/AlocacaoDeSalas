/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.modelos;

import br.com.sistema.controller.ConverterData;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Reginaldo
 */
public class Evento {
    ConverterData converter = new ConverterData();
    private Integer id;
    private String nome;
    private String descricao;
    private Integer participantes;
    private String responsavel;
    private Timestamp inicio;
    private Timestamp fim;

    public Evento() {
    }

    public Evento(Integer id, String nome, String descricao, Integer participantes, String responsavel, Timestamp inicio, Timestamp fim) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.participantes = participantes;
        this.responsavel = responsavel;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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

    

    @Override
    public String toString() {
        SimpleDateFormat formataData= new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String stringData = formataData.format(inicio);
        String stringData2 = formataData.format(fim);
        Timestamp i = inicio;
        Timestamp f = fim;
//        String duracao = converter.subTimeStamps(inicio, fim);
        
//        return  stringData;
        return  nome + " - " + participantes + " - " + " pessoas" + " - " + stringData.toString().substring(0, 10) + " das " + stringData.toString().substring(11,16)+ " às "  + stringData2.toString().substring(11,16);
    }
    
    
}
