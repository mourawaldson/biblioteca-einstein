package guis;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import classes.Usuario;
import uteis.Fachada;
import javax.swing.JButton;
import exception.UsuarioInexistenteException;

public class JanelaPesquisaUsuario extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JScrollPane jScrollPane = null;

	private JTable tabelaUsuarios = null;
	
	private Vector<Vector<Comparable>> conteudos;  //  @jve:decl-index=0:
	
	private Vector<String> titulos;

	private JTextField jTextFieldID = null;

	private JLabel jLabelID = null;

	private JButton jButtonExcluir = null;

	private JTextField jTextFieldNome = null;

	private JLabel jLabelNome = null;

	/**
	 * This is the default constructor
	 */
	public JanelaPesquisaUsuario() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(740, 221);
		this.setContentPane(getJContentPane());
		this.setTitle("Pesquisa Usuários");
	}
	
	private void carregarTabelaUsuariosId(int id) {
		Fachada programa = Fachada.getInstancia();
		Vector<Usuario> Usuario = new Vector<Usuario>();
		try {
			Usuario.addElement(programa.consultarUsuarioid(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Iterator it = Usuario.iterator();
		
		conteudos.removeAllElements();
		
		while(it.hasNext()) {
			Usuario u = (Usuario) it.next();
			Vector<Comparable> linha = new Vector<Comparable>();
			linha.add(u.getId());
			linha.add(u.getNome());
			linha.add(u.getRg());
			linha.add(u.getCpf());
			linha.add(u.getTelefone());
			linha.add(u.getCelular());
			linha.add(u.getEmail());
		    linha.add(u.getSexo());
			conteudos.add(linha);
		}
		tabelaUsuarios.updateUI();
	}
	
	private void carregarTabelaUsuariosNome(String nome) {
		Fachada programa = Fachada.getInstancia();
		Vector Usuario = programa.consultarUsuarionome(nome);
		Iterator it = Usuario.iterator();
			
		conteudos.removeAllElements();
			
		while(it.hasNext()) {
			Usuario u = (Usuario) it.next();
			Vector<Comparable> linha = new Vector<Comparable>();
			linha.add(u.getId());
			linha.add(u.getNome());
			linha.add(u.getRg());
			linha.add(u.getCpf());
			linha.add(u.getTelefone());
			linha.add(u.getCelular());
			linha.add(u.getEmail());
		    linha.add(u.getSexo());
			conteudos.add(linha);
		}
		tabelaUsuarios.updateUI();
	}
	
	private void carregarTabelaUsuarios() {
		Fachada programa = Fachada.getInstancia();
		Vector Usuario = programa.listarUsuarios();
		Iterator it = Usuario.iterator();
		
		conteudos.removeAllElements();
		
		while(it.hasNext()) {
			Usuario u = (Usuario) it.next();
			Vector<Comparable> linha = new Vector<Comparable>();
			linha.add(u.getId());
			linha.add(u.getNome());
			linha.add(u.getRg());
			linha.add(u.getCpf());
			linha.add(u.getTelefone());
			linha.add(u.getCelular());
			linha.add(u.getEmail());
		    linha.add(u.getSexo());
			conteudos.add(linha);
		}
		tabelaUsuarios.updateUI();
	}
	
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
			carregarTabelaUsuarios();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelNome = new JLabel();
			jLabelNome.setBounds(new Rectangle(64, 123, 38, 16));
			jLabelNome.setText("Nome");
			jLabelID = new JLabel();
			jLabelID.setBounds(new Rectangle(28, 123, 16, 16));
			jLabelID.setText("ID");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJTextFieldID(), null);
			jContentPane.add(jLabelID, null);
			jContentPane.add(getJButtonExcluir(), null);
			jContentPane.add(getJTextFieldNome(), null);
			jContentPane.add(jLabelNome, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(19,10, 700, 100));
			jScrollPane.setViewportView(getTabelaUsuarios());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tabelaUsuarios	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaUsuarios() {
		if (tabelaUsuarios == null) {
			titulos = new Vector<String>();
			conteudos = new Vector<Vector<Comparable>>();
			titulos.add("ID");
			titulos.add("Nome");
			titulos.add("RG");
			titulos.add("CPF");
			titulos.add("Telefone");
			titulos.add("Celular");
			titulos.add("Email");
			titulos.add("Sexo");
			tabelaUsuarios = new JTable(conteudos, titulos);
		}
		return tabelaUsuarios;
	}

	/**
	 * This method initializes jTextFieldID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldID() {
		if (jTextFieldID == null) {
			jTextFieldID = new JTextField();
			jTextFieldID.setBounds(new Rectangle(26, 145, 23, 20));
			jTextFieldID.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {

				}   
				public void keyReleased(java.awt.event.KeyEvent e) { 
					jTextFieldID.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }else{
			                	int id;
			 					id = Integer.parseInt(jTextFieldID.getText());
			 					carregarTabelaUsuariosId(id);			                	 
			                 }
			             }
			         });
				}
			});
		}
		return jTextFieldID;
	}


	/**
	 * This method initializes jButtonExcluir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton();
			jButtonExcluir.setBounds(new Rectangle(395, 138, 92, 25));
			jButtonExcluir.setText("Excluir");
			jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Fachada programa = Fachada.getInstancia();
					Usuario usuario = new Usuario();
					
					int linhaSel = tabelaUsuarios.getSelectedRow();
					if(linhaSel == -1){
						JOptionPane.showMessageDialog(null,"Selecione algum usuário na tabela");
						return;
					}
					Vector linhaSele = conteudos.elementAt(linhaSel);
					int id = Integer.parseInt( linhaSele.elementAt(0).toString());
					
					usuario.setId(id);
					if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o usuário "+usuario.getNome()) == 0){
						try {
							programa.removerUsuario(usuario);
							carregarTabelaUsuarios();
							JOptionPane.showMessageDialog(null,"Usuario removido com sucesso");
						} catch (UsuarioInexistenteException e1) {
							e1.printStackTrace();
						}
					}else{
						return;
					}
				}
			});
		}
		return jButtonExcluir;
	}

	/**
	 * This method initializes jTextFieldNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setBounds(new Rectangle(63, 145, 176, 20));
			jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyReleased(java.awt.event.KeyEvent e) {    
					String nome;
					nome = jTextFieldNome.getText();
					carregarTabelaUsuariosNome(nome);
				}
			});
		}
		return jTextFieldNome;
	}

	/**
	 * This method initializes jtLivroNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */


	/**
	 * This method initializes jtLivroId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	

	/**
	 * This method initializes ConsultarCliente	
	 * 	
	 * @return javax.swing.JButton	
	 */


	/**
	 * This method initializes ConsultarLivro	
	 * 	
	 * @return javax.swing.JButton	
	 */

}  //  @jve:decl-index=0:visual-constraint="10,10"
