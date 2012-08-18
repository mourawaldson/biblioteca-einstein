package guis;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Rectangle;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;
	
	private JMenu jMenuCadastro = null;
	
	private JMenuItem jMenuItemLivro = null;

	private JanelaCadastraLivro janelaLivro = null;
	
	private JanelaCadastraTipo janelatipo = null;
	
	private JanelaCadastraUsuario janelausuario = null;
	
	private JanelaCadastraExemplar janelaexemplar = null;
	
	private JanelaCadastraEmprestimo janelaemprestado = null;
	
	private JanelaPesquisaUsuario janelapesquisausuario = null;
	
	private JanelaDevolucaoEmprestimo janeladevolucaoemprestimo = null;
	
	private JanelaPesquisaExemplar janelapesquisaexemplar = null;
	
	private JLabel imagem = null;

	private JMenuItem jMenuItemTipo = null;

	private JMenuItem jMenuItemUsuario = null;

	private JMenuItem jMenuItemExemplar = null;

	private JMenu jMenuFuncoes = null;

	private JMenuItem jMenuItemEmprestado = null;

	private JMenuItem jMenuItemPesquisaUsuario = null;

	private JMenuItem jMenuItemDevolucao = null;

	private JMenuItem jMenuItemPesquisaExemplar = null;

	/**
	 * This is the default constructor
	 */
	public JanelaPrincipal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1023, 773);
		this.setContentPane(getJContentPane());
		this.setJMenuBar(getJJMenuBar());
		this.setTitle("Biblioteca");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			imagem = new JLabel();
			imagem.setBounds(new Rectangle(-9, -18, 1025, 745));
			imagem.setIcon(new ImageIcon(getClass().getResource("/imagens/Background.jpg")));
			imagem.setText("JLabel");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(imagem, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenuCadastro());
			jJMenuBar.add(getJMenuFuncoes());
		}
		return jJMenuBar;
	}
	private JMenu getJMenuCadastro() {
		if (jMenuCadastro == null) {
			jMenuCadastro = new JMenu();
			jMenuCadastro.setText("Cadastro");

			jMenuCadastro.add(getJMenuItemLivro());
			jMenuCadastro.add(getJMenuItemTipo());
			jMenuCadastro.add(getJMenuItemUsuario());
			jMenuCadastro.add(getJMenuItemExemplar());
			
		}
		return jMenuCadastro;
	}
	private JMenuItem getJMenuItemLivro() {
		if (jMenuItemLivro == null) {
			jMenuItemLivro = new JMenuItem();
			jMenuItemLivro.setText("Livros");
			jMenuItemLivro.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(janelaLivro==null) {
						janelaLivro = new JanelaCadastraLivro();
					}
					janelaLivro.setVisible(true);
				}
			});
		}
		
		return jMenuItemLivro;
	}
	

	/**
	 * This method initializes jMenuItemTipo	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemTipo() {
		if (jMenuItemTipo == null) {
			jMenuItemTipo = new JMenuItem();
			jMenuItemTipo.setText("Tipo");
			jMenuItemTipo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					janelatipo = new JanelaCadastraTipo();
					janelatipo.setVisible(true);
				}
			});
		}
		return jMenuItemTipo;
	}

	/**
	 * This method initializes jMenuItemUsuario	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemUsuario() {
		if (jMenuItemUsuario == null) {
			jMenuItemUsuario = new JMenuItem();
			jMenuItemUsuario.setText("Usuario");
			jMenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				
					janelausuario = new JanelaCadastraUsuario();
						janelausuario.setVisible(true);
					
				}
			});
		}
		return jMenuItemUsuario;
	}

	/**
	 * This method initializes jMenuItemExemplar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemExemplar() {
		if (jMenuItemExemplar == null) {
			jMenuItemExemplar = new JMenuItem();
			jMenuItemExemplar.setText("Exemplar");
		}
		jMenuItemExemplar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
			
				janelaexemplar = new JanelaCadastraExemplar();
				janelaexemplar.setVisible(true);
				
			}
		});
		return jMenuItemExemplar;
	}

	/**
	 * This method initializes jMenuFuncoes	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuFuncoes() {
		if (jMenuFuncoes == null) {
			jMenuFuncoes = new JMenu();
			jMenuFuncoes.setText("Funcões");
			jMenuFuncoes.add(getJMenuItemEmprestado());
			jMenuFuncoes.add(getJMenuItemPesquisaUsuario());
			jMenuFuncoes.add(getJMenuItemDevolucao());
			jMenuFuncoes.add(getJMenuItemPesquisaExemplar());
		}
		return jMenuFuncoes;
	}

	/**
	 * This method initializes jMenuItemEmprestado	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemEmprestado() {
		if (jMenuItemEmprestado == null) {
			jMenuItemEmprestado = new JMenuItem();
			jMenuItemEmprestado.setText("Emprestimo");
			jMenuItemEmprestado.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				 janelaemprestado = new JanelaCadastraEmprestimo();
					janelaemprestado.setVisible(true);
				}
			});
		}
		return jMenuItemEmprestado;
	}

	/**
	 * This method initializes jMenuItemPesquisaUsuario	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPesquisaUsuario() {
		if (jMenuItemPesquisaUsuario == null) {
			jMenuItemPesquisaUsuario = new JMenuItem();
			jMenuItemPesquisaUsuario.setText("Pesquisa Usuário");
			jMenuItemPesquisaUsuario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					 janelapesquisausuario = new JanelaPesquisaUsuario();
					 janelapesquisausuario.setVisible(true);
				}
			});
		}
		return jMenuItemPesquisaUsuario;
	}

	/**
	 * This method initializes jMenuItemDevolucao	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemDevolucao() {
		if (jMenuItemDevolucao == null) {
			jMenuItemDevolucao = new JMenuItem();
			jMenuItemDevolucao.setText("Devolução");
			jMenuItemDevolucao.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					janeladevolucaoemprestimo = new JanelaDevolucaoEmprestimo();
					janeladevolucaoemprestimo.setVisible(true);
				}
			});
		}
		return jMenuItemDevolucao;
	}
	
	/**
	 * This method initializes jMenuItemPesquisaExemplar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPesquisaExemplar() {
		if (jMenuItemPesquisaExemplar == null) {
			jMenuItemPesquisaExemplar = new JMenuItem();
			jMenuItemPesquisaExemplar.setText("Pesquisa de Exemplares");
			jMenuItemPesquisaExemplar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							janelapesquisaexemplar = new JanelaPesquisaExemplar();
							janelapesquisaexemplar.setVisible(true);
						}
					});
		}
		return jMenuItemPesquisaExemplar;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JanelaPrincipal thisClass = new JanelaPrincipal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				
			}
		});
	}
}  //  @jve:decl-index=0:visual-constraint="5,-84"
