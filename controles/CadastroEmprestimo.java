package controles;

import interfaces.InterfaceColecaoEmprestimo;

import java.util.Vector;

import classes.Emprestimo;
import colecoes.ColecaoEmprestimoBDMySQL;

public class CadastroEmprestimo {
	private InterfaceColecaoEmprestimo emprestimo;

	public CadastroEmprestimo(){
		this.emprestimo = new ColecaoEmprestimoBDMySQL();
	}
	public void cadastrarEmprestimo(Emprestimo novo){
		 emprestimo.cadastrarEmprestimo(novo);
	}
	public Vector<Emprestimo> listarEmprestimo(){
		return emprestimo.listar();	
	}
	
	public void alterarEmprestimo(Emprestimo alterado){
		this.emprestimo.alterarEmprestimo(alterado);
	}
	
	public Emprestimo consultarEmprestimo(int id){
		return emprestimo.consultar(id);
	}
	public Vector<Emprestimo> consultarEmprestimoStatus(boolean status){
		return emprestimo.consultarStatus(status);
	}
	
	public boolean emprestadosDevolvidos(int id){
		return emprestimo.emprestadosDevolvidos(id);
	}
}
