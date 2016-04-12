/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.gerenciadores;

import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.AlocacaoDaoIF;
import br.com.sistema.modelos.Alocacao;
import br.com.sistema.modelos.EventoAlocacao;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeAlocacao {
    public boolean adicionarAlocacao(Integer id_sala, Integer id_evento, String descricao, String sala) throws SQLException{
        Alocacao novaAlocacao = new Alocacao();
        novaAlocacao.setId_sala(id_sala);
        novaAlocacao.setId_evento(id_evento);
        novaAlocacao.setDescricao(descricao);
        novaAlocacao.setSala(sala);
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AlocacaoDaoIF alocacao = fabrica.criaAlocacaoDao();
        alocacao.inserirAlocacao(novaAlocacao);
        return true;
    }
    
//    public boolean adicionarEventoAlocacao(Timestamp inicio, Timestamp fim, String nomeEvento, String local) throws SQLException{
//        EventoAlocacao eventoAlocacao = new EventoAlocacao();
//        eventoAlocacao.setInicio(inicio);
//        eventoAlocacao.setFim(fim);
//        eventoAlocacao.setNomeEvento(nomeEvento);
//        eventoAlocacao.setLocal(local);
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        AlocacaoDaoIF alocacao = fabrica.criaAlocacaoDao();
//        alocacao.inserirEventoAlocacao(eventoAlocacao);
//        return true;
//    }
    
    public List<EventoAlocacao> listarEventoAlocacao() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AlocacaoDaoIF alocacaoDao = fabrica.criaAlocacaoDao();
        List<EventoAlocacao> listaRetorno = new ArrayList<EventoAlocacao>();        
        List<EventoAlocacao> lista = alocacaoDao.listarEventoAlocacao();
        for (EventoAlocacao lista1 : lista) {
//            String string = lista1.getInicio().toString().substring(0, 10);
//            String dataFormatada = string.substring(8, 10)+"/"+string.substring(5, 7)+"/"+string.substring(0, 4);
//            String inicio = dataFormatada +" às "+lista1.getInicio().toString().substring(11, 13)+"h"+lista1.getInicio().toString().substring(14, 16);
            Timestamp inicio = lista1.getInicio();
            Timestamp fim = lista1.getFim();
            String nomeEvento = lista1.getNomeEvento();
            String local = lista1.getLocal();
            EventoAlocacao eventoAlocacao = new EventoAlocacao(inicio, fim, nomeEvento, local);
            listaRetorno.add(eventoAlocacao);
        }
        
        return listaRetorno;
    }
//    
//    public List pesquisarAlocacao(String pesquisa) throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        AlocacaoDaoIF alocacaoDao = fabrica.criaAlocacaoDao();
//        List<String[]> listaRetorno = new ArrayList();        
//        List<Alocacao> lista = alocacaoDao.pesquisar(pesquisa);
//        for (Alocacao lista1 : lista) {
//            String descricao = lista1.getNome();
//            String[] materiais = new String[]{descricao};
//            listaRetorno.add(materiais);
//        }
//        
//        return listaRetorno;
//    }
//    
//    public boolean atualizaAlocacao(String descricao, Integer id) throws SQLException{
//        Alocacao alocacao = new Alocacao();
//        alocacao.setNome(descricao);
//        alocacao.setId(id);
//        
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        AlocacaoDaoIF alocacaoDao = fabrica.criaAlocacaoDao();
//        alocacaoDao.atualizarAlocacao(alocacao);
//        return true;
//    }
//    
//    public Alocacao getAlocacao(String descricao) throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        AlocacaoDaoIF AlocacaoDao = fabrica.criaAlocacaoDao();
//        return AlocacaoDao.getAlocacao(descricao);
//    }
//    
//    public void removerAlocacao(String descricao) throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        AlocacaoDaoIF alocacaoDao = fabrica.criaAlocacaoDao();
//        alocacaoDao.removerAlocacao(descricao);
//    }
    
//    public List dataBetween() throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        AlocacaoDaoIF alocacaoDao = fabrica.criaAlocacaoDao();
//        List<String[]> listaRetorno = new ArrayList();        
//        List<Alocacao> lista = alocacaoDao.DataBetween();
//        for (Alocacao lista1 : lista) {
//            String descricao = lista1.get;
//            String[] materiais = new String[]{descricao};
//            listaRetorno.add(materiais);
//        }
//        
//        return listaRetorno;
//    }
}
