package classes;

public class Endereco {
	private int id;
	private String cidade,bairro,logradouro,numero,complemento,cep;
	
	public Endereco(int id,String numero, String logradouro, String bairro, String cidade, String cep,String complemento) {
		super();
		this.id = id;
		this.numero = numero;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.complemento = complemento;
	}
	public Endereco(String numero, String logradouro, String bairro, String cidade, String cep,String complemento) {
		super();
		this.numero = numero;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.complemento = complemento;
	}
	public Endereco() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
