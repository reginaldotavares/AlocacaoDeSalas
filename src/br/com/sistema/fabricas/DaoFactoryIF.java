package br.com.sistema.fabricas;

import br.com.sistema.interfaces.FeriadoDaoIF;
import br.com.sistema.interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {
    
    public UsuarioDaoIF criaUsuarioDao();
    public FeriadoDaoIF criaFeriadoDao();
}
