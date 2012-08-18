package classes;

public class Tipo {
	private int id;
	private String titulo;
	private Tipo subtipo;
	
	public Tipo(int id,String titulo,Tipo subtipo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.subtipo = subtipo;
	}
	public Tipo(int id,String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
		
	}
	public Tipo(String titulo) {
		super();
		this.titulo = titulo;
		
		
	}
	public Tipo() {
		super();
	}
	public Tipo(String titulo,Tipo subtipo) {
		this.titulo = titulo;
		this.subtipo = subtipo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tipo getSubtipo() {
		return subtipo;
	}
	public void setSubtipo(Tipo subtipo) {
		this.subtipo = subtipo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String toString() {
	
		return this.titulo + ((subtipo==null)?"":" - " + this.subtipo.toString());
	}
}
