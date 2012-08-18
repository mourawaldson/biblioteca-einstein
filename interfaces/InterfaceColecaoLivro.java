package interfaces;

import java.sql.SQLException;
import java.util.Vector;

import classes.Livro;
import classes.Tipo;
import exception.LivroInexistenteException;
import exception.LivroJaExisteException;

public interface InterfaceColecaoLivro {
	public void cadastrarLivro(Livro novo) throws LivroJaExisteException;
	public void removerLivro(Livro excluido) throws LivroInexistenteException;
	public void alterarLivro(Livro alterado) throws LivroInexistenteException;
	
	public Vector<Livro> listar();
    public Vector<Livro> consultarTipo(Tipo t);
    public Vector<Livro> consultarTitulo(String titulo);
    public Vector<Livro> consultarAutor(String autor);
    public Vector<Livro> consultarEditora(String editora);
    public Vector<Livro> consultarEdicao(short edicao);
    
    public Livro consultar(int id) throws SQLException;
}
