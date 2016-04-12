/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.interfaces;

import br.com.sistema.modelos.Evento;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Reginaldo
 */
public interface EventoDaoIF {
    public void inserirEvento(Evento evento)throws SQLException;
    
    public void removerEvento(String nome) throws SQLException;
    
    public void atualizarEvento(Evento sala) throws SQLException;
    
    public List<Evento> listarEvento() throws SQLException;
    
    public List pesquisarEvento(String nome) throws SQLException;
    
    public Evento getEvento(String nome) throws SQLException;
    
    public Vector<Evento> carregaCombo() throws SQLException;
    
    public List DataBetween() throws SQLException;
}
