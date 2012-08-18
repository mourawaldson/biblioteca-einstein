package guis;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JButton;

import uteis.Fachada;

import classes.Endereco;
import classes.Usuario;
import exception.UsuarioJaExisteException;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class JanelaAlteraUsuario extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField jTextFieldNome = null;

	private JTextField jTextFieldRg = null;

	private JTextField jTextFieldCpf = null;

	private JTextField jTextFieldTelefone = null;

	private JTextField jTextFieldCelular = null;

	private JTextField jTextFieldEmail = null;

	private JLabel jLabelNome = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel3 = null;

	private JLabel jLabel4 = null;

	private JLabel jLabel5 = null;

	private JLabel jLabel6 = null;

	private JLabel jLabel7 = null;

	private JLabel jLabel8 = null;

	private JLabel jLabel9 = null;

	private JLabel jLabel10 = null;

	private JLabel jLabel11 = null;

	private JTextField jTextFieldcidade = null;

	private JTextField jTextFieldbairro = null;

	private JTextField jTextFieldnumero = null;

	private JTextField jTextFieldlogradouro = null;

	private JTextField jTextFieldcomplemento = null;

	private JTextField jTextFieldcep = null;

	private JButton jButtonAlterar = null;

	private JRadioButton jRadioButtonMasculino = null;

	private JRadioButton jRadioButtonFeminino = null;

	private JLabel jLabel12Sexo = null;

	/**
	 * This is the default constructor
	 */
	public JanelaAlteraUsuario() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(367, 433);
		this.setContentPane(getJContentPane());
		this.setTitle("Alteração de Usuário");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel12Sexo = new JLabel();
			jLabel12Sexo.setBounds(new Rectangle(21, 376, 67, 16));
			jLabel12Sexo.setText("");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(192, 231, 38, 16));
			jLabel11.setText("Cep");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(193, 185, 99, 16));
			jLabel10.setText("Complemento");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(192, 141, 71, 16));
			jLabel9.setText("Numero");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(196, 96, 90, 16));
			jLabel8.setText("Logradouro");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(194, 47, 44, 16));
			jLabel7.setText("Bairro");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(198, 6, 64, 16));
			jLabel6.setText("Cidade");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(21, 354, 38, 16));
			jLabel5.setText("Sexo");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(27, 203, 38, 16));
			jLabel4.setText("Email");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(23, 163, 55, 16));
			jLabel3.setText("Celular");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(25, 121, 79, 16));
			jLabel2.setText("Telefone");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(24, 83, 38, 16));
			jLabel1.setText("Cpf");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(25, 46, 38, 16));
			jLabel.setText("Rg");
			jLabelNome = new JLabel();
			jLabelNome.setBounds(new Rectangle(29, 7, 38, 16));
			jLabelNome.setText("Nome");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldNome(), null);
			jContentPane.add(getJTextFieldRg(), null);
			jContentPane.add(getJTextFieldCpf(), null);
			jContentPane.add(getJTextFieldTelefone(), null);
			jContentPane.add(getJTextFieldCelular(), null);
			jContentPane.add(getJTextFieldEmail(), null);
			jContentPane.add(jLabelNome, null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(getJTextFieldcidade(), null);
			jContentPane.add(getJTextFieldbairro(), null);
			jContentPane.add(getJTextFieldnumero(), null);
			jContentPane.add(getJTextFieldlogradouro(), null);
			jContentPane.add(getJTextFieldcomplemento(), null);
			jContentPane.add(getJTextFieldcep(), null);
			jContentPane.add(getJButtonAlterar(), null);
			jContentPane.add(getJRadioButtonMasculino(), null);
			jContentPane.add(getJRadioButtonFeminino(), null);
			jContentPane.add(jLabel12Sexo, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setBounds(new Rectangle(25, 23, 107, 20));
		}
		return jTextFieldNome;
	}

	/**
	 * This method initializes jTextFieldRg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRg() {
		if (jTextFieldRg == null) {
			jTextFieldRg = new JTextField();
			jTextFieldRg.setBounds(new Rectangle(24, 64, 110, 20));
		}
		return jTextFieldRg;
	}

	/**
	 * This method initializes jTextFieldCpf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCpf() {
		if (jTextFieldCpf == null) {
			jTextFieldCpf = new JTextField();
			jTextFieldCpf.setBounds(new Rectangle(24, 100, 108, 20));
		}
		return jTextFieldCpf;
	}

	/**
	 * This method initializes jTextFieldTelefone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTelefone() {
		if (jTextFieldTelefone == null) {
			jTextFieldTelefone = new JTextField();
			jTextFieldTelefone.setBounds(new Rectangle(24, 141, 95, 20));
		}
		return jTextFieldTelefone;
	}

	/**
	 * This method initializes jTextFieldCelular	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCelular() {
		if (jTextFieldCelular == null) {
			jTextFieldCelular = new JTextField();
			jTextFieldCelular.setBounds(new Rectangle(25, 182, 102, 20));
		}
		return jTextFieldCelular;
	}

	/**
	 * This method initializes jTextFieldEmail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setBounds(new Rectangle(25, 216, 103, 20));
		}
		return jTextFieldEmail;
	}

	/**
	 * This method initializes jTextFieldcidade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldcidade() {
		if (jTextFieldcidade == null) {
			jTextFieldcidade = new JTextField();
			jTextFieldcidade.setBounds(new Rectangle(195, 23, 95, 20));
		}
		return jTextFieldcidade;
	}

	/**
	 * This method initializes jTextFieldbairro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldbairro() {
		if (jTextFieldbairro == null) {
			jTextFieldbairro = new JTextField();
			jTextFieldbairro.setBounds(new Rectangle(192, 65, 97, 20));
		}
		return jTextFieldbairro;
	}

	/**
	 * This method initializes jTextFieldnumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldnumero() {
		if (jTextFieldnumero == null) {
			jTextFieldnumero = new JTextField();
			jTextFieldnumero.setBounds(new Rectangle(194, 159, 104, 20));
		}
		return jTextFieldnumero;
	}

	/**
	 * This method initializes jTextFieldlogradouro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldlogradouro() {
		if (jTextFieldlogradouro == null) {
			jTextFieldlogradouro = new JTextField();
			jTextFieldlogradouro.setBounds(new Rectangle(194, 112, 104, 20));
		}
		return jTextFieldlogradouro;
	}

	/**
	 * This method initializes jTextFieldcomplemento	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldcomplemento() {
		if (jTextFieldcomplemento == null) {
			jTextFieldcomplemento = new JTextField();
			jTextFieldcomplemento.setBounds(new Rectangle(193, 206, 104, 20));
		}
		return jTextFieldcomplemento;
	}

	/**
	 * This method initializes jTextFieldcep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldcep() {
		if (jTextFieldcep == null) {
			jTextFieldcep = new JTextField();
			jTextFieldcep.setBounds(new Rectangle(191, 252, 111, 20));
		}
		return jTextFieldcep;
	}

	/**
	 * This method initializes jButtonAlterar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAlterar() {
		if (jButtonAlterar == null) {
			jButtonAlterar = new JButton();
			jButtonAlterar.setBounds(new Rectangle(204, 278, 104, 25));
			jButtonAlterar.setText("Alterar");
			jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String nome = jTextFieldNome.getText();
					String rg = jTextFieldRg.getText();
					String cpf = jTextFieldCpf.getText();
					String telefone = jTextFieldTelefone.getText();
					String celular = jTextFieldCelular.getText();
					String email = jTextFieldEmail.getText();
					String sexo = jLabel12Sexo.getText();
					String cidade = jTextFieldcidade.getText();
					String bairro = jTextFieldbairro.getText();
					String logradouro = jTextFieldlogradouro.getText();
					String numero = jTextFieldnumero.getText();
					String complemento = jTextFieldcomplemento.getText();
					String cep = jTextFieldcep.getText();
				
					Fachada programa = Fachada.getInstancia();
					Endereco endereco = new Endereco(numero,logradouro,bairro,cidade,cep,complemento);
					programa.cadastraEndereco(endereco);
					programa.carregaClasse(endereco);
					JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso");
					
					Usuario usuario = new Usuario(nome,rg,cpf,telefone,celular,email,sexo,endereco);
					try {
						programa.cadastraUsuario(usuario);
					} catch (UsuarioJaExisteException e1) {
						e1.printStackTrace();
					}
					
					
				}
			});
		}
		return jButtonAlterar;
	}

	/**
	 * This method initializes jRadioButtonMasculino	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMasculino() {
		if (jRadioButtonMasculino == null) {
			jRadioButtonMasculino = new JRadioButton();
			jRadioButtonMasculino.setBounds(new Rectangle(21, 300, 84, 21));
			jRadioButtonMasculino.setFont(new Font("Dialog", Font.BOLD, 12));
			jRadioButtonMasculino.setMnemonic(KeyEvent.VK_UNDEFINED);
			jRadioButtonMasculino.setText("Masculino");
			jRadioButtonMasculino.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jRadioButtonFeminino.setSelected(false);
					jLabel12Sexo.setText(jRadioButtonMasculino.getText());
				}
			});
		}
		return jRadioButtonMasculino;
	}

	/**
	 * This method initializes jRadioButtonFeminino	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonFeminino() {
		if (jRadioButtonFeminino == null) {
			jRadioButtonFeminino = new JRadioButton();
			jRadioButtonFeminino.setBounds(new Rectangle(23, 331, 80, 21));
			jRadioButtonFeminino.setText("Feminino");
			jRadioButtonFeminino.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jRadioButtonMasculino.setSelected(false);
					jLabel12Sexo.setText(jRadioButtonFeminino.getText());
				}
			});
		}
		return jRadioButtonFeminino;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
