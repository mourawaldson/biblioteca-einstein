package exception;

public class UsuarioJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String nome;

	public UsuarioJaExisteException(String nome) {
		super("Usuario já existe");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
