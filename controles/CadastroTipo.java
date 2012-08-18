package controles;

import classes.Tipo;
import interfaces.InterfaceColecaoTipo;

import java.sql.SQLException;
import java.util.Vector;
import colecoes.ColecaoTipoBDMySQL;
import exception.TipoInexistenteException;
import exception.TipoJaExisteException;

public class CadastroTipo {
	private InterfaceColecaoTipo tipos;

	public CadastroTipo() {
		this.tipos = new ColecaoTipoBDMySQL();
	}

	public void cadastrarTipoSobTipo(Tipo novo) throws TipoJaExisteException {
		tipos.cadastrarTipoSobTipo(novo);
	}
	public void cadastrarTipoCategoria(Tipo novo) throws TipoJaExisteException {
		tipos.cadastrarTipoCategoria(novo);
	}
	
	public void removerTipo(Tipo excluido) throws TipoInexistenteException {
		tipos.removerTipo(excluido);
	}
	
	public void alterarTipo(Tipo alterado) throws TipoInexistenteException {
		tipos.alterarTipo(alterado);
	}
	
	public Vector<Tipo> listar(){
		return tipos.listar();
	}
	
	public Tipo consultar(int id) throws SQLException{
		return tipos.consultar(id);
	}

}
