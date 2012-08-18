package interfaces;

import java.util.Vector;

import classes.Emprestimo;
import classes.Usuario;

public interface InterfaceColecaoEmprestimo {
	public void cadastrarEmprestimo(Emprestimo novo) ;
	
	public void removerEmprestimo(Emprestimo excluido) ;
	public void alterarEmprestimo(Emprestimo alterado) ;
	
	public Vector<Emprestimo> listar();
	public Vector<Emprestimo> consultarUsuario(Usuario usuario);
	public Vector<Emprestimo> consultarStatus(boolean status);
	
	public Emprestimo consultar(int id);
	
	public boolean emprestadosDevolvidos(int id);
}	
	