package api.jdbc.exercicio02;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import fundamentos.lib.StatusValidador;
import fundamentos.lib.SwUtil;
import fundamentos.lib.TableVerificaData;
import fundamentos.lib.TableVerificaRegex;
import fundamentos.lib.VerificaCellEditor;
import fundamentos.lib.VerificaData;
import fundamentos.lib.VerificaRegex;


@SuppressWarnings("serial")
public class CadCadastroContratos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField tfNome;
	private JLabel lblDescr;
	private JTextField tfDescr;
	private JButton btnIncluir;
	private JButton btnApagar;
	private JButton btnSair;
	private JLabel lblMatrcula;
	private JFormattedTextField tfMatr;
	private JLabel errNome;
	private JLabel errMatr;
	private JLabel errDescr;
	private DateFormat formataData;
	private JScrollPane scrollPane;
	private JTable table;
	private CursoModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadCadastroContratos frame = new CadCadastroContratos();
					frame.setVisible(true); 
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
	}

	public CadCadastroContratos()  throws GerenteException {
		setTitle("Cad. Contrato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		errNome = new JLabel(" ");
		errNome.setForeground(Color.RED);
		
		errMatr = new JLabel(" ");
		errMatr.setForeground(Color.RED);
		
		errDescr = new JLabel(" ");
		errDescr.setForeground(Color.RED);

		lblNome = new JLabel("Nº");

		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setInputVerifier(new VerificaRegex(errNome, ".{1,45}"));
		
		lblMatrcula = new JLabel("Data");
		
		formataData = DateFormat.getDateInstance();
		formataData.setLenient(false);
		
		tfMatr = new JFormattedTextField(formataData);				
		tfMatr.setColumns(10);
		tfMatr.setInputVerifier(new VerificaData(errMatr));

		lblDescr = new JLabel("Descrição");

		tfDescr = new JTextField();
		tfDescr.setColumns(10);
		tfDescr.setInputVerifier(new VerificaRegex(errDescr, ".{5,450}"));

		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(this);

		btnApagar = new JButton("Apagar");
		btnApagar.setVerifyInputWhenFocusTarget(false);
		btnApagar.addActionListener(this);

		btnSair = new JButton("Sair");
		btnSair.setVerifyInputWhenFocusTarget(false);
		btnSair.addActionListener(this);
		
		scrollPane = new JScrollPane();
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(errDescr, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(709, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDescr)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfDescr, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMatrcula)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfMatr, 134, 134, 134))))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))))
					.addGap(88)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(278)
							.addComponent(errNome, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addGap(33))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(errMatr, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(errMatr)
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatrcula)
						.addComponent(tfMatr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(errNome))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescr)
								.addComponent(tfDescr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(errDescr)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnApagar)
						.addComponent(btnSair))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		
		model = new CursoModel();
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(model);
		
		// Parametriza as colunas de edicão do JTable
		
		table.getColumnModel().getColumn(0).setCellEditor(new VerificaCellEditor(new TableVerificaRegex(".{1,45}")));
			
		table.getColumnModel().getColumn(1).setCellEditor(new VerificaCellEditor(new TableVerificaData(formataData)));
			
		table.getColumnModel().getColumn(2).setCellEditor(new VerificaCellEditor(new TableVerificaRegex(".{5,450}")));

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		try {
			if (botao.equals(btnIncluir)) {
				StatusValidador status = SwUtil.verificaStatus(this);
				if(status.equals(StatusValidador.OK)) {
					CadastroContratos obj = new CadastroContratos();
					obj.setNumero(tfNome.getText());
				    obj.setData(((Date) tfMatr.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					obj.setDescricao(tfDescr.getText());

					// utilizar o Dao para salvar o novo objeto Curso
					model.adiciona(obj);

					SwUtil.limpa(this);
					tfNome.requestFocus();
				} else {
					JOptionPane.showMessageDialog(this, "Existem campos com erro");
				}
			} else if (botao.equals(btnApagar)) {
				int linha = table.getSelectedRow();
				
				if(linha > -1) {
					if(table.getRowSorter() != null) 
						linha = table.getRowSorter().convertRowIndexToModel(linha);
					
					// utilizar o Dao para remover o objeto Curso 
					model.remove(linha);
				} else {
					JOptionPane.showMessageDialog(this, "Uma linha na tabela deve ser selecionada");
				}
			} else {
				System.exit(0);
			}
		} catch (GerenteException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
}
