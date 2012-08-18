package guis;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import classes.Livro;
import classes.Tipo;
import exception.LivroJaExisteException;

import uteis.Fachada;

import java.util.Iterator;
import java.util.Vector;
import javax.swing.JTextPane;

public class JanelaCadastraLivro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField titulo = null;

	private JTextField editora = null;

	private JTextField autor = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel3 = null;

	private JButton jButtonCadastra = null;

	private JComboBox tipo = null;

	private JLabel Editora = null;

	private JTextField edicao = null;

	private JLabel ISBN = null;

	private JLabel Idioma = null;

	private JLabel Ano = null;

	private JLabel jLabel4Sinopse = null;

	private JTextField isbn = null;

	private JTextField idioma = null;

	private JTextField ano = null;

	private JTextPane sinopse = null;

	/**
	 * This is the default constructor
	 */
	public JanelaCadastraLivro() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(356, 373);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Livro");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel4Sinopse = new JLabel();
			jLabel4Sinopse.setBounds(new Rectangle(20, 170, 52, 16));
			jLabel4Sinopse.setText("Sinopse");
			Ano = new JLabel();
			Ano.setBounds(new Rectangle(287, 59, 29, 16));
			Ano.setText("Ano");
			Idioma = new JLabel();
			Idioma.setBounds(new Rectangle(135, 60, 38, 16));
			Idioma.setText("Idioma");
			ISBN = new JLabel();
			ISBN.setBounds(new Rectangle(18, 62, 29, 16));
			ISBN.setText("ISBN");
			Editora = new JLabel();
			Editora.setBounds(new Rectangle(286, 11, 43, 16));
			Editora.setText("Edição");
			
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(170, 13, 48, 16));
			jLabel3.setText("Editora");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(20, 118, 38, 16));
			jLabel2.setText("Autor");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(142, 121, 30, 16));
			jLabel1.setText("Tipo");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(17, 13, 38, 16));
			jLabel.setText("Título");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTitulo(), null);
			jContentPane.add(getEditora(), null);
			jContentPane.add(getAutor(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJButtonCadastra(), null);
			jContentPane.add(getTipo(), null);
			jContentPane.add(Editora, null);
			jContentPane.add(getEdicao(), null);
			jContentPane.add(ISBN, null);
			jContentPane.add(Idioma, null);
			jContentPane.add(Ano, null);
			jContentPane.add(jLabel4Sinopse, null);
			jContentPane.add(getIsbn(), null);
			jContentPane.add(getIdioma(), null);
			jContentPane.add(getAno(), null);
			jContentPane.add(getSinopse(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes titulo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTitulo() {
		if (titulo == null) {
			titulo = new JTextField();
			titulo.setBounds(new Rectangle(17, 35, 137, 20));
		}
		return titulo;
	}

	/**
	 * This method initializes editora	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEditora() {
		if (editora == null) {
			editora = new JTextField();
			editora.setBounds(new Rectangle(170, 33, 104, 20));
		}
		return editora;
	}

	/**
	 * This method initializes autor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAutor() {
		if (autor == null) {
			autor = new JTextField();
			autor.setBounds(new Rectangle(19, 141, 102, 20));
		}
		return autor;
	}
	

	/**
	 * This method initializes jButtonCadastra	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCadastra() {
		if (jButtonCadastra == null) {
			jButtonCadastra = new JButton();
			jButtonCadastra.setBounds(new Rectangle(105, 289, 127, 27));
			jButtonCadastra.setText("Cadastrar");
			jButtonCadastra.addActionListener(new java.awt.event.ActionListener() {
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					String Titulo = titulo.getText().trim();
						if(Titulo.length() == 0) {
							JOptionPane.showMessageDialog(null, "Digite o título");
							titulo.requestFocus();
							return;
						}
						
					String Editora = editora.getText().trim();
						if(Editora.length() == 0) {
							JOptionPane.showMessageDialog(null, "Digite a editora");
							editora.requestFocus();
							return;
						}

					String Edicao = edicao.getText().trim();
						if ( Edicao.length() == 0){
							JOptionPane.showMessageDialog(null, "Digite a edição");
							edicao.requestFocus();
							return;
						}

					String ISBN = isbn.getText().trim();
						if(ISBN.length() == 0) {
							JOptionPane.showMessageDialog(null, "Digite o ISBN");
							isbn.requestFocus();
							return;
						}

					String Idioma = idioma.getText().trim();
						if(Idioma.length() == 0) {
							JOptionPane.showMessageDialog(null, "Digite o Idioma");
							idioma.requestFocus();
							return;
						}

					String Ano = ano.getText().trim();
						if((Ano.length() < 4) || (Ano.length() > 4)){
							JOptionPane.showMessageDialog(null, "Digite o Ano, são 4 dígitos");
							ano.requestFocus();
							return;
						}

					String Autor = autor.getText().trim();
						if(Autor.length() == 0) {
							JOptionPane.showMessageDialog(null, "Digite o autor");
							autor.requestFocus();
							return;
						}

					Tipo t = (Tipo) tipo.getSelectedItem();

					String Sinopse = sinopse.getText().trim();

					Livro l = new Livro(t,Titulo,Autor,Editora,Short.parseShort(Edicao),ISBN,Idioma,Integer.parseInt(Ano),Sinopse);
					Fachada programa = Fachada.getInstancia();
					try {
						programa.cadastraLivro(l);
						JOptionPane.showMessageDialog(null, "Livro Cadastrado com sucesso");
						titulo.setText("");
						editora.setText("");
						edicao.setText("");
						isbn.setText("");
						idioma.setText("");
						ano.setText("");
						autor.setText("");
						sinopse.setText("");
						tipo.setSelectedIndex(0);
						titulo.requestFocus();
					} catch (LivroJaExisteException e1) {
						e1.printStackTrace();
					}

				}
			});
		}
		return jButtonCadastra;
		
	}

	/**
	 * This method initializes tipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTipo() {
		if (tipo == null) {
			tipo = new JComboBox();
			tipo.setBounds(new Rectangle(141, 141, 188, 19));
			
			conteudoComboBox();
		}
		return tipo;
	}
	private void conteudoComboBox(){
		Fachada programa = Fachada.getInstancia();
		Vector<Tipo> listagem = programa.listarTipos();
		tipo.removeAllItems();
		Iterator it = listagem.iterator();
			while(it.hasNext()) {
				Tipo vez = (Tipo) it.next();
				tipo.addItem(vez);
			}
	}
	
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
			conteudoComboBox();
	}

	/**
	 * This method initializes edicao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEdicao() {
		if (edicao == null) {
			edicao = new JTextField();
			edicao.setBounds(new Rectangle(287, 32, 25, 20));
			edicao.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					edicao.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
		}
		return edicao;
	}

	/**
	 * This method initializes isbn	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIsbn() {
		if (isbn == null) {
			isbn = new JTextField();
			isbn.setBounds(new Rectangle(18, 82, 97, 20));
		}
		return isbn;
	}

	/**
	 * This method initializes idioma	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIdioma() {
		if (idioma == null) {
			idioma = new JTextField();
			idioma.setBounds(new Rectangle(135, 80, 126, 20));
		}
		return idioma;
	}

	/**
	 * This method initializes ano	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAno() {
		if (ano == null) {
			ano = new JTextField();
			ano.setBounds(new Rectangle(286, 80, 44, 20));
			ano.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					ano.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
		}
		return ano;
	}

	/**
	 * This method initializes sinopse	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getSinopse() {
		if (sinopse == null) {
			sinopse = new JTextPane();
			sinopse.setBounds(new Rectangle(21, 193, 314, 77));
		}
		return sinopse;
	}
}  //  @jve:decl-index=0:visual-constraint="6,30"
