/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.controller;

import br.com.sistema.gerenciadores.GerenciadorDeFeriado;
import br.com.sistema.gerenciadores.GerenciadorDeUsuario;
import br.com.sistema.modelos.Feriado;
import br.com.sistema.modelos.Usuario;
import br.com.sistema.telas.TelaInicial;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class Facade {
    BufferedImage imagem;
    
    public List autenticar(String usuario, String senha){
        List<Object> lista = new ArrayList<>();
        try {
            GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
            if(usu.logar(usuario, senha)!=null){
                JOptionPane.showMessageDialog(null, "Acesso realizado com sucesso!");
                String nomeUsuario = usu.logar(usuario, senha).getNome();
                lista.add(nomeUsuario);
                String emailUsuario = usuario;
                lista.add(emailUsuario);
                String papelUsuario = usu.logar(usuario, senha).getPapel();
                lista.add(papelUsuario);
                byte[] fotoUsuario = usu.logar(usuario, senha).getImagem();
                lista.add(fotoUsuario);
                return lista;
        } else{
            JOptionPane.showMessageDialog(null,"Acesso Negado!");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return null;
    
    }
    
    public List retornarDados(String email){
        List lista = new ArrayList();
        try {
            GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
            if(usu.getUsuario(email)!=null){
                String nomeUsuario = usu.getUsuario(email).getNome();
                lista.add(nomeUsuario);
                String emailUsuario = usu.getUsuario(email).getEmail();
                lista.add(emailUsuario);
                String senhaUsuario = usu.getUsuario(email).getSenha();
                lista.add(senhaUsuario);
                String papelUsuario = usu.getUsuario(email).getPapel();
                lista.add(papelUsuario);
                String matriculaUsuario = usu.getUsuario(email).getMatricula().toString();
                lista.add(matriculaUsuario);
                byte[] fotoUsuario = usu.getUsuario(email).getImagem();
                lista.add(fotoUsuario);
                return lista;
        } else{
            JOptionPane.showMessageDialog(null,"Acesso Negado!");
        }
        } catch (Exception e) {
        }
        return null;
    
    }
    
    public List retornarDadosFeriado(Date data){
        List lista = new ArrayList();
        try {
            GerenciadorDeFeriado fer = new GerenciadorDeFeriado();
            if(fer.getFeriado(data)!=null){
                String nomeFeriado = fer.getFeriado(data).getNomeFeriado();
                lista.add(nomeFeriado);
                Date dataFeriado = fer.getFeriado(data).getData();
                lista.add(dataFeriado);
                
                return lista;
        } else{
            JOptionPane.showMessageDialog(null,"Acesso Negado!");
        }
        } catch (Exception e) {
        }
        return null;
    
    }
 
    public void cadastrar(String nome, String senha, String email, String matricula, String papel, byte[] imagem) throws SQLException{
        GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
        int mat = Integer.parseInt(matricula);
        Boolean foi = usu.adicionarUsuario(nome, senha, email, mat, papel, imagem);
            if(foi){
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não Cadastrado!");
            }

    }
    
    public void cadastrarFeriado(String nomeFeriado, Date data) throws SQLException{
        GerenciadorDeFeriado feriado = new GerenciadorDeFeriado();
        Boolean foi = feriado.adicionarFeriado(nomeFeriado, data);
            if(foi){
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não Cadastrado!");
            }
//            return true;
    }
    
    public void editar(String nome, String senha, String email, String matricula, String papel, byte[] imagem) throws SQLException{
        GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
        int mat = Integer.parseInt(matricula);
        if(usu.getUsuario(email) != null){
        Boolean foi = usu.atualizaUsuario(nome, senha, email, mat, papel, imagem);
            if(foi){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não Atualizado!");
            }
        }else{
            
        }
       
    }
    
    public void editarFeriado(String nome, Date data) throws SQLException{
        GerenciadorDeFeriado feriado = new GerenciadorDeFeriado();
        Boolean foi = feriado.atualizaFeriado(nome, data);
            if(foi){
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Não Atualizado!");
            }
       
    }
    
    public List<String[]> listar() throws SQLException{
       GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
       return usu.listarUsuarios();
    }
    
    public List<String[]> listarFeriado() throws SQLException{
        GerenciadorDeFeriado fer = new GerenciadorDeFeriado();
        return fer.listarFeriados();
    }
    
    
    public Usuario getUsuario() throws SQLException{
        GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
        return usu.getUsuario();
    }
    
    public Feriado getFeriado(Date data) throws SQLException{
        GerenciadorDeFeriado fer = new GerenciadorDeFeriado();
        return fer.getFeriado(data);
    }
    
    public void excluirUsuario(String email) throws SQLException{
        GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
        usu.removerUsuario(email);
    }
    
    public void excluirFeriado(Date data) throws SQLException{
        GerenciadorDeFeriado fer = new GerenciadorDeFeriado();
        fer.removerFeriado(data);
    }
    
    public BufferedImage selecionarImagem(File arquivo){

            imagem = setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
            return imagem;
            
    }
    
    public BufferedImage setImagemDimensao(String caminhoImg, Integer imgLargura, Integer imgAltura){
        
        Double novaImgLargura = null;
        Double novaImgAltura = null;
        Double imgProporcao = null;
        Graphics2D g2d = null;
        BufferedImage imagem = null, novaImagem = null;
        
        try{
           //Obtém a imagem a ser redimensionadad
            imagem = ImageIO.read(new File(caminhoImg));
        }catch(IOException ex){
            System.out.println(ex.getMessage());
//            Logger.getLogger(ManipularImagem.class.getName()).log(Level.SEVERE, null);
        }
        
        //Obtém a largura da imagem
        novaImgLargura = (double) imagem.getWidth();
        //Obtém a altura da imagem
        novaImgAltura = (double) imagem.getHeight();
        
        if (novaImgLargura >= imgLargura){
            imgProporcao = (novaImgAltura/novaImgLargura);
            novaImgLargura = (double) imgLargura;
            
            while(novaImgAltura > imgAltura){
                novaImgLargura = (double) (--imgLargura);
                novaImgAltura = (novaImgLargura * imgProporcao);
            }
     
        }else if(novaImgAltura >= imgAltura){
            imgProporcao = (novaImgLargura/novaImgAltura);
            novaImgAltura = (double) imgAltura;
            
            while(novaImgLargura > imgLargura){
                novaImgAltura = (double) (--imgAltura);
                novaImgLargura = (novaImgAltura * imgProporcao);
            }
        }
        
        novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        g2d = novaImagem.createGraphics();
        g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);
        
        return novaImagem;
        
    }
    
    public byte[] getImgBytes(BufferedImage image){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try{
            ImageIO.write(image, "JPEG", baos);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        
        return baos.toByteArray();
    }
    
    public void exibirImagemLabel(byte[] minhaImagem, javax.swing.JLabel label){
        
        if(minhaImagem != null){
            InputStream input = new ByteArrayInputStream(minhaImagem);
            try{
                BufferedImage imagem = ImageIO.read(input);     
                label.setIcon(new ImageIcon(imagem));
            }catch(IOException ex){
                
            }
        }else{
            label.setIcon(null);
        }
        
    }
    
    public boolean isNomeValid(String nome) {
        String nomePattern = "(?=\\w.*[a-z])(?=\\w.*(_|[^\\w ])).+";
        Pattern pattern = Pattern.compile(nomePattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }
    
    public boolean isEmailValid(String email) {

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    
    public boolean isSenhaValid(String senha) {
        Integer minCaracteres = 8;
//        String senhaPattern = "^.*(?=.{5,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^=]).*$";
        String senhaPattern = "(?=\\w.*[a-z])(?=\\w.*[A-Z])(?=\\w.*(_|[^\\w ])).+";
        if(senha.length() < minCaracteres){   
                return false;
        }else{
            Pattern pattern = Pattern.compile(senhaPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(senha);
            return matcher.matches();        
        } 
    
    } 
    
    public boolean isNumeroValid(String matricula) {
        String matriculaPattern = "^\\d{6}+$";
        Pattern pattern = Pattern.compile(matriculaPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(matricula);
        return matcher.matches();
    }
    
    public void preencherObjeto(String email) throws SQLException{
        GerenciadorDeUsuario usu = new GerenciadorDeUsuario();
        Usuario usuario = usu.getUsuario(email);
        
        
    }
    
     public void carregarTabela() throws SQLException{
         
         
     }
    
         
    
}
