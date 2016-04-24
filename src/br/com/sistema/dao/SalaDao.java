/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.SalaDaoIF;
import br.com.sistema.modelos.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class SalaDao implements SalaDaoIF{

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public SalaDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void inserirSala(Sala sala) throws SQLException {
        try {
            conexao.abrir();
            String SQL = "insert into sala(nome, bloco, capacidade, tipo) values (?, ?, ?, ?)";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, sala.getNomeSala());
            pstm.setString(2, sala.getBloco());
            pstm.setInt(3, sala.getCapacidade());
            pstm.setString(4, sala.getTipo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            conexao.liberar();
        }
    }

    @Override
    public void removerSala(String nome) throws SQLException {
        try {
            conexao.abrir();

            String sql = "delete from sala where nome=?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, nome);

            pstm.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        
        } finally {
            conexao.liberar();
        }
    }

    @Override
    public void atualizarSala(Sala sala) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "update sala set nome=?, bloco=?, capacidade=?, tipo=? WHERE nome=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, sala.getNomeSala());
            pstm.setString(2, sala.getBloco());
            pstm.setInt(3, sala.getCapacidade());
            pstm.setString(4, sala.getTipo());
            pstm.setString(5, sala.getNomeSala());
            
            
            pstm.executeUpdate();

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, E);
        } finally {
            conexao.liberar();
        }
    }

    @Override
    public List<Sala> listarSala() throws SQLException {
        List<Sala> salas = new ArrayList<>();
        try {
            conexao.abrir();
            
            String SQL = "select * from sala";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Sala sala = new Sala();
                sala.setId(result.getInt("id"));
                sala.setNomeSala(result.getString("nome"));
                sala.setBloco(result.getString("bloco"));
                sala.setCapacidade(result.getInt("capacidade"));
                sala.setTipo(result.getString("tipo"));
                salas.add(sala);
                
            }
            return salas;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public List pesquisar(String nome) throws SQLException {
         List<Sala> salas = new ArrayList<>();
        try {
            conexao.abrir();
            
            String SQL = "select * from sala where nome ilike '%"+ nome +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Sala sala = new Sala();
                sala.setNomeSala(result.getString("nome"));
                sala.setBloco(result.getString("bloco"));
                sala.setCapacidade(result.getInt("capacidade"));
                sala.setTipo(result.getString("tipo"));
                
                salas.add(sala);
            }
            return salas;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public Sala getSala(String descricao) throws SQLException {
        try {

            conexao.abrir();
            String sql = "SELECT * FROM sala WHERE nome=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, descricao);
            ResultSet result = pstm.executeQuery();

            Sala sala = new Sala();
                
            if (result.next()) {
                sala.setNomeSala(result.getString("nome"));
                sala.setBloco(result.getString("bloco"));
                sala.setCapacidade(result.getInt("capacidade"));
                sala.setTipo(result.getString("tipo"));

            }
            return sala;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public Vector<Sala> carregaCombo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
