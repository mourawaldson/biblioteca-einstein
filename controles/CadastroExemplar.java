package controles;

import java.sql.SQLException;
import java.util.Vector;

import classes.Exemplar;
import classes.Livro;
import colecoes.ColecaoExemplarBDMySQL;
import exception.ExemplarInexistenteException;
import interfaces.InterfaceColecaoExemplar;


public class CadastroExemplar {
	private InterfaceColecaoExemplar exemplar;

	public CadastroExemplar(){
		this.exemplar = new ColecaoExemplarBDMySQL();
	}

	public void cadastrarExemplar(Exemplar novo) throws ExemplarInexistenteException{
		exemplar.cadastraExemplar(novo);
	}

	public void removerExemplar(Exemplar excluido) throws ExemplarInexistenteException{
		exemplar.removerExemplar(excluido);
	}

	public void alterarExemplar(Exemplar alterado) throws ExemplarInexistenteException{
		exemplar.alterarExemplar(alterado);
	}
	
	public Vector<Exemplar> listar(){
		return exemplar.listar();
	}
	
	public Vector<Exemplar> consultarLivro(Livro l){
		return exemplar.consultarLivro(l);
	}
	
	public Vector<Exemplar> consultarStatus(boolean status){
		return exemplar.consultarStatus(status);
	}
	
	public Exemplar consultar(int id) throws SQLException, ExemplarInexistenteException{
		return exemplar.consultar(id);
	}
}
