package uteis;

import java.sql.SQLException;
import java.util.Vector;

import classes.Emprestado;
import classes.Emprestimo;
import classes.Endereco;
import classes.Exemplar;
import classes.Tipo;
import classes.Livro;
import classes.Usuario;

import controles.CadastroEmprestado;
import controles.CadastroEmprestimo;
import controles.CadastroEndereco;
import controles.CadastroExemplar;
import controles.CadastroTipo;
import controles.CadastroLivro;
import controles.CadastroUsuario;

import exception.ExemplarInexistenteException;
import exception.LivroJaExisteException;
import exception.TipoJaExisteException;
import exception.UsuarioInexistenteException;
import exception.UsuarioJaExisteException;



public class Fachada {
	private static Fachada fachada=null;
	private CadastroTipo tipo;
	private CadastroLivro livro;
	private CadastroExemplar exemplar;
	private CadastroEndereco endereco;
	private CadastroUsuario usuario;
	private CadastroEmprestimo emprestimo;
	private CadastroEmprestado emprestado;
	
	public static Fachada getInstancia() {
		if(fachada==null)
			fachada = new Fachada();
		return fachada;
	}
	
	private Fachada() {
		endereco = new CadastroEndereco();
		tipo = new CadastroTipo();
		exemplar = new CadastroExemplar();
		livro = new CadastroLivro();
		usuario = new CadastroUsuario();
		emprestimo = new CadastroEmprestimo();
		emprestado = new CadastroEmprestado();
	}
 
	public void cadastraLivro(Livro novo) throws LivroJaExisteException{
		livro.cadastrarLivro(novo);
	}

	public void cadastrarExemplar(Exemplar novo) throws ExemplarInexistenteException {
		exemplar.cadastrarExemplar(novo);
	}
	
	public void cadastrarTipoCategoria(Tipo novo) throws TipoJaExisteException {
		tipo.cadastrarTipoCategoria(novo);
	}
	public void cadastrarTipoSobTip(Tipo novo) throws TipoJaExisteException {
		tipo.cadastrarTipoSobTipo(novo);
	}
	
	public void cadastraEndereco(Endereco novo){
		endereco.cadastrarEndereco(novo);
	}
	
	public void cadastraUsuario(Usuario novo) throws UsuarioJaExisteException{
		usuario.cadastrarUsuario(novo);
	}
	
	public void removerUsuario(Usuario excluido) throws UsuarioInexistenteException{
		usuario.removerUsuario(excluido);
	}
	
	public void cadastraEmprestimo(Emprestimo novo){
		 emprestimo.cadastrarEmprestimo(novo);
	}
	
	public void carregaClasse(Endereco e){
		endereco.carregarClasse(e);
	}
	
	public Vector<Tipo> listarTipos() {
		return tipo.listar();
	}
	
	public Vector<Livro> listarLivro(){
		return livro.listar();
	}
	
	public Vector<Usuario> listarUsuarios(){
		return usuario.listar();
	}
	
	public Tipo consultar(int id) throws SQLException{
		return tipo.consultar(id);
	}
	
	public Usuario consultarUsuarioid(int id) throws SQLException{
		return usuario.consultar(id);
	}

	public Vector<Usuario> consultarUsuarionome(String nome){
		return usuario.consultarNome(nome);
	}
	
	public Livro consultarLivro(int id) throws SQLException{
		return livro.consultar(id);
	}
	
	public Vector<Emprestado> listarEmprestado(){
		return emprestado.listarEmprestado();
	}
	public Emprestado consultarEmprestado(int id){
		return emprestado.consultarEmprestado(id);
	}
	
	public void alterarEmprestado(Emprestado alterado){
		this.emprestado.alterarEmprestado(alterado);
	}
	
	public Vector<Exemplar> listarExemplar(){
		return exemplar.listar();
	}
	
	public Exemplar consultarExemplar(int id) throws SQLException, ExemplarInexistenteException{
		return  exemplar.consultar(id);
	}
	
	public Vector<Emprestimo> consultarEmprestimosAbertos(){
		return emprestimo.consultarEmprestimoStatus(false);
	}
	
	public Vector<Emprestado> consultarEmprestadosEmprestimo(int id){
		return emprestado.consultarEmprestimo(id);
	}
	
	public boolean verificaEmprestimoResolvido(int id){
		return emprestimo.emprestadosDevolvidos(id);
	}
	
	public Emprestimo consultarEmprestimo(int id){
		return emprestimo.consultarEmprestimo(id);
	}
	
	public void alterarEmprestimo(Emprestimo alterado){
		this.emprestimo.alterarEmprestimo(alterado);
	}
	
}