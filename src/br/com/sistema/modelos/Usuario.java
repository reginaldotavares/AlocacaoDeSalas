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
public class Usuario {
    private String nome;
    private String senha;
    private String email;
    private Integer matricula;
    private String papel;
    private byte[] imagem;

    public Usuario() {
    }
    
    public Usuario(String nome, String senha, String email, Integer matricula, String papel, byte[] imagem) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.matricula = matricula;
        this.papel = papel;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    
    
    
}

