package controles;

import classes.Usuario;
import interfaces.InterfaceColecaoUsuario;

import java.sql.SQLException;
import java.util.Vector;
import colecoes.ColecaoUsuarioBDMySQL;
import exception.UsuarioJaExisteException;
import exception.UsuarioInexistenteException;


public class CadastroUsuario {
	private InterfaceColecaoUsuario usuarios;

	public CadastroUsuario() {
		this.usuarios = new ColecaoUsuarioBDMySQL();
	}

	public void cadastrarUsuario(Usuario novo) throws UsuarioJaExisteException {
		usuarios.cadastrarUsuario(novo);
	}

	public void removerUsuario(Usuario excluido) throws UsuarioInexistenteException {
		usuarios.removerUsuario(excluido);
	}

	public void alterarUsuario(Usuario alterado) throws UsuarioInexistenteException {
		usuarios.alterarUsuario(alterado);
	}

	public Vector<Usuario> listar() {
		return usuarios.listar();
	}
	
	public Vector<Usuario> consultarNome(String nome) {
		return usuarios.consultarNome(nome);
	}
	
	public Usuario consultar(int id) throws SQLException{
		return usuarios.consultar(id);
	}

}
