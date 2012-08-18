package colecoes;

import interfaces.InterfaceColecaoLivro;

import java.util.Vector;
import java.sql.*;

import uteis.Conexao;
import classes.Livro;
import classes.Tipo;
import exception.LivroInexistenteException;

public class ColecaoLivroBDMySQL implements InterfaceColecaoLivro {

	public void cadastrarLivro(Livro novo) {
		Connection conn = Conexao.getConnection();
		try {
			PreparedStatement p = conn.prepareStatement("INSERT INTO LIVROS(id_tipo,titulo,autor,editora,edicao,ISBN,idioma,ano,sinopse) VALUES (?,?,?,?,?,?,?,?,?)");
			p.setInt(1, novo.getTipo().getId());
			p.setString(2,novo.getTitulo());
			p.setString(3,novo.getAutor());
			p.setString(4,novo.getEditora());
			p.setShort(5,novo.getEdicao());
			p.setString(6,novo.getIsbn());
			p.setString(7,novo.getIdioma());
			p.setInt(8,novo.getAno());
			p.setString(9,novo.getSinopse());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerLivro(Livro excluido) throws LivroInexistenteException {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM livros WHERE id = ?");
			pst.setInt(1, excluido.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarLivro(Livro alterado) throws LivroInexistenteException {
		Connection conn = Conexao.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE SET livros(id_tipo = ?,titulo = ?,autor = ?,editora = ?,edicao = ?,ISBN = ?,idioma = ?,ano = ?,sinopse = ?) WHERE id = ?");
			pst.setInt(1,alterado.getTipo().getId());
			pst.setString(2,alterado.getTitulo());
			pst.setString(3,alterado.getAutor());
			pst.setString(4,alterado.getEditora());
			pst.setShort(5,alterado.getEdicao());
			pst.setString(6,alterado.getIsbn());
			pst.setString(7,alterado.getIdioma());
			pst.setInt(8,alterado.getAno());
			pst.setString(9,alterado.getSinopse());
			pst.setInt(10, alterado.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Livro> consultarAutor(String autor) {
		ColecaoTipoBDMySQL tipos = new ColecaoTipoBDMySQL(); 
		Vector<Livro> resposta = new Vector<Livro>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM livros WHERE autor LIKE ? ");
			pst.setString(1,"%"+autor+"%");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Tipo tipo = tipos.consultar(res.getInt("id_tipo"));
				Livro temp = new Livro(res.getInt("id"), tipo, res.getString("titulo"), res.getString("autor"), res.getString("editora"),res.getShort("edicao"), res.getString("ISBN"), res.getString("idioma"), res.getInt("ano"), res.getString("sinopse"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Livro> consultarEdicao(short edicao) {
		ColecaoTipoBDMySQL tipos = new ColecaoTipoBDMySQL(); 
		Vector<Livro> resposta = new Vector<Livro>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM livros WHERE edicao = ? ");
			pst.setInt(1,edicao);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Tipo tipo = tipos.consultar(res.getInt("id_tipo"));
				Livro temp = new Livro(res.getInt("id"), tipo, res.getString("titulo"), res.getString("autor"), res.getString("editora"),res.getShort("edicao"), res.getString("ISBN"), res.getString("idioma"), res.getInt("ano"), res.getString("sinopse"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Livro> consultarEditora(String editora) {
		ColecaoTipoBDMySQL livros = new ColecaoTipoBDMySQL(); 
		Vector<Livro> resposta = new Vector<Livro>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM livros WHERE editora LIKE ? ");
			pst.setString(1,"%"+editora+"%");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Tipo tipo = livros.consultar(res.getInt("id_tipo"));
				Livro temp = new Livro(res.getInt("id"), tipo, res.getString("titulo"), res.getString("autor"), res.getString("editora"),res.getShort("edicao"), res.getString("ISBN"), res.getString("idioma"), res.getInt("ano"), res.getString("sinopse"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Livro> consultarTipo(Tipo t) {
		ColecaoTipoBDMySQL livros = new ColecaoTipoBDMySQL(); 
		Vector<Livro> resposta = new Vector<Livro>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM livros WHERE id_tipo = ? ");
			pst.setInt(1,t.getId());
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Tipo tipo = livros.consultar(res.getInt("id_tipo"));
				Livro temp = new Livro(res.getInt("id"), tipo, res.getString("titulo"), res.getString("autor"), res.getString("editora"),res.getShort("edicao"), res.getString("ISBN"), res.getString("idioma"), res.getInt("ano"), res.getString("sinopse"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Vector<Livro> consultarTitulo(String titulo) {
		ColecaoTipoBDMySQL livros = new ColecaoTipoBDMySQL(); 
		Vector<Livro> resposta = new Vector<Livro>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM livros WHERE titulo LIKE ? ");
			pst.setString(1,"%"+titulo+"%");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Tipo tipo = livros.consultar(res.getInt("id_tipo"));
				Livro temp = new Livro(res.getInt("id"), tipo, res.getString("titulo"), res.getString("autor"), res.getString("editora"),res.getShort("edicao"), res.getString("ISBN"), res.getString("idioma"), res.getInt("ano"), res.getString("sinopse"));
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
	
	public Vector<Livro> listar() {
		ColecaoTipoBDMySQL tipos = new ColecaoTipoBDMySQL();
		Vector<Livro> resposta = new Vector<Livro>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM livros");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Tipo tipo = tipos.consultar(res.getInt("id_tipo"));
				Livro temp2 = new Livro(res.getInt("id"),tipo,res.getString("titulo"), res.getString("autor"), res.getString("editora"),res.getShort("edicao"), res.getString("ISBN"), res.getString("idioma"), res.getInt("ano"), res.getString("sinopse"));
			    resposta.addElement(temp2);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
	
	public Livro consultar(int id) {
		ColecaoTipoBDMySQL tipos = new ColecaoTipoBDMySQL(); 
		Connection conn = Conexao.getConnection();
		Livro resposta = null ;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM livros WHERE id = ? ");
			pst.setInt(1,id);
			ResultSet res = pst.executeQuery();
				while(res.next()) {
					Tipo tipo = tipos.consultar(res.getInt("id_tipo"));
					resposta = new Livro(res.getInt("id"), tipo, res.getString("titulo"), res.getString("autor"), res.getString("editora"),res.getShort("edicao"), res.getString("ISBN"), res.getString("idioma"), res.getInt("ano"), res.getString("sinopse"));
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
