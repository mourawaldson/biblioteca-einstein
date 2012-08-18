package guis;

import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.util.Iterator;
import java.util.Vector;

import java.sql.SQLException;

import classes.Exemplar;
import classes.Livro;
import exception.ExemplarInexistenteException;

import uteis.Fachada;

public class JanelaCadastraExemplar extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JScrollPane jScrollPaneLivros = null;

	private JTable tabelaLivros = null;
	
	private Vector<Vector<Comparable>> conteudos;  //  @jve:decl-index=0:
	
	private Vector<String> titulos;

	private JButton jButtonCadastrar = null;

	private JTextArea jTextAreaOBS = null;

	private JLabel jLabelOBS = null;

	/**
	 * This is the default constructor
	 */
	public JanelaCadastraExemplar() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(740, 274);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Exemplar");
	}
	
	private void carregarTabelaLivro() {
		Fachada programa = Fachada.getInstancia();
		Vector Livro = programa.listarLivro();
		Iterator it = Livro.iterator();
		
		conteudos.removeAllElements();
		
		while(it.hasNext()) {
			Livro l = (Livro) it.next();
			Vector<Comparable> linha = new Vector<Comparable>();
			linha.add(l.getId());
			linha.add(l.getTitulo());
			linha.add(l.getTipo().getTitulo());
			linha.add(l.getAutor());
			linha.add(l.getEditora());
			linha.add(l.getEdicao());
			linha.add(l.getIsbn());
		    linha.add(l.getIdioma());
			linha.add(l.getAno());
			conteudos.add(linha);
		}
		tabelaLivros.updateUI();
		
	}
	
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
			carregarTabelaLivro();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelOBS = new JLabel();
			jLabelOBS.setBounds(new Rectangle(20, 122, 28, 16));
			jLabelOBS.setText("OBS");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneLivros(), null);
			jContentPane.add(getJButtonCadastrar(), null);
			jContentPane.add(getJTextAreaOBS(), null);
			jContentPane.add(jLabelOBS, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneLivros	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneLivros() {
		if (jScrollPaneLivros == null) {
			jScrollPaneLivros = new JScrollPane();
			jScrollPaneLivros.setBounds(new Rectangle(19,10, 700, 100));
			jScrollPaneLivros.setViewportView(getTabelaLivros());
		}
		return jScrollPaneLivros;
	}

	/**
	 * This method initializes tabelaLivros	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaLivros() {
		if (tabelaLivros == null) {
			titulos = new Vector<String>();
			conteudos = new Vector<Vector<Comparable>>();
			titulos.add("Id");
			titulos.add("Titulo");
			titulos.add("Tipo");
			titulos.add("Autor");
			titulos.add("Editora");
			titulos.add("Edição");
			titulos.add("ISBN");
			titulos.add("Idioma");
			titulos.add("Ano");
			tabelaLivros = new JTable(conteudos, titulos);
			
		}
		return tabelaLivros;
	}

	/**
	 * This method initializes jButtonCadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCadastrar() {
		if (jButtonCadastrar == null) {
			jButtonCadastrar = new JButton();
			jButtonCadastrar.setBounds(new Rectangle(466, 151, 118, 32));
			jButtonCadastrar.setText("Cadastrar");
			jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int linhaSel = tabelaLivros.getSelectedRow();
						if(linhaSel == -1){
							JOptionPane.showMessageDialog(null,"Selecione algum livro na tabela");
							return;
						}
					Vector linhaSele = conteudos.elementAt(linhaSel);
					int codigo = Integer.parseInt( linhaSele.elementAt(0).toString());

					String obs = jTextAreaOBS.getText();
						int id = codigo;
						Fachada programa = Fachada.getInstancia();
						Livro livro;
						try {
							livro = programa.consultarLivro(id);
							Exemplar exemplar = new Exemplar(id,livro,obs,false);
							programa.cadastrarExemplar(exemplar);
							JOptionPane.showMessageDialog(null, "Exemplar Cadastrado com sucesso");
							jTextAreaOBS.setText("");
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (ExemplarInexistenteException e1) {
							e1.getMessage();
						}
				}
			});
		}
		return jButtonCadastrar;
	}

	/**
	 * This method initializes jTextAreaOBS	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaOBS() {
		if (jTextAreaOBS == null) {
			jTextAreaOBS = new JTextArea();
			jTextAreaOBS.setBounds(new Rectangle(22, 142, 313, 79));
		}
		return jTextAreaOBS;
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"  