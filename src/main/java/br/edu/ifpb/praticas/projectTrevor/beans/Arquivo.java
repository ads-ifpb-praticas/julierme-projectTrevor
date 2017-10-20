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
public class Arquivo implements Serializable{
    
    private int codigo;
    private String url;
    private String nome;
    private String tipo;
    private double tamanho;
    private Usuario usuario;
    
    public Arquivo(){ }
    
    public Arquivo(int codigo, String url, String nome, String tipo, double tamanho, Usuario usuario){
        this.codigo = codigo;
        this.url = url;
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.usuario = usuario;
    }

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public String getArquivo() {return url;}
    public void setArquivo(String arquivo) {this.url = arquivo;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public double getTamanho() {return tamanho;}
    public void setTamanho(double tamanho) {this.tamanho = tamanho;}
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    
}
