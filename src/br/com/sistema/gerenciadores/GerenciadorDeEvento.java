/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.gerenciadores;

import br.com.sistema.controller.ConverterData;
import br.com.sistema.dao.AlocacaoDao;
import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.AlocacaoDaoIF;
import br.com.sistema.interfaces.AlocacaoMaterialDaoIF;
import br.com.sistema.interfaces.EventoDaoIF;
import br.com.sistema.modelos.Alocacao;
import br.com.sistema.modelos.AlocacaoMaterial;
import br.com.sistema.modelos.Evento;
import br.com.sistema.modelos.EventoAlocacao;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeEvento {
    ConverterData converter = new ConverterData();
    public boolean adicionarEvento(String nome, String descricao, Integer participantes, String responsavel, Timestamp inicio, Timestamp fim) throws SQLException{
        Evento novoEvento = new Evento();
        novoEvento.setNome(nome);
        novoEvento.setDescricao(descricao);
        novoEvento.setParticipantes(participantes);
        novoEvento.setResponsavel(responsavel);
        novoEvento.setInicio(inicio);
        novoEvento.setFim(fim);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        EventoDaoIF evento = fabrica.criaEventoDao();
        evento.inserirEvento(novoEvento);
        return true;
    }
    
    public List<String[]> listarEvento() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AlocacaoDaoIF alocacaoDao = fabrica.criaAlocacaoDao();
        AlocacaoMaterialDaoIF alocacaoMaterialDao = fabrica.criaAlocacaoMaterialDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<EventoAlocacao> lista = alocacaoDao.listarEventoAlocacao();
        for (EventoAlocacao lista1 : lista) {
            String duracao = converter.subTimeStamps(lista1.getInicio(), lista1.getFim());
            String nome = lista1.getNomeEvento();
            String local = lista1.getLocal();
            String string = lista1.getInicio().toString().substring(0, 10);
            String dataFormatada = string.substring(8, 10)+"/"+string.substring(5, 7)+"/"+string.substring(0, 4);
            String inicio = dataFormatada +" às "+lista1.getInicio().toString().substring(11, 13)+"h"+lista1.getInicio().toString().substring(14, 16);
            String situacao = null;
            String fim = lista1.getFim().toString(); 
            Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
            List<EventoAlocacao> lis = alocacaoDao.DataBetween();
            List<EventoAlocacao> l = alocacaoDao.DataAtualMaior();
            AlocacaoMaterial alocMat = alocacaoMaterialDao.getAlocacaoMaterial(local);
            String localMaterial = alocMat.getLocal();
            boolean mensagem = false;
            if(lis!=null){
                for(EventoAlocacao lista2 : lis){
                    if(lista1.getNomeEvento().equals(lista2.getNomeEvento())){
                        if(lista2.getNomeEvento()!=null){
                            situacao = "em andamento";
                        }
                    } else mensagem=true;              
                }
            }else mensagem=true;
            if(mensagem == true){
                if(dataDeHoje.getTime() > lista1.getInicio().getTime()&& localMaterial!=null){
                    situacao = "Concluído com Pendência";
                }else if(dataDeHoje.getTime() > lista1.getInicio().getTime()&& localMaterial == null){
                    situacao = "Concluído";
                }else if(local == null){
                    situacao = "Pendente de Alocação";
                }else situacao = "Agendado";
            } 

                String[] eventos = new String[]{inicio, duracao, nome, situacao, local};
                listaRetorno.add(eventos);    
        }     
        
        return listaRetorno;
    }
    
    public List pesquisarEvento(String NomeEvento) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        EventoDaoIF eventoDao = fabrica.criaEventoDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Evento> lista = eventoDao.pesquisarEvento(NomeEvento);
        for (Evento lista1 : lista) {
            String id = lista1.getId().toString();
            String nome = lista1.getNome();
            String descricao = lista1.getDescricao();
            String participantes = lista1.getParticipantes().toString();
            String responsavel = lista1.getResponsavel();
            String inicio = lista1.getInicio().toString();
            String fim = lista1.getFim().toString();
            String[] eventos = new String[]{nome, descricao, participantes, responsavel, inicio, fim, id};
            listaRetorno.add(eventos);
        }
        
        return listaRetorno;
    }
    
    public Vector<Evento> carregaCombo() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        EventoDaoIF eventoDao = fabrica.criaEventoDao();
        AlocacaoDaoIF alocacaoDao = fabrica.criaAlocacaoDao();
        Vector<Evento> listaRetorno = new Vector();        
        Vector<Evento> lista = eventoDao.carregaCombo();
        for (Evento lista1 : lista) {
            String nome = lista1.getNome();
            
            if(alocacaoDao.pesquisar(nome)==null){
                listaRetorno.add(lista1);    
            }
        }
        
        return listaRetorno;
    }
//    
//    public boolean atualizaSala(String nome, String bloco, Integer capacidade, String tipo) throws SQLException{
//        Sala sala = new Sala();
//        sala.setNomeSala(nome);
//        sala.setBloco(bloco);
//        sala.setCapacidade(capacidade);
//        sala.setTipo(tipo);
//        
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        SalaDaoIF salaDao = fabrica.criaSalaDao();
//        salaDao.atualizarSala(sala);
//        return true;
//    }
//    
    public Evento getEvento(String nome) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        EventoDaoIF eventoDao = fabrica.criaEventoDao();
        return eventoDao.getEvento(nome);
    }
//    
//    public void removerSala(String descricao) throws SQLException{
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        SalaDaoIF salaDao = fabrica.criaSalaDao();
//        salaDao.removerSala(descricao);
//    }
    
    public List<String[]> listarEvento2() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        EventoDaoIF eventoDao = fabrica.criaEventoDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Evento> lista = eventoDao.listarEvento();
        for (Evento lista1 : lista) {
            String id = lista1.getId().toString();
            String nome = lista1.getNome();
            String descricao = lista1.getDescricao();
            String participantes = lista1.getParticipantes().toString();
            String responsavel = lista1.getResponsavel();
            String inicio = lista1.getInicio().toString();
            String fim = lista1.getFim().toString();
            String[] eventos = new String[]{id, nome, descricao, participantes, responsavel, inicio, fim};
            listaRetorno.add(eventos);
        }
        
        return listaRetorno;
    }
    
    public List<Evento> listarEventoCampo() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        EventoDaoIF eventoDao = fabrica.criaEventoDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Evento> lista = eventoDao.listarEvento();
        
        
        return lista;
    }
}
