package fundamentos.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Exercicio03 {
	public static void main(String[] args) {
		
		String texto = JOptionPane.showInputDialog("Informe uma data");
		
		//String texto = "30/06/1992";
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		fmt.setLenient(false);
		
		try {
			Date data = fmt.parse(texto);
			
			fmt.applyPattern("'Dia' d \n'Mês:' MM \n'Ano: ' yyyy");
			JOptionPane.showMessageDialog(null, fmt.format(data));
			
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
}
