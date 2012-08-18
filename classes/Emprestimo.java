package classes;

import java.util.Vector;

public class Emprestimo {

	private int id;
	private Vector<Emprestado> emprestados;
	private Usuario usuario;
	private String data_emprestimo,data_prevista;
	private float multa;
	private boolean status;
	
	public Emprestimo(int id, Vector<Emprestado> emprestados, Usuario usuario, String data_emprestimo, String data_prevista, float multa, boolean status) {
		super();
		this.id = id;
		this.emprestados = emprestados;
		this.usuario = usuario;
		this.data_emprestimo = data_emprestimo;
		this.data_prevista = data_prevista;
		this.multa = multa;
		this.status = status;
	}
	public Emprestimo() {
	}

	public String getData_emprestimo() {
		return data_emprestimo;
	}
	public void setData_emprestimo(String data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
	public String getData_prevista() {
		return data_prevista;
	}
	public void setData_prevista(String data_prevista) {
		this.data_prevista = data_prevista;
	}
	public Vector<Emprestado> getEmprestados() {
		return emprestados;
	}
	public void setEmprestados(Vector<Emprestado> emprestados) {
		this.emprestados = emprestados;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMulta() {
		return multa;
	}
	public void setMulta(float multa) {
		this.multa = multa;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
