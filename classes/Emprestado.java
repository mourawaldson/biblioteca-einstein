package classes;

public class Emprestado {

	private int id;
	private Exemplar exemplar;
	private String data_devolucao;
	private boolean status;

	public Emprestado(int id, Exemplar exemplar, String data_devolucao, boolean status) {
		super();
		this.id = id;
		this.exemplar = exemplar;
		this.data_devolucao = data_devolucao;
		this.status = status;
	}
	public Emprestado(Exemplar exemplar, String data_devolucao, boolean status) {
		super();
		this.exemplar = exemplar;
		this.data_devolucao = data_devolucao;
		this.status = status;
	}
	public Emprestado() {

	}
	
	public String getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exemplar getExemplar() {
		return exemplar;
	}
	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
