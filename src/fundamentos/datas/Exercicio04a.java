package fundamentos.datas;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.swing.JOptionPane;

public class Exercicio04a {
	public static void main(String[] args) {

		//try {
			
			String dataNascimento = "30/06/1992";
			long milisegundosNascimento = diferencaData(dataNascimento);
			long diasNascimento = milisegundosNascimento / 1000 / 60 / 60 / 24;
			
			long milisegundosAtual = diferencaData(dataAtual());
			long diasAtual = milisegundosAtual / 1000 / 60 / 60 / 24;
			
			
			JOptionPane.showMessageDialog(null, diasAtual - diasNascimento);
			//JOptionPane.showMessageDialog(null, diasAtual);
			
			
		//}catch(Exception ex){
		//	JOptionPane.showMessageDialog(null, "Data Inválida");
		//}
		
		
		
	}
	
	public static long diferencaData(String dataParaVerificar){
		
		try{
		
			SimpleDateFormat formatDataNascimento = new SimpleDateFormat("dd/MM/yyyy");
			formatDataNascimento.setLenient(false);
			
			Date data = formatDataNascimento.parse(dataParaVerificar);
			
			formatDataNascimento.applyLocalizedPattern("d");
			int dia = Integer.parseInt(formatDataNascimento.format(data));
			
			formatDataNascimento.applyLocalizedPattern("MM");
			int mes = Integer.parseInt(formatDataNascimento.format(data));
			
			formatDataNascimento.applyLocalizedPattern("yyyy");
			int ano = Integer.parseInt(formatDataNascimento.format(data));
			
			System.out.println("Dia " + dia + " Mes " + mes + " Ano " + ano);
			
			LocalDateTime dataNascimento = LocalDateTime.of(ano, mes, dia, 0, 0);
			
			return dataNascimento.toInstant(ZoneOffset.UTC).toEpochMilli();
		
		}catch(Exception ex){
			System.out.println("Erro");
			return 0;
		}
		
	}
	
	public static String dataAtual(){
		Date data = new Date();
		return String.format("%1$Td/%1$Tm/%1$TY%n", data);
		
	}
	
	
}
