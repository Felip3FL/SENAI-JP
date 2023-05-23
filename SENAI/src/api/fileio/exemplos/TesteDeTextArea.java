package api.fileio.exemplos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TesteDeTextArea extends JFrame implements ActionListener {
	private JTextArea txt = new JTextArea();
	private JScrollPane pane = new JScrollPane(txt);
	private JButton btOk = new JButton("OK");

	public static void main(String[] args) {
		new TesteDeTextArea();
	}

	public TesteDeTextArea() {
		JPanel pn = new JPanel();
		pn.add(btOk);
		btOk.addActionListener(this);
		add(pane, BorderLayout.CENTER);
		add(pn, BorderLayout.SOUTH);
		setTitle("Teste");
		setPreferredSize(new Dimension(200, 200));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileDialog fd = new FileDialog((JDialog) null, "Salvar", FileDialog.SAVE);
			fd.setFile("*.txt");
			fd.setVisible(true);
			String nomearq = fd.getDirectory() + fd.getFile();
			
			PrintWriter out = new PrintWriter(nomearq);
			
			int inicio = 0;
			int fim = -1;
			for (int i = 0; i < txt.getLineCount(); i++) {
				fim = txt.getLineEndOffset(i);
				String linha = "";
				if(fim > inicio) {
					String texto = txt.getText().substring(inicio, fim);
					if(texto.contains("\n"))
						linha = texto.substring(0, texto.length()-1);
					else
						linha = texto;
				}
				out.println(linha);
				inicio = fim;
			}
			txt.setText("");
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
