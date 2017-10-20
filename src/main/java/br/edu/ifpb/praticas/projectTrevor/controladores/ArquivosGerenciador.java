/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.controladores;

import br.edu.ifpb.praticas.projectTrevor.beans.Arquivo;
import br.edu.ifpb.praticas.projectTrevor.beans.Usuario;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author JuliermeH
 */
public class ArquivosGerenciador implements Serializable{
    
    private static final String URL = "";
    
    public static Arquivo arquivoBase64(Part part) throws IOException{
        byte[] bytes = new byte[(int)part.getSize()];
        new BufferedInputStream(part.getInputStream()).read(bytes);
        String arqBase64 = Base64.getEncoder().encodeToString(bytes);
        Arquivo arquivo = new Arquivo();
        arquivo.setArquivo(arqBase64);
        arquivo.setTamanho((int)part.getSize());
        arquivo.setTipo(part.getContentType());
        arquivo.setNome(part.getName());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        arquivo.setUsuario(usuario);
        return arquivo;
    }
    
    public static File arquivoExtrair(Arquivo arquivo) throws FileNotFoundException, IOException{
        byte[] arqBytes = Base64.getDecoder().decode(arquivo.getArquivo());
        new FileOutputStream((URL) + arquivo.getArquivo().hashCode()
                + arquivo.getTipo()).write(arqBytes);
        File arq = new File(URL + arquivo.getArquivo().hashCode());
        return arq;
    }
}
