/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controller;

import br.com.sistema.gerenciadores.GerenciadorDeAlocacao;
import br.com.sistema.gerenciadores.GerenciadorDeAlocacaoMaterial;
import br.com.sistema.gerenciadores.GerenciadorDeBloco;
import br.com.sistema.gerenciadores.GerenciadorDeEvento;
import br.com.sistema.gerenciadores.GerenciadorDeMaterial;
import br.com.sistema.gerenciadores.GerenciadorDeSala;
import br.com.sistema.modelos.Alocacao;
import br.com.sistema.modelos.AlocacaoMaterial;
import br.com.sistema.modelos.Bloco;
import br.com.sistema.modelos.Evento;
import br.com.sistema.modelos.Material;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

/**
 *
 * @author Reginaldo
 */
public class FacadeAssistente {
    
    public void cadastrarMaterial(String descricao, Integer quantidade) throws SQLException {
        for(int i=1;i<=quantidade;i++){
            GerenciadorDeMaterial material = new GerenciadorDeMaterial();
            material.adicionarMaterial(descricao);
            
        }
            
    }
    
    public void cadastrarBloco(String descricao) throws SQLException {
            GerenciadorDeBloco bloco = new GerenciadorDeBloco();
            bloco.adicionarBloco(descricao);
            
    }
    
//    public void cadastrarEventoAlocacao(Timestamp inicio, Timestamp fim, String nomeEvento, String local) throws SQLException {
//            GerenciadorDeAlocacao alocacao = new GerenciadorDeAlocacao();
//            alocacao.adicionarEventoAlocacao(inicio, fim, nomeEvento, local);
//            
//    }
    
    public void cadastrarSala(String descricao, String bloco, Integer capacidade, String tipoSala) throws SQLException {
            GerenciadorDeSala sala = new GerenciadorDeSala();
            sala.adicionarSala(descricao, bloco, capacidade, tipoSala);        
    }
    
    public boolean cadastrarEvento(String nome, String descricao, Integer participantes, String responsavel, Timestamp inicio, Timestamp fim) throws SQLException {
        GerenciadorDeEvento evento = new GerenciadorDeEvento();
        evento.adicionarEvento(nome, descricao, participantes, responsavel, inicio, fim);        
        return true;
    }
    
    public boolean cadastrarAlocacao(Integer id_evento, String descricao, String sala) throws SQLException {
        GerenciadorDeAlocacao alocacao = new GerenciadorDeAlocacao();
        alocacao.adicionarAlocacao(id_evento, descricao, sala);        
        return true;
    }
    
    public boolean cadastrarAlocacaoMaterial(Integer tombamento, String descricao, String local) throws SQLException {
        GerenciadorDeAlocacaoMaterial alocacao = new GerenciadorDeAlocacaoMaterial();
        alocacao.adicionarAlocacaoMaterial(tombamento, descricao, local);        
        return true;
    }
    
    public List<String[]> listar() throws SQLException {
        GerenciadorDeMaterial material = new GerenciadorDeMaterial();
        return material.listarMaterials();
    }
    
    public ArrayList<Material> listarMateriais() throws SQLException {
        GerenciadorDeMaterial material = new GerenciadorDeMaterial();
        return material.ListarMateriais();
    }

    public ArrayList<Material> listarMateriaisSelecao() throws SQLException {
        GerenciadorDeMaterial material = new GerenciadorDeMaterial();
        return material.ListarMateriaisSelecao();
    }
    
    public List<String[]> listarBloco() throws SQLException {
        GerenciadorDeBloco bloco = new GerenciadorDeBloco();
        return bloco.listarBlocos();
    }
    
    public List<String[]> listarSala() throws SQLException {
        GerenciadorDeSala sala = new GerenciadorDeSala();
        return sala.listarSala();
    }
    
    public List<String[]> listarPesquisaSala() throws SQLException {
        GerenciadorDeSala sala = new GerenciadorDeSala();
        return sala.ListarpesquisarSala();
    }
    
    public List<String[]> listarEvento() throws SQLException {
        GerenciadorDeEvento evento = new GerenciadorDeEvento();
        return evento.listarEvento();
    }
    
    public List<Evento> listarEventoCampo() throws SQLException {
        GerenciadorDeEvento evento = new GerenciadorDeEvento();
        return evento.listarEventoCampo();
    }
    
    public List<String[]> listarEvento2() throws SQLException {
        GerenciadorDeEvento evento = new GerenciadorDeEvento();
        return evento.listarEvento2();
    }
    
    public List<String[]> retornarMaterial(String descricao) throws SQLException{
         GerenciadorDeMaterial material = new GerenciadorDeMaterial();
          return material.pesquisarMaterial(descricao);
    }
    
    public List<String[]> retornarPesquisaSala(String descricao) throws SQLException{
         GerenciadorDeSala sala = new GerenciadorDeSala();
          return sala.pesquisarSala(descricao);
    }
    
    public List<String[]> retornarPesquisaEvento(String NomeEvento) throws SQLException{
         GerenciadorDeEvento evento = new GerenciadorDeEvento();
          return evento.pesquisarEvento(NomeEvento);
    }
    
