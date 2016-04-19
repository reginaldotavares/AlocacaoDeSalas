package br.com.sistema.fabricas;

import br.com.sistema.dao.AlocacaoDao;
import br.com.sistema.dao.AlocacaoMaterialDao;
import br.com.sistema.dao.BlocoDao;
import br.com.sistema.dao.EventoDao;
import br.com.sistema.dao.FeriadoDao;
import br.com.sistema.dao.MaterialDao;
import br.com.sistema.dao.SalaDao;
import br.com.sistema.dao.UsuarioDao;
import br.com.sistema.interfaces.AlocacaoDaoIF;
import br.com.sistema.interfaces.AlocacaoMaterialDaoIF;
import br.com.sistema.interfaces.BlocoDaoIF;
import br.com.sistema.interfaces.EventoDaoIF;
import br.com.sistema.interfaces.FeriadoDaoIF;
import br.com.sistema.interfaces.MaterialDaoIF;
import br.com.sistema.interfaces.SalaDaoIF;
import br.com.sistema.interfaces.UsuarioDaoIF;


public class DaoFactoryBD implements DaoFactoryIF{
    
    private DaoFactoryBD instance;

    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }
    
    public FeriadoDaoIF criaFeriadoDao() {
        return new FeriadoDao();
    }
    
    public MaterialDaoIF criaMaterialDao() {
        return new MaterialDao();
    }
    
    public BlocoDaoIF criaBlocoDao() {
        return new BlocoDao();
    }
    
    public SalaDaoIF criaSalaDao() {
        return new SalaDao();
    }
    
    public EventoDaoIF criaEventoDao() {
        return new EventoDao();
    }
    
    public AlocacaoDaoIF criaAlocacaoDao() {
        return new AlocacaoDao();
    }
    
    public AlocacaoMaterialDaoIF criaAlocacaoMaterialDao() {
        return new AlocacaoMaterialDao();
    }

}
