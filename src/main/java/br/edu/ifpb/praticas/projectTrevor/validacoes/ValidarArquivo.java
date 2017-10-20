/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.validacoes;

import br.edu.ifpb.praticas.projectTrevor.beans.Arquivo;
import br.edu.ifpb.praticas.projectTrevor.beans.Usuario;
import br.edu.ifpb.praticas.projectTrevor.dao.ArquivoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JuliermeH
 */
public class ValidarArquivo {
    
    public static boolean validarNome(String nome){
        if(nome == null || nome.isEmpty()) return false;
        return true;
    }
    
    public static boolean seExiste(String nome, Usuario usuario) throws ClassNotFoundException, SQLException{
        return identificadorArquivos(nome, usuario.getID()) != -1;
    }
    
    
    public static int identificadorArquivos(String nome, String usuarioID) throws ClassNotFoundException, SQLException{
        ArquivoDAO dao = new ArquivoDAO();
        List<Arquivo> arquivos = dao.arquivos();
        for(Arquivo arq: arquivos){
            if((arq.getNome() == null ? nome == null : arq.getNome().equals(nome))
                    && (arq.getUsuario().getID() == null ? usuarioID == null : arq.getUsuario().getID().equals(usuarioID))){
                return arq.getCodigo();
            }
        }
        return -1;
    }
    
}
