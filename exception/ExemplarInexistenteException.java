package exception;

public class ExemplarInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String nome;

	public ExemplarInexistenteException(String nome) {
		super("Exemplar procurado não existe: " + nome);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
