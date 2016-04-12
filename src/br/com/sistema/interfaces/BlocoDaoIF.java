/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.interfaces;

import br.com.sistema.modelos.Bloco;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Reginaldo
 */
public interface BlocoDaoIF {
    public void inserirBloco(Bloco bloco)throws SQLException;
    
    public void removerBloco(String nome) throws SQLException;
    
    public void atualizarBloco(Bloco bloco) throws SQLException;
    
    public List<Bloco> listarBloco() throws SQLException;
    
    public List pesquisar(String nome) throws SQLException;
    
    public Bloco getBloco(String descricao) throws SQLException;
    
    public Vector<Bloco> carregaCombo() throws SQLException;
}
