package interfaces;

import classes.Endereco;

public interface InterfaceColecaoEndereco {
	public void cadastrarEndereco(Endereco novo);
	
	public void removerEndereco(Endereco excluido);
	public void alterarEndereco(Endereco alterado);
	
	//public Endereco consultar(int id);
	public void carregarClasse(Endereco e);
	
}
