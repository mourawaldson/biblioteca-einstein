package classes;

public class Exemplar {
	private int id;
	private Livro livro;
	private String obs;


	private boolean status;
	
	public Exemplar(int id,Livro livro, String obs, boolean status) {
		super();
		this.id = id;
		this.livro = livro;
		this.obs = obs;
		this.status = status;
	}
	public Exemplar() {
		super();
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
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String toString() {
	
		return super.toString();
	}
}
