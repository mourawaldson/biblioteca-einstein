package exception;

public class TipoJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	public String nome;

	public TipoJaExisteException(String nome) {
		super("Tipo já existe: "  + nome);
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

}
