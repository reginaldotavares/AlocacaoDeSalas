/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.AlocacaoMaterialDaoIF;
import br.com.sistema.modelos.AlocacaoMaterial;
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
public class AlocacaoMaterialDao implements  AlocacaoMaterialDaoIF{
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public AlocacaoMaterialDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void inserirAlocacaoMaterial(AlocacaoMaterial alocacaoMaterial) throws SQLException {
        try {
            conexao.abrir();
            String SQL = "insert into alocacaomaterial(tombamento, nomeevento, local) values (?, ?, ?)";
            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, alocacaoMaterial.getTombamento());
            pstm.setString(2, alocacaoMaterial.getNomeEvento());
            pstm.setString(3, alocacaoMaterial.getLocal());
            pstm.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            conexao.liberar();
        }
    }

    @Override
    public void removerAlocacaoMaterial(String descricao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarAlocacaoMaterial(AlocacaoMaterial alocacaoMaterial) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List pesquisar(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlocacaoMaterial getAlocacaoMaterial(String local) throws SQLException {
        try {

            conexao.abrir();
            String sql = "SELECT * FROM alocacaomaterial WHERE local=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, local);
            ResultSet result = pstm.executeQuery();

            AlocacaoMaterial alocacao = new AlocacaoMaterial();
                
            if (result.next()) {
                alocacao.setId(result.getInt("id"));
                alocacao.setTombamento(result.getInt("tombamento"));
                alocacao.setNomeEvento(result.getString("nomeevento"));
                alocacao.setLocal(result.getString("local"));
            }
            return alocacao;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public List<AlocacaoMaterial> listarAlocacaoMaterial() throws SQLException {
        List<AlocacaoMaterial> listaAlocacao = new ArrayList<AlocacaoMaterial>();
        try {
            conexao.abrir();
            
            String SQL = "select id, tombamento, nomeevento, local from alocacaomaterial order by id";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                AlocacaoMaterial alocacao = new AlocacaoMaterial();
                alocacao.setId(result.getInt("id"));
                alocacao.setTombamento(result.getInt("tombamento"));
                alocacao.setNomeEvento(result.getString("nomeevento"));
                alocacao.setLocal(result.getString("local"));
                listaAlocacao.add(alocacao);
                
            }
            return listaAlocacao;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public AlocacaoMaterial getAlocacaoMaterialPorTombamento(Integer tombamento) throws SQLException {
        try {

            conexao.abrir();
            String sql = "SELECT * FROM alocacaomaterial WHERE tombamento=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, tombamento);
            ResultSet result = pstm.executeQuery();

            AlocacaoMaterial alocacao = new AlocacaoMaterial();
                
            if (result.next()) {
                alocacao.setId(result.getInt("id"));
                alocacao.setTombamento(result.getInt("tombamento"));
                alocacao.setNomeEvento(result.getString("nomeevento"));
                alocacao.setLocal(result.getString("local"));
            }
            return alocacao;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
