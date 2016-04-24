/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.gerenciadores;

import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.AlocacaoMaterialDaoIF;
import br.com.sistema.modelos.AlocacaoMaterial;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeAlocacaoMaterial {
    public boolean adicionarAlocacaoMaterial(Integer tombamento, String nomeEvento, String local) throws SQLException{
        AlocacaoMaterial novaAlocacaoMaterial = new AlocacaoMaterial();
        novaAlocacaoMaterial.setTombamento(tombamento);
        novaAlocacaoMaterial.setNomeEvento(nomeEvento);
        novaAlocacaoMaterial.setLocal(local);
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AlocacaoMaterialDaoIF alocacao = fabrica.criaAlocacaoMaterialDao();
        alocacao.inserirAlocacaoMaterial(novaAlocacaoMaterial);
        return true;
    }
    
    public List<AlocacaoMaterial> listarAlocacaoMaterial() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AlocacaoMaterialDaoIF alocacaoMaterialDao = fabrica.criaAlocacaoMaterialDao();
        List<AlocacaoMaterial> listaRetorno = new ArrayList<AlocacaoMaterial>();        
        List<AlocacaoMaterial> lista = alocacaoMaterialDao.listarAlocacaoMaterial();
        for (AlocacaoMaterial lista1 : lista) {
            Integer id = lista1.getId();
            Integer tombamento = lista1.getTombamento();
            String nomeEvento = lista1.getNomeEvento();
            String local = lista1.getLocal();
            AlocacaoMaterial alocacao = new AlocacaoMaterial(id, tombamento, nomeEvento, local);
            listaRetorno.add(alocacao);
        }
        
        return listaRetorno;
    }
    
    public AlocacaoMaterial getAlocacaoMaterial(String local) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AlocacaoMaterialDaoIF AlocacaoMaterialDao = fabrica.criaAlocacaoMaterialDao();
        return AlocacaoMaterialDao.getAlocacaoMaterial(local);
    }
    
    public AlocacaoMaterial getAlocacaoMaterialPorTombamento(Integer tombamento) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AlocacaoMaterialDaoIF AlocacaoMaterialDao = fabrica.criaAlocacaoMaterialDao();
        return AlocacaoMaterialDao.getAlocacaoMaterialPorTombamento(tombamento);
    }
}
