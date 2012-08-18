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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JanelaCadastraUsuario extends JFrame {

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

	private JLabel jLabelNumero = null;

	private JLabel jLabel10 = null;

	private JLabel jLabel11 = null;

	private JTextField jTextFieldcidade = null;

	private JTextField jTextFieldbairro = null;

	private JTextField jTextFieldnumero = null;

	private JTextField jTextFieldlogradouro = null;

	private JTextField jTextFieldcomplemento = null;

	private JTextField jTextFieldcep = null;

	private JButton jButtonCadastrar = null;

	private JRadioButton jRadioButtonMasculino = null;

	private JRadioButton jRadioButtonFeminino = null;

	private JLabel jLabel12Sexo = null;

	/**
	 * This is the default constructor
	 */
	public JanelaCadastraUsuario() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(490, 294);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Usuário");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel12Sexo = new JLabel();
			jLabel12Sexo.setBounds(new Rectangle(531, 27, 8, 16));
			jLabel12Sexo.setText("");
			jLabel12Sexo.setVisible(false);
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(373, 110, 26, 16));
			jLabel11.setText("Cep");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(212, 157, 84, 16));
			jLabel10.setText("Complemento");
			jLabelNumero = new JLabel();
			jLabelNumero.setBounds(new Rectangle(409, 157, 49, 16));
			jLabelNumero.setText("Número");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(24, 160, 71, 16));
			jLabel8.setText("Logradouro");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(192, 110, 44, 16));
			jLabel7.setText("Bairro");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(25, 110, 43, 16));
			jLabel6.setText("Cidade");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(370, 50, 31, 16));
			jLabel5.setText("Sexo");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(200, 56, 38, 16));
			jLabel4.setText("Email");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(111, 56, 44, 16));
			jLabel3.setText("Celular");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(24, 56, 54, 16));
			jLabel2.setText("Telefone");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(368, 4, 21, 16));
			jLabel1.setText("Cpf");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(250, 4, 21, 16));
			jLabel.setText("Rg");
			jLabelNome = new JLabel();
			jLabelNome.setBounds(new Rectangle(25, 5, 38, 16));
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
			jContentPane.add(jLabelNumero, null);
			jContentPane.add(jLabel10, null);
			jContentPane.add(jLabel11, null);
			jContentPane.add(getJTextFieldcidade(), null);
			jContentPane.add(getJTextFieldbairro(), null);
			jContentPane.add(getJTextFieldnumero(), null);
			jContentPane.add(getJTextFieldlogradouro(), null);
			jContentPane.add(getJTextFieldcomplemento(), null);
			jContentPane.add(getJTextFieldcep(), null);
			jContentPane.add(getJButtonCadastrar(), null);
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
			jTextFieldNome.setBounds(new Rectangle(25, 23, 197, 20));
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
			jTextFieldRg.setBounds(new Rectangle(250, 22, 95, 20));
			jTextFieldRg.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					jTextFieldRg.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
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
			jTextFieldCpf.setBounds(new Rectangle(368, 22, 95, 20));
			jTextFieldCpf.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					jTextFieldCpf.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
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
			jTextFieldTelefone.setBounds(new Rectangle(24, 74, 75, 20));
			jTextFieldTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					jTextFieldTelefone.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
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
			jTextFieldCelular.setBounds(new Rectangle(111, 74, 75, 20));
			jTextFieldCelular.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					jTextFieldCelular.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
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
			jTextFieldEmail.setBounds(new Rectangle(200, 74, 145, 20));
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
			jTextFieldcidade.setBounds(new Rectangle(25, 129, 140, 20));
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
			jTextFieldbairro.setBounds(new Rectangle(192, 129, 153, 20));
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
			jTextFieldnumero.setBounds(new Rectangle(409, 178, 49, 20));
			jTextFieldnumero.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					jTextFieldnumero.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
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
			jTextFieldlogradouro.setBounds(new Rectangle(24, 179, 173, 20));
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
			jTextFieldcomplemento.setBounds(new Rectangle(212, 178, 176, 20));
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
			jTextFieldcep.setBounds(new Rectangle(372, 129, 91, 20));
			jTextFieldcep.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					jTextFieldcep.addKeyListener(new KeyAdapter(){
			             public void keyReleased(KeyEvent e){
			                 if ( !((e.getKeyChar() >= '0') && (e.getKeyChar() <= '9')) ){
			                     ((JTextField) e.getSource()).setText("");
			                 }
			             }
			         });
				}
			});
		}
		return jTextFieldcep;
	}

	/**
	 * This method initializes jButtonCadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
			jRadioButtonMasculino.setSelected(true);
	}
	
	private JButton getJButtonCadastrar() {
		if (jButtonCadastrar == null) {
			jButtonCadastrar = new JButton();
			jButtonCadastrar.setBounds(new Rectangle(198, 218, 104, 25));
			jButtonCadastrar.setText("Cadastrar");
			jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					String nome = jTextFieldNome.getText().trim();
					if(nome.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o nome");
						jTextFieldNome.requestFocus();
						return;
					}
					
					String rg = jTextFieldRg.getText().trim();
					if(rg.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o rg");
						jTextFieldRg.requestFocus();
						return;
					}
					
					String cpf = jTextFieldCpf.getText().trim();
					if(cpf.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o cpf");
						jTextFieldCpf.requestFocus();
						return;
					}else if(cpf.length() > 11){
						JOptionPane.showMessageDialog(null, "O cpf não pode ter mais de 11 caracteres");
						jTextFieldCpf.requestFocus();
						return;
					}
					
					String telefone = jTextFieldTelefone.getText().trim();
					if(telefone.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o telefone");
						jTextFieldTelefone.requestFocus();
						return;
					}else if(telefone.length() > 10){
						JOptionPane.showMessageDialog(null, "O telefone não pode ter mais de 10 caracteres");
						jTextFieldTelefone.requestFocus();
						return;
					}
					
					String celular = jTextFieldCelular.getText().trim();
					if(celular.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o celular");
						jTextFieldCelular.requestFocus();
						return;
					}else if(celular.length() > 10){
						JOptionPane.showMessageDialog(null, "O celular não pode ter mais de 10 caracteres");
						jTextFieldCelular.requestFocus();
						return;
					}
					
					String email = jTextFieldEmail.getText().trim();
					if(email.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o email");
						jTextFieldEmail.requestFocus();
						return;
					}
					
					String sexo = jLabel12Sexo.getText().trim();

					String cidade = jTextFieldcidade.getText().trim();
					if(cidade.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite a cidade");
						jTextFieldcidade.requestFocus();
						return;
					}
					
					String bairro = jTextFieldbairro.getText().trim();
					if(bairro.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o bairro");
						jTextFieldbairro.requestFocus();
						return;
					}
					
					String cep = jTextFieldcep.getText().trim();
					if(cep.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o cep");
						jTextFieldcep.requestFocus();
						return;
					}else if(cep.length() > 8){
						JOptionPane.showMessageDialog(null, "O cep não pode ter mais de 8 caracteres");
						jTextFieldcep.requestFocus();
						return;
					}
					
					String logradouro = jTextFieldlogradouro.getText().trim();
					if(logradouro.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o logradouro");
						jTextFieldlogradouro.requestFocus();
						return;
					}
					
					String numero = jTextFieldnumero.getText().trim();
					if(numero.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o número");
						jTextFieldnumero.requestFocus();
						return;
					}
					
					String complemento = jTextFieldcomplemento.getText().trim();
				
					Fachada programa = Fachada.getInstancia();
					Endereco endereco = new Endereco(numero,logradouro,bairro,cidade,cep,complemento);
					programa.cadastraEndereco(endereco);
					programa.carregaClasse(endereco);

					Usuario usuario = new Usuario(nome,rg,cpf,telefone,celular,email,sexo,endereco);
					try {
						programa.cadastraUsuario(usuario);
						jTextFieldbairro.setText("");
						jTextFieldCelular.setText("");
						jTextFieldcep.setText("");
						jTextFieldcidade.setText("");
						jTextFieldcomplemento.setText("");
						jTextFieldCpf.setText("");
						jTextFieldEmail.setText("");
						jTextFieldlogradouro.setText("");
						jTextFieldnumero.setText("");
						jTextFieldNome.setText("");
						jTextFieldRg.setText("");
						jTextFieldTelefone.setText("");
						jRadioButtonMasculino.setSelected(true);
						jTextFieldNome.requestFocus();
						JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso");
					} catch (UsuarioJaExisteException e1) {
						e1.printStackTrace();
					}
					
					
				}
			});
		}
		return jButtonCadastrar;
	}

	/**
	 * This method initializes jRadioButtonMasculino	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonMasculino() {
		if (jRadioButtonMasculino == null) {
			jRadioButtonMasculino = new JRadioButton();
			jRadioButtonMasculino.setBounds(new Rectangle(366, 65, 84, 21));
			jRadioButtonMasculino.setFont(new Font("Dialog", Font.BOLD, 12));
			jRadioButtonMasculino.setMnemonic(KeyEvent.VK_UNDEFINED);
			jRadioButtonMasculino.setText("Masculino");
			jRadioButtonMasculino.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jRadioButtonFeminino.setSelected(false);
					jRadioButtonMasculino.setSelected(true);
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
			jRadioButtonFeminino.setBounds(new Rectangle(366, 84, 80, 21));
			jRadioButtonFeminino.setText("Feminino");
			jRadioButtonFeminino.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jRadioButtonMasculino.setSelected(false);
					jRadioButtonFeminino.setSelected(true);
					jLabel12Sexo.setText(jRadioButtonFeminino.getText());
				}
			});
		}
		return jRadioButtonFeminino;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
