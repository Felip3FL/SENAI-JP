package br.exemplo.data;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataInternacional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Calendar calendario = Calendar.getInstance();
		calendario.set(1992, Calendar.JUNE, 12);
		Date data = calendario.getTime();

		//Localização do pais
		Locale brasil = new Locale("pt", "BR");
		Locale eua = Locale.US;

		DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.FULL, brasil);
		System.out.println("Data BR: " + dataFormatada.format(data));

		dataFormatada = DateFormat.getDateInstance(DateFormat.FULL, eua);
		System.out.println("Data US: " + dataFormatada.format(data));

	}

}
