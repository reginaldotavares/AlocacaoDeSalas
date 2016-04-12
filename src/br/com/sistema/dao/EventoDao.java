/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.EventoDaoIF;
import br.com.sistema.modelos.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class EventoDao implements EventoDaoIF{
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public EventoDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void inserirEvento(Evento evento) throws SQLException {
        try {
            conexao.abrir();
            String SQL = "insert into evento(nome, descricao, numeroparticipantes, responsavel, horainicio, horafim) values (?, ?, ?, ?, ?, ?)";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, evento.getNome());
            pstm.setString(2, evento.getDescricao());
            pstm.setInt(3, evento.getParticipantes());
            pstm.setString(4, evento.getResponsavel());
            pstm.setTimestamp(5, new Timestamp(evento.getInicio().getTime()));
            pstm.setTimestamp(6, new Timestamp(evento.getFim().getTime()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            conexao.liberar();
        }
    }

    @Override
    public void removerEvento(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarEvento(Evento sala) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evento> listarEvento() throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        try {
            conexao.abrir();
            
            String SQL = "select * from evento";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Evento evento = new Evento();
                evento.setId(result.getInt("id"));
                evento.setNome(result.getString("nome"));
                evento.setDescricao(result.getString("descricao"));
                evento.setParticipantes(result.getInt("numeroparticipantes"));
                evento.setResponsavel(result.getString("responsavel"));
                evento.setInicio(result.getTimestamp("horainicio"));
                evento.setFim(result.getTimestamp("horafim"));
                eventos.add(evento);
                
            }
            return eventos;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public List pesquisarEvento(String nome) throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        try {
            conexao.abrir();
            
            String SQL = "select * from evento where nome ilike '%"+ nome +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Evento evento = new Evento();
                evento.setNome(result.getString("nome"));
                evento.setDescricao(result.getString("descricao"));
                evento.setParticipantes(result.getInt("numeroparticipantes"));
                evento.setInicio(result.getTimestamp("horainicio"));
                evento.setFim(result.getTimestamp("horafim"));
                
                eventos.add(evento);
            }
            return eventos;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public Evento getEvento(String descricao) throws SQLException {
        try {

            conexao.abrir();
            String sql = "SELECT * FROM evento WHERE nome=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, descricao);
            ResultSet result = pstm.executeQuery();

            Evento evento = new Evento();
                
            if (result.next()) {
                evento.setId(result.getInt("id"));
                evento.setNome(result.getString("nome"));
                evento.setDescricao(result.getString("descricao"));
                evento.setParticipantes(result.getInt("numeroparticipantes"));
                evento.setResponsavel(result.getString("responsavel"));
                evento.setInicio(result.getTimestamp("horainicio"));
                evento.setFim(result.getTimestamp("horafim"));
            }
            return evento;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public Vector<Evento> carregaCombo() throws SQLException {
        try{
        conexao.abrir();
        Vector<Evento> eventos = new Vector<Evento>();
        String sql = "select * from evento order by id";
        this.pstm = con.prepareStatement(sql);;
        ResultSet result = pstm.executeQuery();
        while(result.next()){
            Evento evento = new Evento();
            evento.setId(result.getInt("id"));
            evento.setNome(result.getString("nome"));
            evento.setDescricao(result.getString("descricao"));
            evento.setParticipantes(result.getInt("numeroparticipantes"));
            evento.setInicio(result.getTimestamp("horainicio"));
            evento.setFim(result.getTimestamp("horafim"));
            eventos.add(evento);
        }
        return eventos;
        }finally {
            conexao.liberar();
      } 
    }
    
    public List DataBetween() throws SQLException {
        List<Evento> eventos = new ArrayList<Evento>();
        try {

            conexao.abrir();
            String sql = "select * from evento where now() between horainicio and horafim";
            pstm = con.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();

            while(result.next()){
                Evento evento = new Evento();
                evento.setId(result.getInt("id"));
                evento.setNome(result.getString("nome"));
                evento.setDescricao(result.getString("descricao"));
                evento.setParticipantes(result.getInt("numeroparticipantes"));
                evento.setResponsavel(result.getString("responsavel"));
                evento.setInicio(result.getTimestamp("horainicio"));
                evento.setFim(result.getTimestamp("horafim"));
                eventos.add(evento);
                return eventos;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
}
