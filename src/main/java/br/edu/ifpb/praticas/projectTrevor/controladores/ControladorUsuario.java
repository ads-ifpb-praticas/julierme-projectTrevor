/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.controladores;

import br.edu.ifpb.praticas.projectTrevor.beans.Usuario;
import br.edu.ifpb.praticas.projectTrevor.dao.UsuarioDAO;
import br.edu.ifpb.praticas.projectTrevor.validacoes.ValidarUsuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author JuliermeH
 */
@SessionScoped
@Named
public class ControladorUsuario implements Serializable{
    
    @Inject
    private UsuarioDAO dao;
    @Inject
    private Usuario usuario;
    
    public void adiciona(Usuario usuario) throws SQLException{dao.adicionaUsuario(usuario);}
    public void remover(Usuario usuario) throws SQLException{dao.removeUsuario(usuario);}
    public void atualiza(Usuario usuario) throws SQLException{dao.atulizarUsuario(usuario);}
    public Usuario recuperar(Usuario usuario) throws SQLException{return dao.recuperarUsuario(usuario.getID());}
    public List<Usuario> usuarios() throws SQLException{return dao.listarUsuarios();}
    
    public String login(String id, String senha){
        try {
            this.usuario = dao.recuperarUsuario(id);
            return "home?faces-redirect = true";
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index?faces-redirect=true";
    }
    
    public String atulizaEmail(String email) throws SQLException{
        this.usuario.setEmail(email);
        this.dao.atulizarEmail(usuario);
        return "home?faces-redirect=true";
    }
    
    public String atulizaSenha(String senha) throws SQLException{
        this.usuario.setSenha(senha);
        this.dao.atulizarSenha(usuario);
        return "home?faces-redirect=true";
    }
    
    public String cadastrar(String id, String email, String senha) throws ClassNotFoundException{
        if(id == null || senha == null)return "cadastro?faces-redirect=true";
        else{
            try {
                if(ValidarUsuario.seExiste(id)){
                    return "cadastro?faces-redirect=true";
                }else {
                    Usuario usuario = new Usuario(id,senha,email);
                    this.dao.adicionaUsuario(usuario);
                    return "home?faces-redirect=true";
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "cadastro?faces-redirect=true";
    }
        
    public String novoCadastro(){
        return "cadastro?faces-redirect=true";
    }
    
}
