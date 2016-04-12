/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.BlocoDaoIF;
import br.com.sistema.modelos.Bloco;
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
public class BlocoDao implements BlocoDaoIF{
   
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public BlocoDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void inserirBloco(Bloco bloco) throws SQLException {
        try {
            conexao.abrir();
            String SQL = "insert into bloco(descricao) values (?)";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, bloco.getNome());
            pstm.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            conexao.liberar();
        }
    }

    @Override
    public void removerBloco(String descricao) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "delete from bloco where descricao=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, descricao);

            pstm.executeUpdate();

        } finally {
            conexao.liberar();
        }
    }

    @Override
    public void atualizarBloco(Bloco bloco) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "update bloco set descricao=? where id=?";

            pstm = con.prepareStatement(SQL);
            String nome = bloco.getNome();
            Integer id = bloco.getId();
            pstm.setString(1, nome);
            pstm.setInt(2, id);
            
            pstm.executeUpdate();

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, E);
        } finally {
            conexao.liberar();
        }
    }

    @Override
    public List<Bloco> listarBloco() throws SQLException {
        List<Bloco> blocos = new ArrayList<Bloco>();
        try {
            conexao.abrir();
            
            String SQL = "select descricao, id from bloco order by descricao";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Bloco bloco = new Bloco();
                bloco.setNome(result.getString("descricao"));
                bloco.setId(result.getInt("id"));
                blocos.add(bloco);
                
            }
            return blocos;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    @Override
    public List pesquisar(String descricao) throws SQLException {
        List<Bloco> materiais = new ArrayList<Bloco>();
        try {
            conexao.abrir();
            
            String SQL = "select * from bloco where descricao ilike '%"+ descricao +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Bloco bloco = new Bloco();
                bloco.setNome(result.getString("descricao"));
                
                materiais.add(bloco);
            }
            return materiais;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public Bloco getBloco(String descricao) throws SQLException {
        try {

            conexao.abrir();
            String sql = "SELECT * FROM bloco WHERE descricao=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, descricao);
            ResultSet result = pstm.executeQuery();

            Bloco bloco = new Bloco();
                
            if (result.next()) {
                bloco.setNome(result.getString("descricao"));
                bloco.setId(result.getInt("id"));
            }
            return bloco;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public Vector<Bloco> carregaCombo() throws SQLException {
        try{
        conexao.abrir();
        Vector<Bloco> blocos = new Vector<Bloco>();
        String sql = "select * from bloco order by id";
        this.pstm = con.prepareStatement(sql);;
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            Bloco bloco = new Bloco(rs.getString("descricao"));
            blocos.add(bloco);
        }
        return blocos;
        }finally {
            conexao.liberar();
      } 
    }
}
