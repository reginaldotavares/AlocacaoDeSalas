/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author NandaPC
 */
public class ClasseConexao {
    
    private Connection conexao;
    private PreparedStatement statment;
    
    
    
     public void abrir() throws SQLException {
        if (this.conexao == null || this.conexao.isClosed()) {
            this.conexao = ConnectionFactory.getInstance().getConnection();
            this.statment = null;
        }
    }

    public void liberar() throws SQLException {
        //libera o statment
        if (this.statment != null) {
            this.statment.close();
            this.statment = null;
        }
        //libera a conexão
        if (this.conexao != null) {
            this.conexao.close();
            this.conexao = null;
        }
    }
}
