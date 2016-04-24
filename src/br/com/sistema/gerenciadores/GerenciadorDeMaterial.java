/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.gerenciadores;

import br.com.sistema.dao.AlocacaoMaterialDao;
import br.com.sistema.dao.MaterialDao;
import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.AlocacaoMaterialDaoIF;
import br.com.sistema.interfaces.MaterialDaoIF;
import br.com.sistema.interfaces.MaterialDaoIF;
import br.com.sistema.modelos.AlocacaoMaterial;
import br.com.sistema.modelos.Material;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeMaterial {
    
    public boolean adicionarMaterial(String descricao) throws SQLException{
        Material novoMaterial = new Material();
        novoMaterial.setDescricao(descricao);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF material = fabrica.criaMaterialDao();
        material.inserirMaterial(novoMaterial);
        return true;
    }
    
    public void removerMaterial(Integer tombamento) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
        materialDao.removerMaterial(tombamento);
    }
//    
    public boolean atualizaMaterial(Integer tombamento, String descricao) throws SQLException{
        Material material = new Material();
        material.setTombamento(tombamento);
        material.setDescricao(descricao);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
        materialDao.atualizarMaterial(material);
        return true;
    }
    
    public boolean atualizaMaterialFalse(Integer tombamento) throws SQLException{
        Material material = new Material();
        material.setTombamento(tombamento);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
        materialDao.atualizarMaterialFalse(material);
        return true;
    }
    
//    public Material getMaterial(String descricao) throws SQLException {
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
//        return materialDao.getMaterial(descricao);
//    }
   
    
    public Material getMaterial(Integer tombamento) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
        return materialDao.getMaterial(tombamento);
    }
    
    public List<String[]> listarMaterials() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
        AlocacaoMaterialDaoIF alocacaoMaterialDao = fabrica.criaAlocacaoMaterialDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Material> lista = materialDao.listarMaterial();        
        int n=0;
        for (int i = 0; i<lista.size();i++) {
        List<AlocacaoMaterial> listaAlocacao = alocacaoMaterialDao.listarAlocacaoMaterial();
            String nomeMaterial = lista.get(i).getDescricao();
            String tombamento = lista.get(i).getTombamento().toString();
            String local = "N/A";
            String status;
//            String status = "Disponível";
//            for(int k=0;listaAlocacao.size()>k;k++){
//            String tombamento2 = listaAlocacao.get(n).getTombamento().toString();
                if (lista.get(i).getStatus() == true) {
                    status = "Disponível";
//                    n++;
                    String[] materiais = new String[]{nomeMaterial, tombamento, status, local};
                    listaRetorno.add(materiais);
                }else {
//                    if(tombamento2 == null ? tombamento == null : tombamento2.equals(tombamento)){
//                    status = "Emprestado";  
                    status = "Emprestado";
                    if(n<lista.size()){
                        local = listaAlocacao.get(n).getLocal();
                        n++;
                    }
                    String[] materiais = new String[]{nomeMaterial, tombamento, status, local};
                    listaRetorno.add(materiais);
                }
//            }
                    
//                }
            
        }
        
        
        return listaRetorno;
    }
    
    public List pesquisarMaterial(Integer pesquisa) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Material> lista = materialDao.pesquisar(pesquisa);
        for (Material lista1 : lista) {
            String descricao = lista1.getDescricao();
            String tombamento = lista1.getTombamento().toString();
            String status;
//            if(lista1.isStatus()){
//                status = "Disponível";
//            }else status = "Emprestado";
            String[] materiais = new String[]{descricao,tombamento};
            listaRetorno.add(materiais);
        }
        
        return listaRetorno;
    }
    
    public ArrayList ListarMateriais() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();        
        ArrayList<Material> lista = materialDao.listarMaterial();
        
        
        return lista;
    }
    
    public ArrayList ListarMateriaisSelecao() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();        
        ArrayList<Material> lista = materialDao.listarMaterialSelecao();
        
        
        return lista;
    }
    
    public List pesquisarMaterial(String pesquisa) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        MaterialDaoIF materialDao = fabrica.criaMaterialDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Material> lista = materialDao.pesquisar(pesquisa);
        for (Material lista1 : lista) {
            String descricao = lista1.getDescricao();
            String tombamento = lista1.getTombamento().toString();
            String status;
//            if(lista1.isStatus()){
//                status = "Disponível";
//            }else status = "Emprestado";
            String[] materiais = new String[]{descricao,tombamento};
            listaRetorno.add(materiais);
        }
        
        return listaRetorno;
    }
    
    
    
}
