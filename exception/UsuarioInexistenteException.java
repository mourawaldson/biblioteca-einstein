package exception;

public class UsuarioInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String nome;

	public UsuarioInexistenteException(String nome) {
		super("Usuario não existe");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
