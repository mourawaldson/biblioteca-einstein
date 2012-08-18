package colecoes;
import uteis.Conexao;
import classes.Endereco;
import classes.Usuario;
import interfaces.InterfaceColecaoUsuario;

import java.util.Vector;
import java.sql.*;

import exception.UsuarioJaExisteException;
import exception.UsuarioInexistenteException;


public class ColecaoUsuarioBDMySQL implements InterfaceColecaoUsuario {

	public void cadastrarUsuario(Usuario novo) throws UsuarioJaExisteException {
		int sexo = 0;
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("INSERT INTO usuarios (nome,rg,cpf,telefone,celular,email,sexo,id_endereco)" +
														  "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	
			if(novo.getSexo().equals("Masculino")){
				sexo = 1;
			}else{
				sexo = 0;
			}
			pst.setString(1, novo.getNome());
			pst.setString(2, novo.getRg());
			pst.setString(3, novo.getCpf());
			pst.setString(4, novo.getTelefone());
			pst.setString(5, novo.getCelular());
			pst.setString(6, novo.getEmail());
			pst.setInt(7, sexo);
			pst.setInt(8, novo.getEndereco().getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerUsuario(Usuario excluido) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
			pst.setInt(1, excluido.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarUsuario(Usuario alterado) throws UsuarioInexistenteException{
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("UPDATE usuarios SET nome = ? , rg = ? , cpf = ? , telefone = ? , celular = ? , email = ? , sexo = ? where id = ? ");
			pst.setString(1, alterado.getNome());
			pst.setString(2, alterado.getRg());
			pst.setString(3, alterado.getCpf());
			pst.setString(4, alterado.getTelefone());
			pst.setString(5, alterado.getCelular());
			pst.setString(6, alterado.getEmail());
			pst.setString(7, alterado.getSexo());
			pst.setInt(8, alterado.getId());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Usuario> listar() {
		Vector<Usuario> resposta = new Vector<Usuario>();
		ColecaoEnderecoBDMySQL enderecos = new ColecaoEnderecoBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		String sexo = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM usuarios");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Endereco endereco = enderecos.consultar(res.getInt("id_endereco"));
				if(res.getBoolean("sexo")){
					sexo = "Masculino";
				}else{
					sexo = "Feminino";
				}
				Usuario temp = new Usuario(res.getInt("id"),res.getString("nome"),res.getString("rg"),res.getString("cpf"),res.getString("telefone"),res.getString("celular"),res.getString("email"),sexo, endereco);
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
	public Vector<Usuario> consultarNome(String nome) {
		ColecaoEnderecoBDMySQL enderecos = new ColecaoEnderecoBDMySQL(); 
		Vector<Usuario> resposta = new Vector<Usuario>();
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT * FROM usuarios WHERE nome LIKE ? ");
			pst.setString(1,"%"+nome+"%");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Endereco endereco = enderecos.consultar(res.getInt("id_endereco"));
				Usuario temp = new Usuario(res.getInt("id"),res.getString("nome"),res.getString("rg"),res.getString("cpf"),res.getString("telefone"),res.getString("celular"),res.getString("email"),res.getString("sexo"),endereco);
				resposta.addElement(temp);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}

	public Usuario consultar(int id) {
		ColecaoEnderecoBDMySQL enderecos = new ColecaoEnderecoBDMySQL(); 
		Connection conn = Conexao.getConnection();
		PreparedStatement pst;
		Usuario resposta = null;
		String sexo = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
			pst.setInt(1,id);
			ResultSet res = pst.executeQuery();
			while(res.next()){
				Endereco endereco = enderecos.consultar(res.getInt("id_endereco"));
				if(res.getBoolean("sexo")){
					sexo = "Masculino";
				}else{
					sexo = "Feminino";
				}
				resposta = new Usuario(res.getInt("id"),res.getString("nome"),res.getString("rg"),res.getString("cpf"),res.getString("telefone"),res.getString("celular"),res.getString("email"),sexo, endereco);
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
