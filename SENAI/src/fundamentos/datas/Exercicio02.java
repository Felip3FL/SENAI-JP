package fundamentos.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class Exercicio02 {
	public static void main(String[] args) {
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		fmt.setLenient(false);
		
		String data = JOptionPane.showInputDialog("Digite uma data: ");
		
		try{
			fmt.parse(data);
			JOptionPane.showMessageDialog(null, "Data Válida");
		}catch(ParseException ex){
			JOptionPane.showMessageDialog(null, "Data Inválida");
		}
		
	}
}
