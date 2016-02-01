package br.com.sistema.fabricas;

import br.com.sistema.DAO.FeriadoDao;
import br.com.sistema.DAO.UsuarioDao;
import br.com.sistema.interfaces.FeriadoDaoIF;
import br.com.sistema.interfaces.UsuarioDaoIF;


public class DaoFactoryBD implements DaoFactoryIF{
    
    private DaoFactoryBD instance;

    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }
    
    public FeriadoDaoIF criaFeriadoDao() {
        return new FeriadoDao();
    }
    

}
