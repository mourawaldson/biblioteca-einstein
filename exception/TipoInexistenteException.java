package exception;

public class TipoInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String nome;

	public TipoInexistenteException(String nome) {
		super("Tipo procurado não existe: " + nome);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
