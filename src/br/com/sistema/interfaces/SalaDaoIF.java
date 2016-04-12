/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.interfaces;

import br.com.sistema.modelos.Sala;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Reginaldo
 */
public interface SalaDaoIF {
    public void inserirSala(Sala sala)throws SQLException;
    
    public void removerSala(String nome) throws SQLException;
    
    public void atualizarSala(Sala sala) throws SQLException;
    
    public List<Sala> listarSala() throws SQLException;
    
    public List pesquisar(String nome) throws SQLException;
    
    public Sala getSala(String descricao) throws SQLException;
    
    public Vector<Sala> carregaCombo() throws SQLException;
}
