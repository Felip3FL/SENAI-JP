package fundamentos.datas;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Exercicio01 {
	
	public static void main(String[] args) {
		
		LocalDateTime dataAgora = LocalDateTime.now();
		
		JOptionPane.showMessageDialog(null, String.format("Hoje é %1$tA, dia %1$te de %1$tB de %1$tY", dataAgora));
		
	}
	
}
