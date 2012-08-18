package exception;

public class LivroJaExisteException extends Exception{
	private static final long serialVersionUID = 1L;
	public String nome;

	public LivroJaExisteException(String nome) {
		super("Livro já existe: "  + nome);
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}
}
