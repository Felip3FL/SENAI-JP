package fundamentos.exemplos;

import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JOptionPane;

public class ExemploConversao2 {
	public static void main(String[] args) {
		// Configurando o Formatador de númeors
		NumberFormat fmt = NumberFormat.getNumberInstance();
		fmt.setMaximumFractionDigits(2);
		fmt.setMinimumFractionDigits(2);	
		
		// Leitura de um nº inteiro
		int garrafas = 0;
		do {
			try {
				String temp = JOptionPane.showInputDialog("Informe o nº de garrafas");
				garrafas = Integer.parseInt(temp);
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nº inválido", "== ERRO ==", 
						JOptionPane.ERROR_MESSAGE);
			}
		} while(garrafas == 0);
		
		// Leitura do preço de cada garrafa
		double preco = 0;		
		do {
			try {
				String temp = JOptionPane.showInputDialog("Informe o preço do Mé!");
				preco = fmt.parse(temp).doubleValue();
			} catch(ParseException ex) {
				JOptionPane.showMessageDialog(null, "Valor inválido", "== ERRO ==", 
						JOptionPane.ERROR_MESSAGE);
			}
		} while(preco == 0);
		
		// Calculando o prejuizo;
		double total = preco * garrafas;
		
		// Apresentar o valor Final
		JOptionPane.showMessageDialog(null, "O valor Total é de R$ " + fmt.format(total));
	}
}
