/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.controladores;

import br.edu.ifpb.praticas.projectTrevor.dao.ArquivoDAO;
import br.edu.ifpb.praticas.projectTrevor.beans.Arquivo;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author JuliermeH
 */
@RequestScoped
@Named
public class ExploradorArquivos implements Serializable{
    
    @Inject
    private ArquivoDAO arqdao;
    @Inject
    private List<Arquivo> arquivos;
    
    public ArquivoDAO getDAOArquivo() {return arqdao;}
    public void setDAOArquivo(ArquivoDAO dao) {this.arqdao = arqdao;}
    public List<Arquivo> getArquivos() {return arquivos;}
    public void setArquivo(List<Arquivo> arquivos) {this.arquivos = arquivos;}
    public String salvarArquivo(Part part) throws IOException{
        ArquivosGerenciador.arquivoBase64(part);
        return "home?faces-redirect = true";
    }
    
}
