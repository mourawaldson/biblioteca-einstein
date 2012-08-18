package controles;

import classes.Livro;
import classes.Tipo;
import interfaces.InterfaceColecaoLivro;

import java.sql.SQLException;
import java.util.Vector;

import colecoes.ColecaoLivroBDMySQL;
import exception.LivroInexistenteException;
import exception.LivroJaExisteException;

public class CadastroLivro {
	private InterfaceColecaoLivro livros;

	public CadastroLivro() {
		this.livros = new ColecaoLivroBDMySQL();
	}

	public void cadastrarLivro(Livro novo) throws LivroJaExisteException{
		livros.cadastrarLivro(novo);	
	}

	public void removerLivro(Livro excluido) throws LivroInexistenteException{
		livros.removerLivro(excluido);
	}

	public void alterarLivro(Livro alterado) throws LivroInexistenteException{
		livros.alterarLivro(alterado);
	}

	public Vector<Livro> listar(){
		return livros.listar();
	}

	public Vector<Livro> consultarTipo(Tipo t){
		return livros.consultarTipo(t);
	}

	public Vector<Livro> consultarTitulo(String titulo){
		return livros.consultarTitulo(titulo);
	}

	public Vector<Livro> consultarAutor(String autor){
		return livros.consultarAutor(autor);
	}

	public Vector<Livro> consultarEditora(String editora){
		return livros.consultarEditora(editora);
	}

	public Vector<Livro> consultarEdicao(short edicao){
		return livros.consultarEdicao(edicao);
	}

	public Livro consultar(int id) throws SQLException{
		return livros.consultar(id);
	}
}