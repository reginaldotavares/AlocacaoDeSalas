package br.com.sistema.gerenciadores;

import br.com.sistema.fabricas.DaoFactory;
import br.com.sistema.fabricas.DaoFactoryIF;
import br.com.sistema.interfaces.FeriadoDaoIF;
import br.com.sistema.interfaces.UsuarioDaoIF;
import br.com.sistema.modelos.Feriado;
import br.com.sistema.modelos.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GerenciadorDeUsuario {
    
    public boolean adicionarUsuario(String nome, String senha, String email, Integer matricula, String papel, byte[] imagem) throws SQLException{
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setSenha(senha);
        novoUsuario.setEmail(email);
        novoUsuario.setMatricula(matricula);
        novoUsuario.setPapel(papel);
        novoUsuario.setImagem(imagem);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.inserir(novoUsuario); 
        
        return true;
    }
    
    
    
    public void removerUsuario(String email) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.remover(email);
    }
//    
    public boolean atualizaUsuario(String nome, String senha, String email, Integer matricula, String papel, byte[] imagem) throws SQLException{
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setMatricula(matricula);
        usuario.setPapel(papel);
        usuario.setImagem(imagem);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.atualizar(usuario);
        return true;
    }
//    
    public List pesquisarUsuario(String pesquisa) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Usuario> lista = usuDao.pesquisar(pesquisa);
        for (Usuario lista1 : lista) {
            String nome = lista1.getNome();
            String email = lista1.getEmail();
            String papel = lista1.getPapel();
            String matricula = lista1.getMatricula().toString();
            String[] usuario = new String[]{nome,email,papel,matricula};
            listaRetorno.add(usuario);
        }
        
        return listaRetorno;
    }
    
    public Usuario getUsuario(String email) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
        return usuario.getUsuario(email);
    }
//
    public Usuario getUsuario() throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
        Usuario u = new Usuario();
        return u;
    }
//    
//    public void atualizarFotoPerfil(String caminho, int id) throws SQLException {
//        DaoFactoryIF fabrica = DaoFactory.creatFactory();
//        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
//        usuario.atualizarImagemPerfil(caminho, id);
//    }
//    
    public Usuario logar(String email, String senha) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.logar(email, senha);
    }
    
    public List<String[]> listarUsuarios() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        List<String[]> listaRetorno = new ArrayList();        
        List<Usuario> lista = usuDao.Listar();
        for (Usuario lista1 : lista) {
            String nome = lista1.getNome();
            String email = lista1.getEmail();
            String papel = lista1.getPapel();
            String matricula = lista1.getMatricula().toString();
            String[] usuario = new String[]{nome,email,papel,matricula};
            listaRetorno.add(usuario);
        }
        
        return listaRetorno;
    }
    
    public Vector<Usuario> carregaCombo() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuarioDao = fabrica.criaUsuarioDao();
        Vector<Usuario> listaRetorno = new Vector();        
        Vector<Usuario> lista = usuarioDao.carregaCombo();
        for (Usuario lista1 : lista) {
            String nome = lista1.getNome();
            listaRetorno.add(lista1);
        }
        
        return listaRetorno;
    }
    
}
