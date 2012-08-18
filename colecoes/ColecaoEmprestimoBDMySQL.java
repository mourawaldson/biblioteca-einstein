package colecoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.Iterator;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import uteis.Conexao;

import classes.Emprestado;
import classes.Emprestimo;

import classes.Usuario;
import interfaces.InterfaceColecaoEmprestimo;

public class ColecaoEmprestimoBDMySQL implements InterfaceColecaoEmprestimo{

	public void cadastrarEmprestimo(Emprestimo novo) {
		Connection conn = Conexao.getConnection();
		ColecaoExemplarBDMySQL cexemplar = new ColecaoExemplarBDMySQL();
		int id_emprestimo = 0;
		PreparedStatement pst;
		try {
			String sql = "INSERT INTO emprestimos (id_usuario,data_emprestimo,data_prevista,multa,status)" +
			"VALUES ("+novo.getUsuario().getId()+",'"+novo.getData_emprestimo()+"', '"+novo.getData_prevista()+"',"+novo.getMulta()+",false)";

			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
	
			if (rs.next()) {
				do {
					for (int i=1; i<=columnCount; i++) {
						id_emprestimo = rs.getInt(i);
					}
				} while(rs.next());
			}
			novo.setId(id_emprestimo);
		
			pst = conn.prepareStatement("INSERT INTO emprestados(id_exemplar,id_emprestimo,data_devolucao,status)" +
														   "VALUES(?,?,?,?)");

			Iterator inte;
			inte = novo.getEmprestados().iterator(); // inicializa interador	
				while(inte.hasNext()){
					Emprestado atualEmprestado = (Emprestado)inte.next();
					pst.setInt(1,atualEmprestado.getExemplar().getId());
					pst.setInt(2,novo.getId());
					pst.setString(3, atualEmprestado.getData_devolucao());
					pst.setBoolean(4, atualEmprestado.isStatus());
					pst.executeUpdate();
					atualEmprestado.getExemplar().setStatus(true);
					cexemplar.alterarExemplar(atualEmprestado.getExemplar());
				}

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void removerEmprestimo(Emprestimo excluido) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM emprestimos WHERE id = ?");
			pst.setInt(1, excluido.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void alterarEmprestimo(Emprestimo alterado) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("UPDATE emprestimos SET id_usuario = ? , data_emprestimo = ? , data_prevista = ? , multa = ? , status = ? " +
														  " WHERE id = ?");
			pst.setInt(1, alterado.getUsuario().getId());
			pst.setString(2, alterado.getData_emprestimo());
			pst.setString(3, alterado.getData_prevista());
			pst.setFloat(4, alterado.getMulta());
			pst.setBoolean(5, alterado.isStatus());
			pst.setInt(6, alterado.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Vector<Emprestimo> consultarStatus(boolean status) {
		Vector<Emprestimo> resposta = new Vector<Emprestimo>();
		ColecaoUsuarioBDMySQL usuarios = new ColecaoUsuarioBDMySQL();
		ColecaoEmprestadoBDMySQL emprestados = new ColecaoEmprestadoBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestimos WHERE status = ?");
			pst.setBoolean(1, status);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Usuario usuario = usuarios.consultar(res.getInt("id_usuario"));
				Vector<Emprestado> emprestado= emprestados.consultarEmprestimo(res.getInt("id"));
				Emprestimo temp = new Emprestimo(res.getInt("id"),emprestado,usuario,res.getString("data_emprestimo"),res.getString("data_prevista"),res.getFloat("multa"),res.getBoolean("status"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Emprestimo> consultarUsuario(Usuario usuario) {
		Vector<Emprestimo> resposta = new Vector<Emprestimo>();
		ColecaoUsuarioBDMySQL usuarios = new ColecaoUsuarioBDMySQL();
		ColecaoEmprestadoBDMySQL emprestados = new ColecaoEmprestadoBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestimos WHERE id_usuario = ?");
			pst.setInt(1, usuario.getId());
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				usuario = usuarios.consultar(res.getInt("id_usuario"));
				Vector<Emprestado> emprestado= emprestados.consultarEmprestimo(res.getInt("id"));
				Emprestimo temp = new Emprestimo(res.getInt("id"),emprestado,usuario,res.getString("data_emprestimo"),res.getString("data_prevista"),res.getFloat("multa"),res.getBoolean("status"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Emprestimo> listar() {
		Vector<Emprestimo> resposta = new Vector<Emprestimo>();
		ColecaoUsuarioBDMySQL usuarios = new ColecaoUsuarioBDMySQL();
		ColecaoEmprestadoBDMySQL emprestados = new ColecaoEmprestadoBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestimos");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Usuario usuario = usuarios.consultar(res.getInt("id_usuario"));
				Vector<Emprestado> emprestado= emprestados.consultarEmprestimo(res.getInt("id"));
				Emprestimo temp = new Emprestimo(res.getInt("id"),emprestado,usuario,res.getString("data_emprestimo"),res.getString("data_prevista"),res.getFloat("multa"),res.getBoolean("status"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Emprestimo consultar(int id) {
		ColecaoUsuarioBDMySQL usuarios = new ColecaoUsuarioBDMySQL();
		ColecaoEmprestadoBDMySQL emprestados = new ColecaoEmprestadoBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM emprestimos WHERE ID = ?");
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			Emprestimo resposta = null;
			while(res.next()){
				Usuario usuario = usuarios.consultar(res.getInt("id_usuario"));
				Vector<Emprestado> emprestado= emprestados.consultarEmprestimo(res.getInt("id"));
				resposta = new Emprestimo(res.getInt("id"),emprestado,usuario,res.getString("data_emprestimo"),res.getString("data_prevista"),res.getFloat("multa"),res.getBoolean("status"));
			}
			pst.close();
			return resposta;
		} catch (SQLException e) {
			e.printStackTrace();
			Emprestimo resposta = null;
			return resposta;
		}
	}

	public boolean emprestadosDevolvidos(int id) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		boolean resposta = false;
		try {
			pst = conn.prepareStatement("SELECT if((SELECT SUM(status) FROM emprestados where id_emprestimo = ?) = (SELECT COUNT(id) FROM emprestados where id_emprestimo = ? GROUP BY id_emprestimo),1,0) as resultado;");
			pst.setInt(1, id);
			pst.setInt(2, id);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				resposta = res.getBoolean("resultado");
			}
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}