package br.com.sistema.interfaces;


import br.com.sistema.modelos.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public interface UsuarioDaoIF {
    
public void inserir(Usuario u)throws SQLException;
    
public void remover(String email)throws SQLException;
//
public void atualizar(Usuario u)throws SQLException;
//
public List pesquisar(String email)throws SQLException;
//
//public boolean verificarExistenciaEmail(String email) throws SQLException;
//
public Usuario logar(String email, String senha)throws SQLException;
//
public List<Usuario> Listar() throws SQLException;
//
//public void atualizarImagemPerfil(String path, int idUsuario)throws SQLException;
//
public Usuario getUsuario(String email) throws SQLException;
//

public Vector<Usuario> carregaCombo() throws SQLException;
//public Usuario getUsuario(Integer id) throws SQLException;
}
