package exception;

public class LivroInexistenteException extends Exception{
	private static final long serialVersionUID = 1L;
	private String nome;

	public LivroInexistenteException(String nome) {
		super("Livro procurado não existe: " + nome);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
