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
}
