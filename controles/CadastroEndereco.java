package controles;

import classes.Endereco;

import interfaces.InterfaceColecaoEndereco;

import colecoes.ColecaoEnderecoBDMySQL;



public class CadastroEndereco {
	private InterfaceColecaoEndereco endereco;

	public CadastroEndereco() {
		this.endereco = new ColecaoEnderecoBDMySQL();
	}

	public void cadastrarEndereco(Endereco novo){
		endereco.cadastrarEndereco(novo);	
	}
	


	public void carregarClasse(Endereco e) {
		endereco.carregarClasse(e);
		
	}

}
