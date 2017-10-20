/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.dao;

import br.edu.ifpb.praticas.projectTrevor.beans.Arquivo;
import br.edu.ifpb.praticas.projectTrevor.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuliermeH
 */
public class ArquivoDAO {
    
    private final Connection conexao;
    
    public ArquivoDAO()throws ClassNotFoundException, SQLException{
        this.conexao = Conexao.getConnection();
    }

    public Connection estabelecerConexao() {return conexao;}
    
    public void adicionaArquivo(Arquivo arq)throws SQLException {
        String sql = "INSERT INTO Arquivo (nome, tipo, arquivo, usuario) VALUES (?,?,?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, arq.getNome());
        statement.setString(2, arq.getTipo());
        statement.setString(3, arq.getArquivo());
        statement.setDouble(4, arq.getTamanho());
        statement.setString(5, arq.getUsuario().getID());
        statement.executeUpdate();
        statement.close();
    }

    public void excluiArquivo(Arquivo arq)throws SQLException {
        String sql = "DELETE FROM Arquivo WHERE codigo = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, arq.getCodigo());
        statement.executeUpdate();
        statement.close();
    }

    public void atualizarArquivo(Arquivo arq)throws SQLException {
        String sql = "UPDATE Arquivo SET nome = ?, tipo = ?, tamanho = ?, arquivo = ?, usuario = ? WHERE codigo = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, arq.getNome());
        statement.setString(2, arq.getTipo());
        statement.setDouble(3, arq.getTamanho());
        statement.setString(4, arq.getArquivo());
        statement.setString(5, arq.getUsuario().getID());
        statement.setInt(6, arq.getCodigo());
        statement.executeUpdate();
        statement.close();
    }

    public List<Arquivo> arquivos()throws SQLException {
        String sql = "SELECT * FROM Arquivo";
        List<Arquivo> arquivos = new ArrayList();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        Arquivo arq;
        while(rs.next()){
            arq = new Arquivo();
            arq.setNome(rs.getString("nome"));
            arq.setTipo(rs.getString("tipo"));
            arq.setArquivo(rs.getString("arquivo"));
            arq.setTamanho(rs.getDouble("tamanho"));
            arq.setCodigo(rs.getInt("codigo"));
            Usuario usuario = new Usuario();
            arq.setUsuario(usuario);
            arq.setArquivo(rs.getString("arquivo"));
            arquivos.add(arq);
        }
        return arquivos;
    }

    public Arquivo recuperar(String cod)throws SQLException {
        String sql = "SELECT * FROM Arquivo WHERE codigo = ?";
        Arquivo arq = null;
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, cod);
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            arq = new Arquivo();
            arq.setNome(rs.getString("nome"));
            arq.setTipo(rs.getString("tipo"));
            arq.setArquivo(rs.getString("arquivo"));
            arq.setTamanho(rs.getDouble("tamanho"));
            arq.setCodigo(rs.getInt("id"));
            Usuario usuario = new Usuario();
            arq.setUsuario(usuario);
            arq.setArquivo(rs.getString("arquivo"));
        }
        statement.close();
        return arq;

    }
    
}
