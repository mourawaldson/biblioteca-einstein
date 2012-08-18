package controles;

import java.util.Vector;

import classes.Emprestado;
import interfaces.InterfaceColecaoEmprestado;
import colecoes.ColecaoEmprestadoBDMySQL;

public class CadastroEmprestado {
	private InterfaceColecaoEmprestado emprestado;

	public CadastroEmprestado(){
		this.emprestado = new ColecaoEmprestadoBDMySQL();
	}
	public Vector<Emprestado> listarEmprestado(){
		return emprestado.listar();
		
	}
	public Emprestado consultarEmprestado(int id){
		return emprestado.consultar(id);
	}

	public Vector<Emprestado> consultarEmprestimo(int id_emprestimo){
		return emprestado.consultarEmprestimo(id_emprestimo);
	}
	
	public void alterarEmprestado(Emprestado alterado){
		this.emprestado.alterarEmprestado(alterado);
	}

}
