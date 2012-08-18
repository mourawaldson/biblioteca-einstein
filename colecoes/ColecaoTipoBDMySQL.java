package colecoes;
import uteis.Conexao;
import classes.Tipo;
import interfaces.InterfaceColecaoTipo;

import java.util.Vector;
import java.sql.*;

import exception.TipoInexistenteException;
import exception.TipoJaExisteException;


public class ColecaoTipoBDMySQL implements InterfaceColecaoTipo {

	public void cadastrarTipoSobTipo(Tipo novo) throws TipoJaExisteException {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("INSERT INTO tipos (titulo,id_tipo)" +
														  "VALUES (?, ?)");
			pst.setString(1, novo.getTitulo());
			pst.setInt(2, novo.getSubtipo().getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void cadastrarTipoCategoria(Tipo novo) throws TipoJaExisteException {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("INSERT INTO tipos (titulo)" +
														  "VALUES (?)");
			pst.setString(1, novo.getTitulo());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void removerTipo(Tipo excluido) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM tipos WHERE id = ?");
			pst.setInt(1, excluido.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarTipo(Tipo alterado) throws TipoInexistenteException {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("UPDATE tipos SET titulo = ? , id_titulo = ? where id = ? ");
			pst.setString(1, alterado.getTitulo());
			pst.setInt(2, alterado.getSubtipo().getId());
			pst.setInt(3, alterado.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Tipo> listar() {
		Vector<Tipo> resposta = new Vector<Tipo>();
		ColecaoTipoBDMySQL tipos = new ColecaoTipoBDMySQL();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(" SELECT * FROM tipos ");
			ResultSet res = pst.executeQuery();
				while(res.next()) {
					Tipo tipo = tipos.consultar(res.getInt("id_tipo"));	
					Tipo temp = new Tipo(res.getInt("id"),res.getString("titulo"),tipo);
					resposta.addElement(temp);
				}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Tipo consultar(int id) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		Tipo resposta = null ;
		try {
			pst = conn.prepareStatement("SELECT * FROM tipos WHERE id = ?");
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
				while(res.next()) {
					resposta = new Tipo(res.getInt("id"),res.getString("titulo"),null);
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
