package colecoes;

import interfaces.InterfaceColecaoEmprestado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import uteis.Conexao;
import classes.Emprestado;
import classes.Exemplar;
import exception.ExemplarInexistenteException;

public class ColecaoEmprestadoBDMySQL implements InterfaceColecaoEmprestado{

	public void removerEmprestado(Emprestado excluido) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM emprestados WHERE id = ?");
			pst.setInt(1, excluido.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void alterarEmprestado(Emprestado alterado) {
		ColecaoExemplarBDMySQL cexemplar = new ColecaoExemplarBDMySQL();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("UPDATE emprestados SET data_devolucao = ?, status = ? " +
										" WHERE id = ?");
			pst.setString(1, alterado.getData_devolucao());
			pst.setBoolean(2, alterado.isStatus());
			pst.setInt(3, alterado.getId());
			pst.executeUpdate();
			cexemplar.alterarExemplar(alterado.getExemplar());
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public Vector<Emprestado> listar() {
		Vector<Emprestado> resposta = new Vector<Emprestado>();
		ColecaoExemplarBDMySQL exemplares = new ColecaoExemplarBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestados");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Exemplar exemplar = exemplares.consultar(res.getInt("id_exemplar"));
				Emprestado temp = new Emprestado(res.getInt("id"),exemplar,res.getString("data_devolucao"),res.getBoolean("status"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ExemplarInexistenteException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Emprestado> consultarEmprestimo(int id_emprestimo) {
		Vector<Emprestado> resposta = new Vector<Emprestado>();
		ColecaoExemplarBDMySQL exemplares = new ColecaoExemplarBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestados WHERE id_emprestimo = ?");
			pst.setInt(1, id_emprestimo);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Exemplar exemplar;
				try {
					exemplar = exemplares.consultar(res.getInt("id_exemplar"));
					Emprestado temp = new Emprestado(res.getInt("id"),exemplar,res.getString("data_devolucao"),res.getBoolean("status"));
					resposta.addElement(temp);
				} catch (ExemplarInexistenteException e) {
					e.printStackTrace();
				}
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Emprestado> consultarStatus(boolean status) {
		Vector<Emprestado> resposta = new Vector<Emprestado>();
		ColecaoExemplarBDMySQL exemplares = new ColecaoExemplarBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestados WHERE status = ?");
			pst.setBoolean(1, status);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Exemplar exemplar;
				try {
					exemplar = exemplares.consultar(res.getInt("id_exemplar"));
					Emprestado temp = new Emprestado(res.getInt("id"),exemplar,res.getString("data_devolucao"),res.getBoolean("status"));
					resposta.addElement(temp);
				} catch (ExemplarInexistenteException e) {
					e.printStackTrace();
				}
				}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Emprestado consultar(int id) {
		ColecaoExemplarBDMySQL exemplares = new ColecaoExemplarBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestados WHERE id = ? ");
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			Exemplar exemplar;
			Emprestado resposta = null;
			try {
				while (res.next()){
					exemplar = exemplares.consultar(res.getInt("id_exemplar"));
					resposta = new Emprestado(res.getInt("id"),exemplar,res.getString("data_devolucao"),res.getBoolean("status"));
				}
				pst.close();		
				return resposta;
			} catch (ExemplarInexistenteException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Emprestado resposta = null;
			return resposta;
		}
		return null;
	}

	public Vector<Emprestado> consultarExemplar(Exemplar e) {
		Vector<Emprestado> resposta = new Vector<Emprestado>();
		ColecaoExemplarBDMySQL exemplares = new ColecaoExemplarBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestados WHERE id_exemplar = ?");
			pst.setInt(1, e.getId());
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Exemplar exemplar;
				try {
					exemplar = exemplares.consultar(res.getInt("id_exemplar"));
					Emprestado temp = new Emprestado(res.getInt("id"),exemplar,res.getString("data_devolucao"),res.getBoolean("status"));
					resposta.addElement(temp);
				} catch (ExemplarInexistenteException e1) {
					e1.printStackTrace();
				}
			}
			pst.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return resposta;
	}
}
