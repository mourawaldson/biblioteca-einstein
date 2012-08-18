package classes;

public class Livro {
	private int id;
	private Tipo tipo;
	private String titulo,autor,editora;
	private short edicao;
	private String isbn,idioma;
	private int ano;
	private String sinopse;
	
	public Livro(Tipo tipo, String titulo, String autor, String editora,short edicao, String isbn, String idioma,int ano, String sinopse) {
		super();
		
		this.tipo = tipo;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.isbn = isbn;
		this.idioma = idioma;
		this.ano = ano;
		this.sinopse = sinopse;
	}
	public Livro(int id,String titulo, String autor, String editora,short edicao, String isbn, String idioma,int ano, String sinopse) {
		super();
		
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.isbn = isbn;
		this.idioma = idioma;
		this.ano = ano;
		this.sinopse = sinopse;
	}
	public Livro(int id, Tipo tipo, String titulo, String autor, String editora,short edicao, String isbn, String idioma,int ano, String sinopse) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.isbn = isbn;
		this.idioma = idioma;
		this.ano = ano;
		this.sinopse = sinopse;
	}
	public Livro() {
		super();
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public short getEdicao() {
		return edicao;
	}
	public void setEdicao(short edicao) {
		this.edicao = edicao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		
		return this.titulo;
	}
	
}
