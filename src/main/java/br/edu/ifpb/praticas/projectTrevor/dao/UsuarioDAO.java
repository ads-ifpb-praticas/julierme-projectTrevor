/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.dao;

import br.edu.ifpb.praticas.projectTrevor.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author JuliermeH
 */
@Stateless
public class UsuarioDAO {
    
    private final Connection conexao;
    
    public UsuarioDAO()throws ClassNotFoundException, SQLException{
        this.conexao = Conexao.getConnection();
    }

    public Connection estabelecerConexao() {return conexao;}

    public void adicionaUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (id, senha, email) VALUES (?,?,?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getID());
        statement.setString(2, usuario.getSenha());
        statement.setString(3, usuario.getEmail());
        
        statement.executeUpdate();
        statement.close();
    }

    public void removeUsuario(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE ID = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getID());
        statement.executeUpdate();
        statement.close();
    }
    
    public void atulizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET senha = ?, email = ? WHERE ID = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getID());
        statement.executeUpdate();
        statement.close();
    }

    public void atulizarEmail(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET email = ? WHERE ID = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getID());
        statement.executeUpdate();
        statement.close();
    }
    
    public void atulizarSenha(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET senha = ? WHERE ID = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getID());
        statement.executeUpdate();
        statement.close();
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        String sql = "SELECT * FROM Usuario";
        List<Usuario> usuarios = new ArrayList();
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        Usuario usuario;
        while(rs.next()){
            usuario = new Usuario();
            usuario.setID(rs.getString("id"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setEmail(rs.getString("email"));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Usuario recuperarUsuario(String ID) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE ID = ?";
        Usuario usuario = null;
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, ID);
        ResultSet rs = statement.executeQuery();

        if (rs.next()){
            usuario = new Usuario();
            usuario.setID(rs.getString("id"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setEmail(rs.getString("email"));
        }
        statement.close();
        return usuario;
    }
    
}
