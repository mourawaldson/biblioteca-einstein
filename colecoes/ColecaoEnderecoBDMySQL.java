package colecoes;

import interfaces.InterfaceColecaoEndereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uteis.Conexao;

import classes.Endereco;

public class ColecaoEnderecoBDMySQL implements InterfaceColecaoEndereco{

	public void cadastrarEndereco(Endereco novo) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("INSERT INTO enderecos (cidade,bairro,logradouro,numero,complemento,cep)" +
														  "VALUES (?, ?, ?, ?, ?, ?)");
			pst.setString(1, novo.getCidade());
			pst.setString(2, novo.getBairro());
			pst.setString(3, novo.getLogradouro());
			pst.setString(4, novo.getNumero());
			pst.setString(5, novo.getComplemento());
			pst.setString(6, novo.getCep());
			pst.executeUpdate();
			pst.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void removerEndereco(Endereco excluido) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM enderecos WHERE id = ?");
			pst.setInt(1, excluido.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void alterarEndereco(Endereco alterado) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("UPDATE SET enderecos cidade = ?,bairro = ?,logradouro = ?,numero = ?,complemento = ?,cep = ?)" +
														  "WHERE id=?");
			pst.setString(1, alterado.getCidade());
			pst.setString(2, alterado.getBairro());
			pst.setString(3, alterado.getLogradouro());
			pst.setString(4, alterado.getNumero());
			pst.setString(5, alterado.getComplemento());
			pst.setString(6, alterado.getCep());
			pst.setInt(7, alterado.getId());
			pst.executeUpdate();			
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Endereco consultar(int id) {
		Connection conn = Conexao.getConnection();
		Endereco resposta = null;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM enderecos WHERE id = ?");
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				resposta = new Endereco(res.getInt("id"),res.getString("numero"),res.getString("logradouro"),res.getString("bairro"),res.getString("cidade"),res.getString("cep"),res.getString("complemento"));
			}
			pst.close();
			return resposta;

		} catch (SQLException e) {
			e.printStackTrace();
			 resposta = null;
			return resposta;
		}
	}
	


	public void carregarClasse(Endereco end) {
		int codigo;
		Connection conn = Conexao.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT MAX(Id) FROM enderecos");
			ResultSet resposta = pst.executeQuery();
				if(resposta.next()) {
					codigo = resposta.getInt(1);
					end.setId(codigo);
					pst.close();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
