package interfaces;

import java.util.Vector;

import classes.Emprestado;
import classes.Exemplar;

public interface InterfaceColecaoEmprestado {
	public void removerEmprestado(Emprestado excluido);
	public void alterarEmprestado(Emprestado alterado);

	public Vector<Emprestado> listar();
	public Vector<Emprestado> consultarEmprestimo(int id_emprestimo);
	public Vector<Emprestado> consultarExemplar(Exemplar e);
	public Vector<Emprestado> consultarStatus(boolean status);

	public Emprestado consultar(int id);

}
