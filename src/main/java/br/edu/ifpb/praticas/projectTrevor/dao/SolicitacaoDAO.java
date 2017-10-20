/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projectTrevor.dao;

import br.edu.ifpb.praticas.projectTrevor.beans.Arquivo;
import br.edu.ifpb.praticas.projectTrevor.beans.Solicitacao;
import br.edu.ifpb.praticas.projectTrevor.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JuliermeH
 */
public class SolicitacaoDAO {
    
    private UsuarioDAO dao;
    private ArquivoDAO arqdao;
    private final Connection conexao;
    
    public SolicitacaoDAO() throws ClassNotFoundException, SQLException{
        this.conexao = Conexao.getConnection();
    }

    public Connection estabelecerConexao() {return conexao;}
    
    public void novaSolicitacao(Solicitacao sol) throws SQLException {
        String sql = "INSERT INTO Solicitacao (remetente, destinatario, tipo) VALUES (?,?,?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, sol.getRemetente().getID());
        statement.setString(2, sol.getDestinatario().getID());
        statement.setInt(3, sol.getArquivo().getCodigo());
        statement.executeUpdate();
        statement.close();
    }

    public void remove(Solicitacao sol) throws SQLException {
        String sql = "DELETE FROM Solicitacao WHERE codigo = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, sol.getCodSolicitacao());
        statement.executeUpdate();
        statement.close();
    }

    public void update(Solicitacao sol) throws SQLException {
        String sql = "UPDATE Solicitacao SET tipo = ? WHERE codigo = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, sol.getCodSolicitacao());
        statement.executeUpdate();
        statement.close();
    }

    public List<Solicitacao> list() throws SQLException {
        String sql = "SELECT * FROM Mensagem";
        List<Solicitacao> solicitacoes = null;
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            Solicitacao sol = new Solicitacao();
            Usuario remetente = dao.recuperarUsuario(rs.getString("remetente"));
            Usuario destinatario = dao.recuperarUsuario(rs.getString("destinatario"));
            sol.setRemetente(remetente);
            sol.setDestinatario(destinatario);
            Integer identificador = rs.getInt("arquivo");
            Arquivo arquivo = arqdao.recuperar(identificador.toString());
            sol.setArquivo(arquivo);
            sol.setCodSolicitacao(rs.getInt("codigo"));
            solicitacoes.add(sol);
        }
        statement.close();
        return solicitacoes;
    }

    public Solicitacao recuperar(String cod) throws SQLException {
        String sql = "SELECT * FROM Solicitacao WHERE remetente = ?";
        Solicitacao sol = null;
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, cod);
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            Solicitacao solicitacao = new Solicitacao();
            Usuario remetente = dao.recuperarUsuario(rs.getString("remetente"));
            Usuario destinatario = dao.recuperarUsuario(rs.getString("destinatario"));
            solicitacao.setRemetente(remetente);
            solicitacao.setDestinatario(destinatario);
            Integer identificador = rs.getInt("arquivo");
            Arquivo arquivo = arqdao.recuperar(identificador.toString());
            solicitacao.setArquivo(arquivo);
            solicitacao.setCodSolicitacao(rs.getInt("codigo"));
        }
        statement.close();
        return sol;
    }
    
}
