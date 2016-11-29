package fundamentos.datas.exemplos;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TesteNovaData {
	public static void main(String[] args) {
		LocalDateTime agora = LocalDateTime.now();
		
		LocalDateTime outradata = LocalDateTime.of(2001, 10, 10, 0, 0);
		
		System.out.println(outradata.format(DateTimeFormatter.ofPattern("eeee")));
		
		System.out.format("Agora: %1$Td/%1$Tm/%1$TY%n", agora);
		System.out.format("Outra: %1$Td/%1$Tm/%1$TY%n", outradata);

		long miliAgora = agora.toInstant(ZoneOffset.UTC).toEpochMilli();
		long miliOutra = outradata.toInstant(ZoneOffset.UTC).toEpochMilli();
		System.out.println("Agora: " + miliAgora + " milisegundos\nOutra: " + miliOutra + " milisegundos");

		Period dif = Period.between(outradata.toLocalDate(), agora.toLocalDate());
		long dias = ChronoUnit.DAYS.between(outradata, agora);
		System.out.println("Dias: " + dias);
		
		long anos = dif.getYears();
		System.out.println("Anos: " + anos);
		
		long meses = dif.getMonths();
		System.out.println("Meses: " + meses);

	}
}
