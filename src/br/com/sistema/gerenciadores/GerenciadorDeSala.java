/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.gerenciadores;

import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.SalaDaoIF;
import br.com.sistema.modelos.Sala;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeSala {
    public boolean adicionarSala(String descricao, String bloco, Integer capacidade, String tipoSala) throws SQLException{
        Sala novaSala = new Sala();
        novaSala.setNomeSala(descricao);
        novaSala.setBloco(bloco);
        novaSala.setCapacidade(capacidade);
        novaSala.setTipo(tipoSala);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        SalaDaoIF sala = fabrica.criaSalaDao();
        sala.inserirSala(novaSala);
        return true;
    }
    
    public List<String[]> listarSala() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        SalaDaoIF salaDao = fabrica.criaSalaDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Sala> lista = salaDao.listarSala();
        for (Sala lista1 : lista) {
            String id = lista1.getId().toString();
            String descricao = lista1.getNomeSala();
            String bloco = lista1.getBloco();
            String capacidade = lista1.getCapacidade().toString();
            String tipo = lista1.getTipo();
            String[] salas = new String[]{id, descricao, bloco, capacidade, tipo};
            listaRetorno.add(salas);
        }
        
        return listaRetorno;
    }
    
    public List pesquisarSala(String pesquisa) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        SalaDaoIF salaDao = fabrica.criaSalaDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Sala> lista = salaDao.pesquisar(pesquisa);
        for (Sala lista1 : lista) {
            String nome = lista1.getNomeSala();
            String bloco = lista1.getBloco();
            String capacidade = lista1.getCapacidade().toString();
            String tipo = lista1.getTipo();
            String[] salas = new String[]{nome, bloco, capacidade, tipo};
            listaRetorno.add(salas);
        }
        
        return listaRetorno;
    }
    
    public boolean atualizaSala(String nome, String bloco, Integer capacidade, String tipo) throws SQLException{
        Sala sala = new Sala();
        sala.setNomeSala(nome);
        sala.setBloco(bloco);
        sala.setCapacidade(capacidade);
        sala.setTipo(tipo);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        SalaDaoIF salaDao = fabrica.criaSalaDao();
        salaDao.atualizarSala(sala);
        return true;
    }
    
    public Sala getSala(String descricao) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        SalaDaoIF SalaDao = fabrica.criaSalaDao();
        return SalaDao.getSala(descricao);
    }
    
    public void removerSala(String descricao) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        SalaDaoIF salaDao = fabrica.criaSalaDao();
        salaDao.removerSala(descricao);
    }
    
//    public Vector<Bloco> carregaCombo() throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        BlocoDaoIF blocoDao = fabrica.criaBlocoDao();
//        Vector<Bloco> listaRetorno = new Vector();        
//        Vector<Bloco> lista = blocoDao.carregaCombo();
//        for (Bloco lista1 : lista) {
//            String descricao = lista1.getNome();
//            String[] blocos = new String[]{descricao};
//            listaRetorno.add(lista1);
//        }
//        
//        return listaRetorno;
//    }
}
