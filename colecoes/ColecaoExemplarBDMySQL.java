package colecoes;

import interfaces.InterfaceColecaoExemplar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import uteis.Conexao;

import classes.Exemplar;
import classes.Livro;
import exception.ExemplarInexistenteException;

public class ColecaoExemplarBDMySQL implements InterfaceColecaoExemplar {

	public void cadastraExemplar(Exemplar novo) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			
			pst = conn.prepareStatement("INSERT INTO exemplares (id_livro, obs, status)" +
										"VALUES (?, ?, ?)");			
			pst.setInt(1, novo.getLivro().getId());
			pst.setString(2, novo.getObs());
			pst.setBoolean(3, novo.isStatus());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerExemplar(Exemplar excluido) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM exemplares WHERE id = ?");
			pst.setInt(1, excluido.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarExemplar(Exemplar alterado) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("UPDATE exemplares SET obs = ?,status = ? " +
														  "WHERE id=?");
			pst.setString(1, alterado.getObs());
			pst.setBoolean(2, alterado.isStatus());
			pst.setInt(3, alterado.getId());
			pst.executeUpdate();			
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Vector<Exemplar> consultarLivro(Livro l) {
		ColecaoLivroBDMySQL livros = new ColecaoLivroBDMySQL(); 
		Vector<Exemplar> resposta = new Vector<Exemplar>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM exemplares WHERE id_livro = ? ");
			pst.setInt(1,l.getId());
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Livro livro = livros.consultar(res.getInt("id_livro"));
				Exemplar temp = new Exemplar(res.getInt("id"),livro,res.getString("obs"),res.getBoolean("status"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Exemplar> consultarStatus(boolean status) {
		ColecaoLivroBDMySQL livros = new ColecaoLivroBDMySQL(); 
		Vector<Exemplar> resposta = new Vector<Exemplar>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM exemplares WHERE status = ? ");
			pst.setBoolean(1,status);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Livro livro = livros.consultar(res.getInt("id_livro"));
				Exemplar temp = new Exemplar(res.getInt("id"),livro,res.getString("obs"),res.getBoolean("status"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Exemplar> listar() {
		ColecaoLivroBDMySQL livros = new ColecaoLivroBDMySQL(); 
		Vector<Exemplar> resposta = new Vector<Exemplar>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM exemplares");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Livro livro = livros.consultar(res.getInt("id_livro"));
				Exemplar temp = new Exemplar(res.getInt("id"),livro,res.getString("obs"),res.getBoolean("status"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Exemplar consultar(int id) throws SQLException, ExemplarInexistenteException {
		ColecaoLivroBDMySQL livros = new ColecaoLivroBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		Exemplar resposta = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM exemplares WHERE id = ?");
			pst.setInt(1,id);
			ResultSet res = pst.executeQuery();
				while(res.next()) {			
					Livro livro = livros.consultar(res.getInt("id_livro"));
					resposta = new Exemplar(res.getInt("id"),livro,res.getString("obs"),res.getBoolean("status"));
				}
			pst.close();
			return resposta;
		} catch (SQLException e) {
			e.printStackTrace();
		    resposta = null;
			return resposta;
		} 
	}
}
