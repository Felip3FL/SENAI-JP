package fundamentos.datas.exemplos;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TesteData {
	public static void main(String[] args) {
		Date agora = new Date();
		
		Calendar outradata = Calendar.getInstance();
		
		outradata.set(Calendar.DAY_OF_MONTH, 10);
		outradata.set(Calendar.MONTH, Calendar.OCTOBER);
		outradata.set(Calendar.YEAR, 2001);
				
		System.out.println(outradata.getDisplayName(Calendar.DAY_OF_WEEK,
				Calendar.LONG, Locale.getDefault()));

		System.out.format("Agora: %1$Td/%1$Tm/%1$TY%n", agora);
		System.out.format("Outra: %1$Td/%1$Tm/%1$TY%n", outradata);

		long miliAgora = agora.getTime();
		long miliOutra = outradata.getTimeInMillis();
		
		System.out.println("Agora: " + miliAgora + " milisegundos\nOutra: "
				+ miliOutra + " milisegundos");
		
		long dif = miliAgora - miliOutra;
		long dias = dif / 1000 / 60 / 60 / 24;
		
		System.out.println("Dias: " + dias);
		
		long anos = dif / 1000 / 60 / 60 / 24 / 365;
		System.out.println("Anos: " + anos);
		
		long meses = (dias - anos * 365) / 30;
		System.out.println("Meses: " + meses);
	}
}
