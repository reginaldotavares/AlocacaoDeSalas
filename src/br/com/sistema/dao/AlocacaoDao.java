/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.AlocacaoDaoIF;
import br.com.sistema.modelos.Alocacao;
import br.com.sistema.modelos.EventoAlocacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class AlocacaoDao implements AlocacaoDaoIF{
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public AlocacaoDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void inserirAlocacao(Alocacao alocacao) throws SQLException {
        try {
            conexao.abrir();
            String SQL = "insert into alocacaoevento(id_evento, descricao, sala) values (?, ?, ?)";
            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, alocacao.getId_evento());
            pstm.setString(2, alocacao.getDescricao());
            pstm.setString(3, alocacao.getSala());
            pstm.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            conexao.liberar();
        }
    }

    public List<EventoAlocacao> listarEventoAlocacao() throws SQLException {
        List<EventoAlocacao> eventosAlocacoes = new ArrayList<EventoAlocacao>();
        try {
            conexao.abrir();
            
            String SQL = "SELECT evento.horainicio, evento.horafim, evento.nome, alocacaoevento.sala "
                    + "FROM alocacaoevento Right outer "
                    + "JOIN evento ON evento.id = alocacaoevento.id_evento";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                EventoAlocacao eventoAlocacao = new EventoAlocacao();
                eventoAlocacao.setInicio(result.getTimestamp("horainicio"));
                eventoAlocacao.setFim(result.getTimestamp("horafim"));
                eventoAlocacao.setNomeEvento(result.getString("nome"));
                eventoAlocacao.setLocal(result.getString("sala"));
                
                eventosAlocacoes.add(eventoAlocacao);
                
            }
            return eventosAlocacoes;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    @Override
    public void removerAlocacao(String descricao) throws SQLException {
//        try {
//            conexao.abrir();
//
//            String SQL = "delete from alocacao where descricao=?";
//
//            pstm = con.prepareStatement(SQL);
//            pstm.setString(1, descricao);
//
//            pstm.executeUpdate();
//
//        } finally {
//            conexao.liberar();
//        }
    }

    @Override
    public void atualizarAlocacao(Alocacao alocacao) throws SQLException {
//        try {
//            conexao.abrir();
//
//            String SQL = "update alocacao set descricao=? where id=?";
//
//            pstm = con.prepareStatement(SQL);
//            String nome = alocacao.getNome();
//            Integer id = alocacao.getId();
//            pstm.setString(1, nome);
//            pstm.setInt(2, id);
//            
//            pstm.executeUpdate();
//
//        } catch (Exception E) {
//            JOptionPane.showMessageDialog(null, E);
//        } finally {
//            conexao.liberar();
//        }
    }

    @Override
    public List<Alocacao> listarAlocacao() throws SQLException {
//        List<Alocacao> alocacaos = new ArrayList<Alocacao>();
//        try {
//            conexao.abrir();
//            
//            String SQL = "select descricao, id from alocacao order by descricao";
//            
//            pstm = con.prepareStatement(SQL);
//            
//            ResultSet result = pstm.executeQuery();
//  
//            while(result.next()){
//                Alocacao alocacao = new Alocacao();
//                alocacao.setNome(result.getString("descricao"));
//                alocacao.setId(result.getInt("id"));
//                alocacaos.add(alocacao);
//                
//            }
//            return alocacaos;
//        } catch(Exception E) { 
//            E.printStackTrace();
//        } finally {
//            conexao.liberar();
//        }
        return null;
        
    }
    
    @Override
    public List pesquisar(String descricao) throws SQLException {
        List<Alocacao> alocacoes = new ArrayList<Alocacao>();
        try {
            conexao.abrir();
            
            String SQL = "select * from alocacaoevento where descricao ilike '%"+ descricao +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Alocacao alocacao = new Alocacao();
                alocacao.setId_sala(result.getInt("id_evento"));
                alocacao.setDescricao(result.getString("descricao"));
                alocacao.setSala(result.getString("sala"));
                alocacoes.add(alocacao);
                return alocacoes;
            }
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public Alocacao getAlocacao(String descricao) throws SQLException {
        try {

            conexao.abrir();
            String sql = "SELECT * FROM alocacaoevento WHERE descricao=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, descricao);
            ResultSet result = pstm.executeQuery();

            Alocacao alocacao = new Alocacao();
                
            if (result.next()) {
                alocacao.setDescricao(result.getString("descricao"));
                alocacao.setSala(result.getString("sala"));
            }
            return alocacao;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public List DataBetween() throws SQLException {
        List<EventoAlocacao> alocacoes = new ArrayList<EventoAlocacao>();
        try {

            conexao.abrir();
            String sql = "SELECT evento.horainicio, evento.horafim, evento.nome, alocacaoevento.sala\n" +
                          "FROM alocacaoevento Right outer JOIN\n" +
                          "evento ON evento.id = alocacaoevento.id_evento where now() between horainicio and horafim";
            pstm = con.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();

            while(result.next()){
                EventoAlocacao alocacao = new EventoAlocacao();
                alocacao.setInicio(result.getTimestamp("horainicio"));
                alocacao.setFim(result.getTimestamp("horafim"));
                alocacao.setNomeEvento(result.getString("nome"));
                alocacao.setLocal(result.getString("sala"));
                alocacoes.add(alocacao);
                return alocacoes;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
        
    }
    
    public List DataAtualMaior() throws SQLException {
        List<EventoAlocacao> alocacoes = new ArrayList<EventoAlocacao>();
        try {

            conexao.abrir();
            String sql = "SELECT evento.horainicio, evento.horafim, evento.nome, alocacaoevento.sala" +
"                          FROM evento, alocacaoevento where evento.id = alocacaoevento.id_evento " +
                            "and now() > horafim";
            pstm = con.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();

            while(result.next()){
                EventoAlocacao alocacao = new EventoAlocacao();
                alocacao.setInicio(result.getTimestamp("horainicio"));
                alocacao.setFim(result.getTimestamp("horafim"));
                alocacao.setNomeEvento(result.getString("nome"));
                alocacao.setLocal(result.getString("sala"));
                alocacoes.add(alocacao);
                return alocacoes;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
        
    }
    
    
}
