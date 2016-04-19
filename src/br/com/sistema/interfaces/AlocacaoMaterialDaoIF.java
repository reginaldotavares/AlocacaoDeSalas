/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.interfaces;

import br.com.sistema.modelos.AlocacaoMaterial;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public interface AlocacaoMaterialDaoIF {
    
    
    public void inserirAlocacaoMaterial(AlocacaoMaterial alocacaoMaterial)throws SQLException;
    
    public void removerAlocacaoMaterial(String descricao) throws SQLException;
    
    public void atualizarAlocacaoMaterial(AlocacaoMaterial alocacaoMaterial) throws SQLException;
    
    public List pesquisar(Integer id) throws SQLException;
    
    public AlocacaoMaterial getAlocacaoMaterial(Integer id) throws SQLException;
    
    public List<AlocacaoMaterial> listarEventoAlocacao() throws SQLException;
  
}
