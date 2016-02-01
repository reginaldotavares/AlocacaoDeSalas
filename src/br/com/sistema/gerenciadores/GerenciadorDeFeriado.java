/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.gerenciadores;

import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.FeriadoDaoIF;
import br.com.sistema.interfaces.UsuarioDaoIF;
import br.com.sistema.modelos.Feriado;
import br.com.sistema.modelos.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeFeriado {
    public boolean adicionarFeriado(String nomeFeriado, Date data) throws SQLException{
        Feriado novoFeriado = new Feriado();
        novoFeriado.setNomeFeriado(nomeFeriado);
        novoFeriado.setData(data);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriado = fabrica.criaFeriadoDao();
        feriado.inserirFeriado(novoFeriado); 
        
        return true;
    }
    
    public void removerFeriado(Date date) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        feriadoDao.removerFeriado(date);
    }
//    
    public boolean atualizaFeriado(String nomeFeriado, Date data) throws SQLException{
        Feriado feriado = new Feriado();
        feriado.setNomeFeriado(nomeFeriado);
        feriado.setData(data);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        feriadoDao.atualizarFeriado(feriado);
        return true;
    }
    
    public Feriado getFeriado(Date data) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.getFeriado(data);
    }
    
    public List<String[]> listarFeriados() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Feriado> lista = feriadoDao.ListarFeriado();
        for (Feriado lista1 : lista) {
            String nomeFeriado = lista1.getNomeFeriado();
            String data = lista1.getData().toString();
            String[] feriados = new String[]{nomeFeriado,data};
            listaRetorno.add(feriados);
        }
        
        return listaRetorno;
    }
}
