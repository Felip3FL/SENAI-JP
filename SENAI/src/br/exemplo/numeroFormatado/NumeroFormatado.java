package br.exemplo.numeroFormatado;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumeroFormatado {

	public static void main(String[] args) throws ParseException {

		double saldo = 132_456.789;
		
		//Formata qualquer numero, de acordo com a localização defaul (BR)
		NumberFormat numeroFormatado = NumberFormat.getInstance();
		System.out.println("Número formatado (BR): "+numeroFormatado.format(saldo));
		
		
		numeroFormatado = NumberFormat.getIntegerInstance();
		System.out.println("Número formatado Inteiros: "+numeroFormatado.format(saldo));
		
		numeroFormatado = NumberFormat.getPercentInstance();
		System.out.println("Porcentagem de 0.25: "+numeroFormatado.format(0.25));

		numeroFormatado = NumberFormat.getCurrencyInstance();
		System.out.println("Saldo na moeda brasileira: "+numeroFormatado.format(saldo));
		
		numeroFormatado.setMaximumFractionDigits(3);
		System.out.println("Saldo com 3 casa decimal: "+numeroFormatado.format(saldo));
		
		
		
		/////////// INTERNACIONALIZAÇÃO /////////
		
		numeroFormatado = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Formatação em US: "+numeroFormatado.format(saldo));
	
		numeroFormatado = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		System.out.println("Formatação em US: "+numeroFormatado.format(saldo));
		
		numeroFormatado = NumberFormat.getCurrencyInstance();
		System.out.println("Valor R$ 5.100,21 em outra moeda: "+numeroFormatado.parse("R$ 5.100,21"));
		
	}

}
