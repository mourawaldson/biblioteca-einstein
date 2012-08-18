package interfaces;

import java.sql.SQLException;
import java.util.Vector;

import classes.Tipo;
import exception.TipoInexistenteException;
import exception.TipoJaExisteException;

public interface InterfaceColecaoTipo {
	public void cadastrarTipoSobTipo(Tipo novo) throws TipoJaExisteException;
	public void cadastrarTipoCategoria(Tipo novo) throws TipoJaExisteException;
	public void removerTipo(Tipo excluido) throws TipoInexistenteException;
	public void alterarTipo(Tipo alterado) throws TipoInexistenteException;
	
	public Vector<Tipo> listar();
	
	public Tipo consultar(int id) throws SQLException;	
}
