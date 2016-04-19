package br.com.sistema.fabricas;

import br.com.sistema.interfaces.AlocacaoDaoIF;
import br.com.sistema.interfaces.AlocacaoMaterialDaoIF;
import br.com.sistema.interfaces.FeriadoDaoIF;
import br.com.sistema.interfaces.MaterialDaoIF;
import br.com.sistema.interfaces.UsuarioDaoIF;
import br.com.sistema.interfaces.BlocoDaoIF;
import br.com.sistema.interfaces.SalaDaoIF;
import br.com.sistema.interfaces.EventoDaoIF;

public interface DaoFactoryIF {
    
    public UsuarioDaoIF criaUsuarioDao();
    public FeriadoDaoIF criaFeriadoDao();
    public MaterialDaoIF criaMaterialDao();
    public BlocoDaoIF criaBlocoDao();
    public SalaDaoIF criaSalaDao();
    public EventoDaoIF criaEventoDao();
    public AlocacaoDaoIF criaAlocacaoDao();
    public AlocacaoMaterialDaoIF criaAlocacaoMaterialDao();
}
