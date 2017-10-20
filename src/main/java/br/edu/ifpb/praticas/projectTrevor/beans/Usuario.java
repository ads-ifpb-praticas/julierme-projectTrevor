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
public class Usuario implements Serializable{
    
    private String id;
    private String senha;
    private String email;
    
    public Usuario(){ }
    
    public Usuario(String id, String senha, String email){
        this.id = id;
        this.senha = senha;
        this.email = email;
    }

    public String getID() {return id;}
    public void setID(String id) {this.id = id;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    
}
