/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.FeriadoDaoIF;
import br.com.sistema.modelos.Feriado;
import br.com.sistema.modelos.Usuario;
import java.sql.Connection;
import java.sql.Date;
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
public class FeriadoDao implements FeriadoDaoIF{

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public FeriadoDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void inserirFeriado(Feriado feriado) throws SQLException {

       try{ 
        conexao.abrir();
        String SQL = "insert into feriado(nomeFeriado, data) values (?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setString(1, feriado.getNomeFeriado());
        pstm.setDate(2, feriado.getData());
        pstm.executeUpdate();
    }catch(SQLException e){
           System.out.println(e);
    }
       finally {
            conexao.liberar();
        }
    }
    
    public void removerFeriado(Date data) throws SQLException{
        try {
            conexao.abrir();
            
            String SQL = "delete from feriado where data=?";

            pstm = con.prepareStatement(SQL);
            pstm.setDate(1, data);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } finally {
            conexao.liberar();
        }
    }
//
    public void atualizarFeriado(Feriado feriado) throws SQLException{
        
        try {
            conexao.abrir();
            
            String SQL = "update feriado set nomeFeriado=? where data=?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, feriado.getNomeFeriado());
            pstm.setDate(2, feriado.getData());
            pstm.executeUpdate();
        
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }
    
    @Override
    public Feriado getFeriado(Date data) throws SQLException {
        Feriado feriado = null;
        try {
            
            conexao.abrir();
            String sql = "SELECT * FROM feriado WHERE data=?";
            pstm = con.prepareStatement(sql);
            pstm.setDate(1, data);
            ResultSet result = pstm.executeQuery();
            
            if (result.next()) {
                feriado = new Feriado();
                feriado.setNomeFeriado(result.getString("nomeferiado"));
                feriado.setData(result.getDate("data"));
                
            }
                return feriado;
              } catch(Exception E) { 
//                    E.printStackTrace();
                 JOptionPane.showMessageDialog(null, E);
               } finally {
            conexao.liberar();
        }
        return null;
       
    }
    
     public List<Feriado> ListarFeriado() throws SQLException {
        List<Feriado> feriados = new ArrayList<Feriado>();
        try {
            conexao.abrir();
            
            String SQL = "select nomeFeriado, data from feriado";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Feriado feriado = new Feriado();
                feriado.setNomeFeriado(result.getString("nomeFeriado"));
                feriado.setData(result.getDate("data"));
                feriados.add(feriado);
            }
            return feriados;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