    public List<String[]> retornarSala(String nome) throws SQLException{
        List lista = new ArrayList();
        try {
            GerenciadorDeSala sala = new GerenciadorDeSala();
            if (sala.getSala(nome)!= null) {
                String desc = sala.getSala(nome).getNomeSala();
                lista.add(desc);
                String bloco = sala.getSala(nome).getBloco();
                lista.add(bloco);
                Integer capacidade = sala.getSala(nome).getCapacidade();
                lista.add(capacidade);
                String tipo = sala.getSala(nome).getTipo();
                lista.add(tipo);
                
                return lista;
            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    
    }
    
    public List<String[]> retornarPesquisaBloco(String descricao) throws SQLException{
         GerenciadorDeBloco bloco = new GerenciadorDeBloco();
          return bloco.pesquisarBloco(descricao);
    }

    public Vector<Bloco> carregaComboBloco() throws SQLException {
        GerenciadorDeBloco bloco = new GerenciadorDeBloco();
        return bloco.carregaCombo();
    }
    
    public Vector<Evento> carregaComboEvento() throws SQLException {
        GerenciadorDeEvento evento = new GerenciadorDeEvento();
        return evento.carregaCombo();
    }
    
    public List<String[]> retornarBloco(String descricao) throws SQLException{
        List lista = new ArrayList();
        try {
            GerenciadorDeBloco bloco = new GerenciadorDeBloco();
            if (bloco.getBloco(descricao)!= null) {
                String desc = bloco.getBloco(descricao).getNome();
                lista.add(desc);
                Integer idBloco = bloco.getBloco(descricao).getId();
                lista.add(idBloco);
                return lista;
            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public List<String[]> retornarMaterial(Integer tombamento) throws SQLException{
        List lista = new ArrayList();
        try {
            GerenciadorDeMaterial material = new GerenciadorDeMaterial();
            if (material.getMaterial(tombamento)!= null) {
                String desc = material.getMaterial(tombamento).getDescricao();
                lista.add(desc);
                Integer tomb = material.getMaterial(tombamento).getTombamento();
                lista.add(tomb);
                String status;
//                if(material.getMaterial(tombamento).isStatus()){
//                    status = "Disponível";
//                }else status = "Emprestado";
//                lista.add(status);
                
                return lista;
            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    
    }
    
    public void editar(String tombamento, String descricao) throws SQLException {
        Integer tomb = Integer.parseInt(tombamento);
        GerenciadorDeMaterial material = new GerenciadorDeMaterial();
        Boolean foi = material.atualizaMaterial(tomb, descricao);
            if(foi){    
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não Atualizado!");
            }
    }
    
    public void editarFalse(Integer tombamento) throws SQLException {
        GerenciadorDeMaterial material = new GerenciadorDeMaterial();
        material.atualizaMaterialFalse(tombamento);
            
    }
    
    public void editarBloco(String descricao, Integer id) throws SQLException {
        GerenciadorDeBloco bloco = new GerenciadorDeBloco();
        Boolean foi = bloco.atualizaBloco(descricao, id);
            if(foi){    
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não Atualizado!");
            }
    }
    
    public void editarSala(String nome, String bloco, Integer capacidade, String Tipo) throws SQLException {
        GerenciadorDeSala sala = new GerenciadorDeSala();
//        Integer capacity = Integer.parseInt(capacidade);
        Boolean foi = sala.atualizaSala(nome, bloco, capacidade, Tipo);
            if(foi){    
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não Atualizado!");
            }
    }
    
    public boolean excluirMaterial(Integer tombamento) throws SQLException{
        GerenciadorDeMaterial material = new GerenciadorDeMaterial();
        material.removerMaterial(tombamento);
        return true;
    }
    
    public boolean excluirSala(String nome) throws SQLException{
        GerenciadorDeSala sala = new GerenciadorDeSala();
        sala.removerSala(nome);
        return true;
    }
    
    public Integer getEvento(String nome) throws SQLException{
        GerenciadorDeEvento evento = new GerenciadorDeEvento();
        return evento.getEvento(nome).getId();
    }
    
    public Alocacao getAlocacao(String descricao) throws SQLException{
        GerenciadorDeAlocacao alocacao = new GerenciadorDeAlocacao();
        return alocacao.getAlocacao(descricao);
    }
    
    public Alocacao getAlocacaoPorSala(String sala) throws SQLException{
        GerenciadorDeAlocacao alocacao = new GerenciadorDeAlocacao();
        return alocacao.getAlocacaoPorSala(sala);
    }
    
    public AlocacaoMaterial getAlocacaoMaterial(String local) throws SQLException{
        GerenciadorDeAlocacaoMaterial alocacaoMaterial = new GerenciadorDeAlocacaoMaterial();
        return alocacaoMaterial.getAlocacaoMaterial(local);
    }
    
    public AlocacaoMaterial getAlocacaoMaterialPorTombamento(Integer tombamento) throws SQLException{
        GerenciadorDeAlocacaoMaterial alocacaoMaterial = new GerenciadorDeAlocacaoMaterial();
        return alocacaoMaterial.getAlocacaoMaterialPorTombamento(tombamento);
    }
    
    public boolean excluirBloco(String descricao) throws SQLException{
        GerenciadorDeBloco bloco = new GerenciadorDeBloco();
        bloco.removerBloco(descricao);
        return true;
    }
    
//    public List dataBetween() throws SQLException{
//        GerenciadorDeEvento evento = new GerenciadorDeEvento();
//        if(evento.){
//            return true;     
//        }
//        return false;
//    }
}
