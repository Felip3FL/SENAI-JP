package objeto.exemplos.figuras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TesteClasses extends JFrame {
	private JTextField nome = new JTextField();
	
	public TesteClasses() {
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, nome.getText());			
			}
		});

		JButton outro = new JButton("outro ok");
		outro.addActionListener(new Acao());
	}
	
	class Acao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, nome.getText());			
		}
	}
}
