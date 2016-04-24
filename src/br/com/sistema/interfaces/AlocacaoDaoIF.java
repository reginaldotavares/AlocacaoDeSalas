/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.interfaces;

import br.com.sistema.modelos.Alocacao;
import br.com.sistema.modelos.EventoAlocacao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public interface AlocacaoDaoIF {
    public void inserirAlocacao(Alocacao alocacao)throws SQLException;
    
    public void removerAlocacao(String descricao) throws SQLException;
    
    public void atualizarAlocacao(Alocacao alocacao) throws SQLException;
    
    public List<Alocacao> listarAlocacao() throws SQLException;
    
    public List pesquisar(String descricao) throws SQLException;
    
    public Alocacao getAlocacao(String descricao) throws SQLException;
    
    public List DataBetween() throws SQLException;
    
    public List<EventoAlocacao> listarEventoAlocacao() throws SQLException;
    
    public List DataAtualMaior() throws SQLException;
    
    public Alocacao getAlocacaoPorSala(String local) throws SQLException;
}
