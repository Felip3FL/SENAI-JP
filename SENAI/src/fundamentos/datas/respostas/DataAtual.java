package fundamentos.datas.respostas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class DataAtual {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		SimpleDateFormat df = new SimpleDateFormat("'Hoje é' EEEE, 'dia' d 'de' MMMM 'de' yyyy.");
		JOptionPane.showMessageDialog(null, df.format(cal.getTime()));

		DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL);
		JOptionPane.showMessageDialog(null, "Hoje é " + df2.format(cal.getTime()) + ".");

//----------- Java 7/ 8 -----------------------------------------------

		JOptionPane.showMessageDialog(null, 
				String.format("Hoje é %1$tA, dia %1$te de %1$tB de %1$tY.", cal));
		
//----------- Java 8 -----------------------------------------------
		
		LocalDate data = LocalDate.now();
		JOptionPane.showMessageDialog(null, data.format(
				DateTimeFormatter.ofPattern("'Hoje é' eeee, 'dia' d 'de' MMMM 'de' y.")));
	}
}
