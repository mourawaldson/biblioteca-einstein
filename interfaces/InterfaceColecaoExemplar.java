package interfaces;

import java.sql.SQLException;
import java.util.Vector;

import classes.Exemplar;
import classes.Livro;
import exception.ExemplarInexistenteException;

public interface InterfaceColecaoExemplar {
	public void cadastraExemplar(Exemplar novo)throws ExemplarInexistenteException;
	public void removerExemplar(Exemplar excluido)throws ExemplarInexistenteException;
	public void alterarExemplar(Exemplar alterado)throws ExemplarInexistenteException;
	
	public Vector<Exemplar> listar();
	public Vector<Exemplar> consultarLivro(Livro l);
	public Vector<Exemplar> consultarStatus(boolean status);
	
	public Exemplar consultar(int id) throws SQLException,ExemplarInexistenteException;
}
