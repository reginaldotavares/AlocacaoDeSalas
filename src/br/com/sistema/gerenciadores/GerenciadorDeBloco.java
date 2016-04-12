/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.gerenciadores;

import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.BlocoDaoIF;
import br.com.sistema.modelos.Bloco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeBloco {
    public boolean adicionarBloco(String descricao) throws SQLException{
        Bloco novoBloco = new Bloco();
        novoBloco.setNome(descricao);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        BlocoDaoIF bloco = fabrica.criaBlocoDao();
        bloco.inserirBloco(novoBloco);
        return true;
    }
    
    public List<String[]> listarBlocos() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        BlocoDaoIF blocoDao = fabrica.criaBlocoDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Bloco> lista = blocoDao.listarBloco();
        for (Bloco lista1 : lista) {
            String descricao = lista1.getNome();
            String idBloco = lista1.getId().toString();
            String[] blocos = new String[]{descricao, idBloco};
            listaRetorno.add(blocos);
        }
        
        return listaRetorno;
    }
    
    public List pesquisarBloco(String pesquisa) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        BlocoDaoIF blocoDao = fabrica.criaBlocoDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Bloco> lista = blocoDao.pesquisar(pesquisa);
        for (Bloco lista1 : lista) {
            String descricao = lista1.getNome();
            String[] materiais = new String[]{descricao};
            listaRetorno.add(materiais);
        }
        
        return listaRetorno;
    }
    
    public boolean atualizaBloco(String descricao, Integer id) throws SQLException{
        Bloco bloco = new Bloco();
        bloco.setNome(descricao);
        bloco.setId(id);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        BlocoDaoIF blocoDao = fabrica.criaBlocoDao();
        blocoDao.atualizarBloco(bloco);
        return true;
    }
    
    public Bloco getBloco(String descricao) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        BlocoDaoIF BlocoDao = fabrica.criaBlocoDao();
        return BlocoDao.getBloco(descricao);
    }
    
    public void removerBloco(String descricao) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        BlocoDaoIF blocoDao = fabrica.criaBlocoDao();
        blocoDao.removerBloco(descricao);
    }
    
    public Vector<Bloco> carregaCombo() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        BlocoDaoIF blocoDao = fabrica.criaBlocoDao();
        Vector<Bloco> listaRetorno = new Vector();        
        Vector<Bloco> lista = blocoDao.carregaCombo();
        for (Bloco lista1 : lista) {
            String descricao = lista1.getNome();
            String[] blocos = new String[]{descricao};
            listaRetorno.add(lista1);
        }
        
        return listaRetorno;
    }
}
