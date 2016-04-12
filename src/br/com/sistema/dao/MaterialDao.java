/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.MaterialDaoIF;
import br.com.sistema.modelos.Material;
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
public class MaterialDao implements MaterialDaoIF{

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public MaterialDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void inserirMaterial(Material material) throws SQLException {
        try {
            conexao.abrir();
            String SQL = "insert into material(descricao, status) values (?,?)";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, material.getDescricao());
            pstm.setBoolean(2, true);
            pstm.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            conexao.liberar();
        }
    }

    @Override
    public void removerMaterial(Integer tombamento) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "delete from material where tombamento=?";

            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, tombamento);

            pstm.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } finally {
            conexao.liberar();
        }
    }

    @Override
    public void atualizarMaterial(Material material) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "update MATERIAL set descricao=? WHERE tombamento=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, material.getDescricao());
            pstm.setInt(2, material.getTombamento());
            
            
            pstm.executeUpdate();

        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }

    @Override
    public Material getMaterial(Integer tombamento) throws SQLException {
        try {

            conexao.abrir();
            String sql = "SELECT * FROM material WHERE tombamento=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, tombamento);
            ResultSet result = pstm.executeQuery();

            Material material = new Material();
                
            if (result.next()) {
                material.setTombamento(result.getInt("tombamento"));
                material.setDescricao(result.getString("descricao"));
                material.setStatus(result.getBoolean("status"));

            }
            return material;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public List<Material> listarMaterial() throws SQLException {
        List<Material> materiais = new ArrayList<Material>();
        try {
            conexao.abrir();

            String sql = "select descricao, tombamento, status from material";

            pstm = con.prepareStatement(sql);
            
            ResultSet result = pstm.executeQuery();

            while (result.next()) {
                Material material = new Material();
                material.setDescricao(result.getString("descricao"));
                material.setTombamento(result.getInt("tombamento"));
                material.setStatus(result.getBoolean("status"));
                materiais.add(material);
            }
            return materiais;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public List pesquisar(Integer tombamento) throws SQLException {
        List<Material> materiais = new ArrayList<>();
        try {
            conexao.abrir();
            
            String SQL = "select * from material where tombamento = ? ";
            
            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, tombamento);
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Material material = new Material();
                material.setDescricao(result.getString("descricao"));
                material.setTombamento(result.getInt("tombamento"));
                material.setStatus(result.getBoolean("status"));
         
                materiais.add(material);
            }
            return materiais;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public List pesquisar(String descricao) throws SQLException {
        List<Material> materiais = new ArrayList<Material>();
        try {
            conexao.abrir();
            
            String SQL = "select * from material where descricao ilike '%"+ descricao +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Material material = new Material();
                material.setDescricao(result.getString("descricao"));
                material.setTombamento(result.getInt("tombamento"));
                material.setStatus(result.getBoolean("status"));
         
                materiais.add(material);
            }
            return materiais;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
}
