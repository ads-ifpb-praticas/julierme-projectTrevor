/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.beans;

import java.io.Serializable;

/**
 *
 * @author JuliermeH
 */
public class Solicitacao implements Serializable{
    
    private int codigo;
    private Usuario remetente;
    private Usuario destinatario;
    private Arquivo arquivo;
    
    public Solicitacao(){ }
    
    public Solicitacao(int codigo, Usuario remetente, Usuario destinatario, Arquivo arquivo){
        this.codigo = codigo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.arquivo = arquivo;
    }

    public int getCodSolicitacao() {return codigo;}
    public void setCodSolicitacao(int codigo) {this.codigo = codigo;}
    public Usuario getRemetente() {return remetente;}
    public void setRemetente(Usuario remetente) {this.remetente = remetente;}
    public Usuario getDestinatario() {return destinatario;}
    public void setDestinatario(Usuario destinatario) {this.destinatario = destinatario;}
    public Arquivo getArquivo() {return arquivo;}
    public void setArquivo(Arquivo arquivo) {this.arquivo = arquivo;}
    
}
