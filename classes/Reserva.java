package classes;

public class Reserva {
	private int id;
	private Usuario usuario;
	private Livro livro;
	
	public Reserva(int id, Usuario usuario, Livro livro) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.livro = livro;
	}
	public Reserva() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
