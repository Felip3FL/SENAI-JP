package fundamentos.datas;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import javax.swing.JOptionPane;

public class Exercicio04 {
	public static void main(String[] args) {

		//try {
			
			String dataNascimento = "30/06/1992";
			long milisegundos = diferencaData(dataNascimento);
		
			
			long agora = new Date().getTime();

			long dias = (agora - milisegundos) / 1000 / 60 / 60 / 24;
			
			
			JOptionPane.showMessageDialog(null, dias);
			
			
		//}catch(Exception ex){
		//	JOptionPane.showMessageDialog(null, "Data Inválida");
		//}
		
		
		
	}
	
	public  static long diferencaData(String dataParaVerificar){
		
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
		
//		LocalDateTime dt = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		return dataNascimento.toInstant(ZoneOffset.UTC).toEpochMilli();
		
		}catch(Exception ex){
			System.out.println("Erro");
			return 0;
		}
		
	}
	
}
