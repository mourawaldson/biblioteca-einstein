package classes;

public class Usuario {
	private int id;
	private String nome,rg,cpf,telefone,celular,email;
	private String sexo;
	private Endereco endereco;
	
	public Usuario(int id, String nome, String rg, String cpf, String telefone, String celular, String email,String sexo, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.sexo = sexo;
		this.endereco = endereco;
	}
	public Usuario( String nome, String rg, String cpf, String telefone, String celular, String email,String sexo, Endereco endereco) {
		super();
		
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.sexo = sexo;
		this.endereco = endereco;
	}
	public Usuario() {
		super();
	}
		
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
