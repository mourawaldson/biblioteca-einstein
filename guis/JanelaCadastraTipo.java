package guis;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.util.Iterator;
import uteis.Fachada;

import classes.Tipo;
import exception.TipoJaExisteException;

public class JanelaCadastraTipo extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField jTextFieldTipo = null;

	private JComboBox jComboBoxTipo = null;

	private JButton jButtonCadastraTipo = null;

	private JLabel jLabel1 = null;

	private JLabel jLabelListaTipos = null;

	/**
	 * This is the default constructor
	 */
	public JanelaCadastraTipo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(303, 168);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Tipos");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelListaTipos = new JLabel();
			jLabelListaTipos.setBounds(new Rectangle(151, 21, 82, 14));
			jLabelListaTipos.setText("Lista de Tipos");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(27, 21, 61, 16));
			jLabel1.setText("Novo Tipo");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldTipo(), null);
			jContentPane.add(getJComboBoxTipo(), null);
			jContentPane.add(getJButtonCadastraTipo(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabelListaTipos, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldTipo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTipo() {
		if (jTextFieldTipo == null) {
			jTextFieldTipo = new JTextField();
			jTextFieldTipo.setBounds(new Rectangle(27, 44, 84, 20));
		}
		return jTextFieldTipo;
	}

	/**
	 * This method initializes jComboBoxTipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxTipo() {
		if (jComboBoxTipo == null) {
			jComboBoxTipo = new JComboBox();
			jComboBoxTipo.setBounds(new Rectangle(145, 44, 129, 20));
			conteudoComboBox();
		}
		return jComboBoxTipo;
	}
	private void conteudoComboBox(){
		Fachada programa = Fachada.getInstancia();
		Vector<Tipo> listagem = programa.listarTipos();
		jComboBoxTipo.removeAllItems();
		jComboBoxTipo.addItem(null);
		Iterator it = listagem.iterator();
	    	while(it.hasNext()) {
				Tipo vez = (Tipo) it.next();
				jComboBoxTipo.addItem(vez);
	    	}
	}

	/**
	 * This method initializes jButtonCadastraTipo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCadastraTipo() {
		if (jButtonCadastraTipo == null) {
			jButtonCadastraTipo = new JButton();
			jButtonCadastraTipo.setBounds(new Rectangle(99, 82, 94, 26));
			jButtonCadastraTipo.setText("Cadastrar");
			jButtonCadastraTipo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					Tipo subtipo = (Tipo) jComboBoxTipo.getSelectedItem();
					Fachada programa = Fachada.getInstancia();
					String categoria = jTextFieldTipo.getText().trim();
					
					if(categoria.length() == 0) {
						JOptionPane.showMessageDialog(null, "Digite o novo tipo");
						jTextFieldTipo.requestFocus();
						return;
					}
					
					Tipo tipo;
					if(subtipo == null){
						tipo = new Tipo(categoria);
						try {
							programa.cadastrarTipoCategoria(tipo);
							conteudoComboBox();
							JOptionPane.showMessageDialog(null,"Novo tipo cadastrado com sucesso! Apenas tipo");
							jTextFieldTipo.setText("");
							jTextFieldTipo.requestFocus();
						} catch (TipoJaExisteException e1) {
							e1.printStackTrace();
						}
					}else{
						tipo = new Tipo(categoria,subtipo);
						try {
							programa.cadastrarTipoSobTip(tipo);
							conteudoComboBox();
							JOptionPane.showMessageDialog(null,"Novo tipo cadastrado com sucesso! Tipo e subTipo");
							jTextFieldTipo.setText("");
							jTextFieldTipo.requestFocus();
						} catch (TipoJaExisteException e1) {
							e1.printStackTrace();
						}
					}

				}
			});
		}
		return jButtonCadastraTipo;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
