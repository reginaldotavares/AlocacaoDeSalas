/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.interfaces;

import br.com.sistema.modelos.Material;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public interface MaterialDaoIF {
    
    public void inserirMaterial(Material material)throws SQLException;
    
    public void removerMaterial(Integer tombamento) throws SQLException;
    
    public void atualizarMaterial(Material material) throws SQLException;
    
//    public Material getMaterial(String descricao) throws SQLException;
    
    public Material getMaterial(Integer tombamento) throws SQLException;
    
    public ArrayList<Material> listarMaterial() throws SQLException;
    
    public List pesquisar(Integer tombamento) throws SQLException;

    public List pesquisar(String descricao) throws SQLException;
    
}
