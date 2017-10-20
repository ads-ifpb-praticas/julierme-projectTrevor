/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.validacoes;

import br.edu.ifpb.praticas.projectTrevor.beans.Usuario;
import br.edu.ifpb.praticas.projectTrevor.dao.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author JuliermeH
 */
public class ValidarUsuario {
    
    public static boolean validarNome(String ID){
        if(ID == null|| ID.isEmpty()) return false;
        return true;
    }
    
    public static boolean seExiste(String ID) throws ClassNotFoundException, SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.recuperarUsuario(ID);
        if(usuario.equals(null)) return false;
        return true;
    }
    
}
