/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.interfaces;

import br.com.sistema.modelos.Feriado;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public interface FeriadoDaoIF {
    
    public void inserirFeriado(Feriado f)throws SQLException;
    
    public void removerFeriado(Date data) throws SQLException;
    
    public void atualizarFeriado(Feriado feriado) throws SQLException;
    
    public Feriado getFeriado(Date data) throws SQLException;
    
    public List<Feriado> ListarFeriado() throws SQLException;
}
