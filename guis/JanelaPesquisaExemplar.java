package guis;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import uteis.Fachada;
import classes.Exemplar;
import classes.Tipo;

public class JanelaPesquisaExemplar extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JScrollPane jScrollPaneExemplar = null;

	private JTable jTableExemplar = null;

	private JTextField jTextFieldNomeLivro = null;

	private JLabel jLabelNomeLivro = null;

	private JTextField jTextFieldAutor = null;

	private JLabel jLabelAutor = null;

	private JComboBox jComboBoxTipo = null;

	private JLabel jLabelTipo = null;
	
	private Vector<String> titulosExemplar;  //  @jve:decl-index=0:
	
	private Vector<Vector<Comparable>> conteudoExemplar;

	/**
	 * This is the default constructor
	 */
	public JanelaPesquisaExemplar() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("Pesquisa de Exemplares");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelTipo = new JLabel();
			jLabelTipo.setBounds(new Rectangle(314, 174, 27, 16));
			jLabelTipo.setText("Tipo");
			jLabelAutor = new JLabel();
			jLabelAutor.setBounds(new Rectangle(192, 177, 37, 16));
			jLabelAutor.setText("Autor");
			jLabelNomeLivro = new JLabel();
			jLabelNomeLivro.setBounds(new Rectangle(37, 174, 91, 16));
			jLabelNomeLivro.setText("Nome do Livro");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneExemplar(), null);
			jContentPane.add(getJTextFieldNomeLivro(), null);
			jContentPane.add(jLabelNomeLivro, null);
			jContentPane.add(getJTextFieldAutor(), null);
			jContentPane.add(jLabelAutor, null);
			jContentPane.add(getJComboBoxTipo(), null);
			jContentPane.add(jLabelTipo, null);
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
			jScrollPaneExemplar.setBounds(new Rectangle(12, 10, 565, 100));
			jScrollPaneExemplar.setViewportView(getJTableExemplar());
		}
		return jScrollPaneExemplar;
	}
	
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
			carregarTabelaExemplar();
	}


	/**
	 * This method initializes jTableExemplar	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableExemplar() {
		if (jTableExemplar == null) {
			jTableExemplar = new JTable();
			titulosExemplar = new Vector<String>();
			conteudoExemplar = new Vector<Vector<Comparable>>();
			titulosExemplar.add("Exemplar");
			titulosExemplar.add("Livro");
			titulosExemplar.add("Autor");
			titulosExemplar.add("Tipo");
			titulosExemplar.add("Editora");
			
			jTableExemplar = new JTable(conteudoExemplar, titulosExemplar);
		}
		return jTableExemplar;
	}
	
	private void carregarTabelaExemplar() {
		Fachada programa = Fachada.getInstancia();
		
		Vector Exemplar = programa.listarExemplar();
		Iterator it = Exemplar.iterator();
		
		conteudoExemplar.removeAllElements();
		
		while(it.hasNext()) {
			Exemplar exe = (Exemplar) it.next();
			Vector<Comparable> linha = new Vector<Comparable>();
			linha.add(exe.getId());
			linha.add(exe.getLivro().getTitulo());
			linha.add(exe.getLivro().getAutor());
			linha.add(exe.getLivro().getTipo().getTitulo());
			linha.add(exe.getLivro().getEditora());

			conteudoExemplar.add(linha);
		}
		jTableExemplar.updateUI();
	}

	/**
	 * This method initializes jTextFieldNomeLivro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNomeLivro() {
		if (jTextFieldNomeLivro == null) {
			jTextFieldNomeLivro = new JTextField();
			jTextFieldNomeLivro.setBounds(new Rectangle(31, 194, 107, 20));
		}
		return jTextFieldNomeLivro;
	}

	/**
	 * This method initializes jTextFieldAutor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAutor() {
		if (jTextFieldAutor == null) {
			jTextFieldAutor = new JTextField();
			jTextFieldAutor.setBounds(new Rectangle(166, 196, 89, 20));
		}
		return jTextFieldAutor;
	}

	/**
	 * This method initializes jComboBoxTipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxTipo() {
		if (jComboBoxTipo == null) {
			jComboBoxTipo = new JComboBox();
			jComboBoxTipo.setBounds(new Rectangle(283, 194, 108, 25));
		}
		return jComboBoxTipo;
	}

}
