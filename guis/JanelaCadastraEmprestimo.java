package guis;


import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import uteis.Fachada;
import classes.Emprestado;
import classes.Emprestimo;
import classes.Exemplar;
import classes.Usuario;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;

import exception.ExemplarInexistenteException;

public class JanelaCadastraEmprestimo extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JScrollPane jScrollPaneExemplar = null;

	private JTable tabelaExemplar = null;
	
	private Vector<Vector<Comparable>> conteudoExemplar;  //  @jve:decl-index=0:
	
	private Vector<Vector<Comparable>> conteudoUsuario;
	
	private Vector<Emprestado> emprestados;  //  @jve:decl-index=0:
	
	private Vector<String> tituloExemplar;
	
	private Vector<String> tituloUsuario;

	private JButton jButtonEmprestar = null;

	private JButton jButtonAdd = null;

	private JScrollPane jScrollPaneUsuario = null;

	private JTable tabelaUsuario = null;

	private JLabel jLabelExemplares = null;

	private JLabel jLabelUsuarios = null;

	/**
	 * This is the default constructor
	 */
	public JanelaCadastraEmprestimo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(389, 405);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Emprestimo");
	}
	
	private void carregarTabelaLivro() {
		Fachada programa = Fachada.getInstancia();
		
		Vector Emprestado = programa.listarExemplar();
		Iterator it = Emprestado.iterator();

		conteudoExemplar.removeAllElements();

		while(it.hasNext()) {
			Exemplar e = (Exemplar) it.next();
			if (!e.isStatus()){
				Vector<Comparable> linha = new Vector<Comparable>();
				linha.add(e.getId());
				linha.add(e.getLivro().toString());
				linha.add("Disponivel");
				conteudoExemplar.add(linha);
			}
		}
		tabelaExemplar.updateUI();
	}
	
	private void carregarTabelaUsuario() {
		Fachada programa = Fachada.getInstancia();
		
		Vector Emprestado = programa.listarUsuarios();
		Iterator it = Emprestado.iterator();

		conteudoUsuario.removeAllElements();

		while(it.hasNext()) {
			Usuario u = (Usuario) it.next();
				Vector<Comparable> linha = new Vector<Comparable>();
				linha.add(u.getId());
				linha.add(u.getNome());
				linha.add(u.getCpf());
				conteudoUsuario.add(linha);
		}
		tabelaUsuario.updateUI();
	}
	
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
			carregarTabelaLivro();
			carregarTabelaUsuario();
			emprestados = new Vector<Emprestado>();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {

			jLabelUsuarios = new JLabel();
			jLabelUsuarios.setText("Usuários");
			jLabelUsuarios.setBounds(new Rectangle(164, 195, 54, 16));
			jLabelExemplares = new JLabel();
			jLabelExemplares.setBounds(new Rectangle(155, 3, 71, 16));
			jLabelExemplares.setText("Exemplares");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			jContentPane.add(getJScrollPaneExemplar(), null);
			jContentPane.add(getJScrollPaneUsuario(), null);
			jContentPane.add(jLabelExemplares, null);
			jContentPane.add(jLabelUsuarios, null);
			jContentPane.add(getJButtonEmprestar(), null);
			jContentPane.add(getJButtonAdd(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneExemplar	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneExemplar() {
		if (jScrollPaneExemplar == null) {
			jScrollPaneExemplar = new JScrollPane();
			jScrollPaneExemplar.setBounds(new Rectangle(18,25, 350, 100));
			jScrollPaneExemplar.setViewportView(getTabelaExemplar());
		}
		return jScrollPaneExemplar;
	}

	/**
	 * This method initializes tabelaExemplar	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaExemplar() {
		if (tabelaExemplar == null) {
			tituloExemplar = new Vector<String>();
			conteudoExemplar = new Vector<Vector<Comparable>>();
			tituloExemplar.add("Id");
			tituloExemplar.add("Título");
			tituloExemplar.add("Status");

			tabelaExemplar = new JTable(conteudoExemplar, tituloExemplar);
		}
		return tabelaExemplar;
	}

	/**
	 * This method initializes jButtonEmprestar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEmprestar() {
		if (jButtonEmprestar == null) {
			jButtonEmprestar = new JButton();
			jButtonEmprestar.setText("Emprestar");
			jButtonEmprestar.setBounds(new Rectangle(145, 325, 95, 28));
			jButtonEmprestar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int linhaSel = tabelaUsuario.getSelectedRow();
					if(linhaSel == -1){
						JOptionPane.showMessageDialog(null,"Selecione algum usuário na tabela");
						return;
					}
					Vector linhaSele = conteudoUsuario.elementAt(linhaSel);
					int id_usuario = Integer.parseInt( linhaSele.elementAt(0).toString());
					
					Fachada programa = Fachada.getInstancia();
					Usuario usuario = null;

					try {
						usuario = programa.consultarUsuarioid(id_usuario);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						GregorianCalendar data = new GregorianCalendar();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String data_emprestimo = df.format(data.getTime());
						data.add(GregorianCalendar.DAY_OF_MONTH, 5);
						String data_prevista = df.format(data.getTime());
						Emprestimo emprestimo = new Emprestimo();
						if (emprestados.isEmpty()){
							JOptionPane.showMessageDialog(null, "Adicione algum exemplar!!");
							return;
						}else{
							emprestimo.setEmprestados(emprestados);
							emprestimo.setUsuario(usuario);
							emprestimo.setData_emprestimo(data_emprestimo);
							emprestimo.setData_prevista(data_prevista);
							emprestimo.setMulta((float) 0.0);
							emprestimo.setStatus(false);
							programa.cadastraEmprestimo(emprestimo);
							carregarTabelaLivro();
							JOptionPane.showMessageDialog(null, "O exemplar selecionado foi emprestado!");
							emprestados.removeAllElements();
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
			        
				}
			});
			jButtonEmprestar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return jButtonEmprestar;
	}

	/**
	 * This method initializes jButtonAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAdd() {
		if (jButtonAdd == null) {
			jButtonAdd = new JButton();
			jButtonAdd.setText("Adicionar");
			jButtonAdd.setBounds(new Rectangle(145, 133, 95, 28));
			jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						int linhaSel = tabelaExemplar.getSelectedRow();
						if(linhaSel == -1){
							JOptionPane.showMessageDialog(null,"Selecione algum exemplar na tabela");
							return;
						}
						Vector linhaSele = conteudoExemplar.elementAt(linhaSel);
						int codigo = Integer.parseInt( linhaSele.elementAt(0).toString());
					
						Fachada programa = Fachada.getInstancia();
						boolean jatemcarrinho = false;
						Exemplar exe = null;
						Emprestado emp = null;
						try {
							exe = programa.consultarExemplar(codigo);
							exe.setStatus(true);
							emp = new Emprestado(exe,null,false);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage());
						} catch (ExemplarInexistenteException e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage());
						}catch (SQLException e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage());
						}try{
							Iterator it = emprestados.iterator();
							while(it.hasNext()){
								Emprestado atualEmprestado = (Emprestado)it.next();
								if (atualEmprestado.getExemplar().getId() == emp.getExemplar().getId()){
									jatemcarrinho = true;
								}
							}
							if (!jatemcarrinho){
								emprestados.add(emp);
							}else{
								JOptionPane.showMessageDialog(null,"O Exemplar "+emp.getExemplar().getId()+" já está no carrinho!!");
							}
						}catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
				
				}
			});
		}
		return jButtonAdd;
	}

	/**
	 * This method initializes jScrollPaneUsuario	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneUsuario() {
		if (jScrollPaneUsuario == null) {
			jScrollPaneUsuario = new JScrollPane();
			jScrollPaneUsuario.setBounds(new Rectangle(18, 218, 350, 100));
			jScrollPaneUsuario.setViewportView(getTabelaUsuario());
		}
		return jScrollPaneUsuario;
	}

	/**
	 * This method initializes tabelaUsuario	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaUsuario() {
		if (tabelaUsuario == null) {
			tituloUsuario = new Vector<String>();
			conteudoUsuario = new Vector<Vector<Comparable>>();
			tituloUsuario.add("Id");
			tituloUsuario.add("Nome");
			tituloUsuario.add("Cpf");
			tabelaUsuario = new JTable(conteudoUsuario, tituloUsuario);
		}
		return tabelaUsuario;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
