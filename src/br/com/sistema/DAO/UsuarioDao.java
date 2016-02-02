package br.com.sistema.DAO;

import br.com.sistema.conexao.ClasseConexao;
import br.com.sistema.conexao.ConnectionFactory;
import br.com.sistema.interfaces.UsuarioDaoIF;
import br.com.sistema.modelos.Feriado;
import br.com.sistema.modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDao implements UsuarioDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public UsuarioDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void inserir(Usuario usuario) throws SQLException {

       try{ 
        conexao.abrir();
        String SQL = "insert into usuario(nome, senha, email, matricula, papel, imagem) values (?,?,?,?,?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setString(1, usuario.getNome());
        pstm.setString(2, usuario.getSenha());
        pstm.setString(3, usuario.getEmail());
        pstm.setInt(4, usuario.getMatricula());
        pstm.setString(5, usuario.getPapel());
        pstm.setBytes(6, usuario.getImagem());
        pstm.executeUpdate();
    }catch(SQLException e){
           System.out.println(e);
    }
       finally {
            conexao.liberar();
        }
    }
    

    public void remover(String email) throws SQLException{
        try {
            conexao.abrir();
            
            String SQL = "delete from usuario where email=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, email);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } finally {
            conexao.liberar();
        }
    }
//
    public void atualizar(Usuario usuario) throws SQLException{
        
        try {
            conexao.abrir();
            
            String SQL = "update Usuario set nome=?, senha=?, papel=?, matricula=?, imagem=? where email=?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
            pstm.setString(3, usuario.getPapel());
            pstm.setInt(4, usuario.getMatricula());
            pstm.setBytes(5, usuario.getImagem());
            pstm.setString(6, usuario.getEmail());
            pstm.executeUpdate();
        
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }
//
//    public Usuario pesquisar(String nome) throws SQLException {
//        try {
//            conexao.abrir();
//            
//            String SQL = "select * from Usuario where nome ilike '%"+ nome +"%'";
//            
//            pstm = con.prepareStatement(SQL);
//            
//            ResultSet result = pstm.executeQuery();
//            
//            Usuario usuario = new Usuario();
//            
//            while(result.next()){
//                usuario.setEmail(result.getString("email"));
//                usuario.setNome(result.getString("nome"));
//                usuario.setApelido(result.getString("apelido"));
//                usuario.setSenha(result.getString("senha"));
//                usuario.setCidade(result.getString("cidade"));
//                usuario.setEstado(result.getString("estado"));
//                usuario.setDataNascimento(result.getString("dataNascimento"));
//                usuario.setFoto(result.getString("foto"));
//                usuario.setTipo(result.getString("tipo"));
//            }
//            return usuario;
//            
//        } catch(Exception E) { 
//            E.printStackTrace();
//        } finally {
//            conexao.liberar();
//        }
//        return null;
//    }
//    
    public Usuario logar(String email, String senha) throws SQLException {
        try {
            conexao.abrir();
       
            String SQL = "select * from Usuario where email = ? and senha = ?";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, email);
            pstm.setString(2, senha);
            
            ResultSet result = pstm.executeQuery();
            
            Usuario usuario = new Usuario();
            
            while(result.next()){
                usuario.setNome(result.getString("nome"));
                usuario.setEmail(result.getString("email"));
                usuario.setSenha(result.getString("senha"));
                usuario.setMatricula(result.getInt("matricula"));
                usuario.setPapel(result.getString("papel"));
                usuario.setImagem(result.getBytes("imagem"));
            }
            
            if (usuario.getEmail() != null && usuario.getSenha() != null){
                
                    return usuario;
                }
//                else 
//                    return false;
         
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
//    
    public List<Usuario> Listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conexao.abrir();
            
            String SQL = "select nome, email, papel, matricula from usuario";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Usuario usuario = new Usuario();
                usuario.setNome(result.getString("nome"));
                usuario.setEmail(result.getString("email"));
                usuario.setPapel(result.getString("papel"));
                usuario.setMatricula(result.getInt("matricula"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
   
    public Usuario getUsuario(String email) throws SQLException {
        
        try {
            conexao.abrir();
            String sql = "SELECT * FROM Usuario WHERE email=? or nome=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.setString(2, email);
            ResultSet result = pstm.executeQuery();
            
            Usuario usuario = new Usuario();
            if (result.next()) {
                usuario.setNome(result.getString("nome"));
                usuario.setEmail(result.getString("email"));
                usuario.setSenha(result.getString("senha"));
                usuario.setMatricula(result.getInt("matricula"));
                usuario.setPapel(result.getString("papel"));
                usuario.setImagem(result.getBytes("imagem"));
            }
                return usuario;
              } catch(Exception E) { 
                    E.printStackTrace();
               } finally {
            conexao.liberar();
        }
        return null;
       
    }

    
    public String carregaUsuario(String email) throws SQLException{
    try{
        conexao.abrir();
        Usuario usu = new Usuario();
        String sql = "select * from usuario where email = ?";
        pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        usu.setNome(rs.getString("nome")); 
       
        return usu.getNome();
    }finally { 
        conexao.liberar();
    }    
    
    }
}
