package guis;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JLabel;

import uteis.Fachada;

import classes.Emprestado;
import classes.Emprestimo;
import javax.swing.JButton;

public class JanelaDevolucaoEmprestimo extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JScrollPane jScrollPaneEmprestimo = null;

	private JTable tabelaEmprestimo = null;

	private JScrollPane jScrollPaneEmprestado = null;

	private JTable tabelaEmprestado = null;

	private Vector<String> titulosEmprestado;  //  @jve:decl-index=0:
	
	private Vector<Vector<Comparable>> conteudoEmprestado;
	
	private Vector<String> titulosEmprestimo;

	private Vector<Vector<Comparable>> conteudoEmprestimo;

	private JButton jButtonDevolver = null;

	private JLabel jLabelEmprestimos = null;

	private JLabel jLabelEmprestados = null;

	/**
	 * This is the default constructor
	 */
	public JanelaDevolucaoEmprestimo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(394, 371);
		this.setContentPane(getJContentPane());
		this.setTitle("Devolução");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelEmprestados = new JLabel();
			jLabelEmprestados.setBounds(new Rectangle(152, 150, 80, 16));
			jLabelEmprestados.setText("Emprestados");
			jLabelEmprestimos = new JLabel();
			jLabelEmprestimos.setBounds(new Rectangle(152, 3, 80, 16));
			jLabelEmprestimos.setText("Emprestimos");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneEmprestimo(), null);
			jContentPane.add(getJScrollPaneEmprestado(), null);
			jContentPane.add(getJButtonDevolver(), null);
			jContentPane.add(jLabelEmprestimos, null);
			jContentPane.add(jLabelEmprestados, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneEmprestimo	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneEmprestimo() {
		if (jScrollPaneEmprestimo == null) {
			jScrollPaneEmprestimo = new JScrollPane();
			jScrollPaneEmprestimo.setBounds(new Rectangle(18, 25, 350, 100));
			jScrollPaneEmprestimo.setViewportView(getTabelaEmprestimo());
		}
		return jScrollPaneEmprestimo;
	}

	/**
	 * This method initializes tabelaEmprestimo	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaEmprestimo() {
		if (tabelaEmprestimo == null) {
			titulosEmprestimo = new Vector<String>();
			conteudoEmprestimo = new Vector<Vector<Comparable>>();
			titulosEmprestimo.add("Id");
			titulosEmprestimo.add("Usuario");
			titulosEmprestimo.add("Data Emprestimo");
			titulosEmprestimo.add("Data Prevista");
			titulosEmprestimo.add("Multa");
			titulosEmprestimo.add("Status");
			
			tabelaEmprestimo = new JTable(conteudoEmprestimo, titulosEmprestimo);
			tabelaEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int linhaSel = tabelaEmprestimo.getSelectedRow();
					Vector linhaSele = conteudoEmprestimo.elementAt(linhaSel);
					int id_emprestimo = Integer.parseInt( linhaSele.elementAt(0).toString());
					carregarTabelaEmprestados(id_emprestimo);
				}
			});
		}
		return tabelaEmprestimo;
	}

	/**
	 * This method initializes jScrollPaneEmprestado	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneEmprestado() {
		if (jScrollPaneEmprestado == null) {
			jScrollPaneEmprestado = new JScrollPane();
			jScrollPaneEmprestado.setBounds(new Rectangle(18, 172, 350, 100));
			jScrollPaneEmprestado.setViewportView(getTabelaEmprestado());
		}
		return jScrollPaneEmprestado;
	}

	/**
	 * This method initializes tabelaEmprestado	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaEmprestado() {
		if (tabelaEmprestado == null) {
			titulosEmprestado = new Vector<String>();
			conteudoEmprestado = new Vector<Vector<Comparable>>();
			titulosEmprestado.add("Id");
			titulosEmprestado.add("Data Devolução");
			titulosEmprestado.add("Exemplar");
			titulosEmprestado.add("Status");
			
			tabelaEmprestado = new JTable(conteudoEmprestado, titulosEmprestado);
		}
		return tabelaEmprestado;
	}

	public void setVisible(boolean b) {
		super.setVisible(b);
		if(b)
			carregarTabelaEmprestimos();
	}
	
	private void carregarTabelaEmprestimos() {
		Fachada programa = Fachada.getInstancia();
		
		Vector Emprestimos = programa.consultarEmprestimosAbertos();
		Iterator it = Emprestimos.iterator();
		
		conteudoEmprestimo.removeAllElements();
		
		while(it.hasNext()) {
			Emprestimo emp = (Emprestimo) it.next();
			Vector<Comparable> linha = new Vector<Comparable>();
			if (!emp.isStatus()){
				linha.add(emp.getId());
				linha.add(emp.getUsuario().getNome());
				linha.add(emp.getData_emprestimo());
				linha.add(emp.getData_prevista());
				linha.add(emp.getMulta());
				linha.add("Pendente");
				
				conteudoEmprestimo.add(linha);
			}
		}
		tabelaEmprestimo.updateUI();
		
	}
	
	private void carregarTabelaEmprestados(int id) {
		Fachada programa = Fachada.getInstancia();
		
		Vector Emprestados = programa.consultarEmprestadosEmprestimo(id);
		Iterator it = Emprestados.iterator();
		
		conteudoEmprestado.removeAllElements();
		
		while(it.hasNext()) {
			Emprestado emp = (Emprestado) it.next();
			Vector<Comparable> linha = new Vector<Comparable>();
			linha.add(emp.getId());
			linha.add(emp.getData_devolucao());
			linha.add(emp.getExemplar().getId());
			if (emp.isStatus()){
				linha.add("Devolvido");
			}else{
				linha.add("Pendente");	
			}

			conteudoEmprestado.add(linha);
		}
		tabelaEmprestado.updateUI();
	}

	/**
	 * This method initializes jButtonDevolver	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDevolver() {
		if (jButtonDevolver == null) {
			jButtonDevolver = new JButton();
			jButtonDevolver.setBounds(new Rectangle(147, 291, 96, 25));
			jButtonDevolver.setText("Devolver");
			jButtonDevolver.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int linhaSel = tabelaEmprestimo.getSelectedRow();
					if(linhaSel == -1){
						JOptionPane.showMessageDialog(null,"Selecione algum item na tabela de emprestimos!");
						return;
					}
					if (conteudoEmprestimo.isEmpty()){
						JOptionPane.showMessageDialog(null,"Não existem mais emprestimos pendentes!");
						return;
					}
					Vector linhaSele = conteudoEmprestimo.elementAt(linhaSel);
					int id_emprestimo = Integer.parseInt( linhaSele.elementAt(0).toString());
					
					int linha = tabelaEmprestado.getSelectedRow();
					if(linha == -1){
						JOptionPane.showMessageDialog(null,"Selecione algum item na tabela de emprestados!");
						return;
					}
					Vector linhaSelec = conteudoEmprestado.elementAt(linha);
					String status = linhaSelec.elementAt(3).toString();

					if (status.equals("Devolvido")){
						JOptionPane.showMessageDialog(null,"O item selecionado ja foi devolvido!");
						return;
					}
					int id = Integer.parseInt( linhaSelec.elementAt(0).toString());
					Fachada programa = Fachada.getInstancia();
					Emprestado alterado = null;

					GregorianCalendar data = new GregorianCalendar();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String data_devolucao = df.format(data.getTime());
					
					alterado = programa.consultarEmprestado(id);
					alterado.setStatus(true);
					alterado.setData_devolucao(data_devolucao);
					alterado.getExemplar().setStatus(false);
					programa.alterarEmprestado(alterado);
					
					carregarTabelaEmprestados(id_emprestimo);
					
					if (programa.verificaEmprestimoResolvido(id_emprestimo)){
						Emprestimo emp = programa.consultarEmprestimo(id_emprestimo);
						emp.setStatus(true);
						
						programa.alterarEmprestimo(emp);
						
						carregarTabelaEmprestimos();
						
						linhaSel = tabelaEmprestimo.getSelectedRow();

						if(linhaSel == -1){
							JOptionPane.showMessageDialog(null,"Selecione algum item na tabela de emprestimos!");
							return;
						}
						if (linhaSel == 0){
							conteudoEmprestado.removeAllElements();
							tabelaEmprestado.updateUI();
							return;
						}else{
							linhaSele = conteudoEmprestimo.elementAt(linhaSel);
							id_emprestimo = Integer.parseInt( linhaSele.elementAt(0).toString());
							
							carregarTabelaEmprestados(id_emprestimo);
						}
					}
					JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso!");
				}
			});
		}
		return jButtonDevolver;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
