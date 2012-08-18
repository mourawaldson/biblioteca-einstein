package interfaces;

import classes.Usuario;
import exception.UsuarioJaExisteException;
import exception.UsuarioInexistenteException;

import java.sql.SQLException;
import java.util.Vector;

public interface InterfaceColecaoUsuario {
	public void cadastrarUsuario(Usuario novo) throws UsuarioJaExisteException;
	public void removerUsuario(Usuario excluido) throws UsuarioInexistenteException;
	public void alterarUsuario(Usuario alterado) throws UsuarioInexistenteException;
	
	public Vector<Usuario> listar();
	public Vector<Usuario> consultarNome(String nome);
	
	public Usuario consultar(int id) throws SQLException;
}
