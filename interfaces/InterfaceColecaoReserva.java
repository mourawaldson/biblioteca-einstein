package interfaces;

import java.util.Vector;

import classes.Livro;
import classes.Reserva;
import classes.Usuario;

public interface InterfaceColecaoReserva {
	public void cadastraReseva(Reserva nova);
	public void removerReseva(Reserva excluida);
	public void alterarReserva(Reserva alterada);
	
	public Vector<Reserva> listar();
	public Vector<Reserva> consultarUsuario(Usuario u);
	public Vector<Reserva> consultarLivro(Livro l);

}
