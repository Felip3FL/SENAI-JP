package br.exemplo.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datas2 {

	//ParseException caso n�o der certo recupera��o do objeto data
	public static void main(String[] args) throws ParseException {

		//A Classe Calendar n�o pode ser inicializada com o new, pois ela � uma classe abstrata
		Calendar calendario = Calendar.getInstance();
		
		calendario.set(1980, Calendar.FEBRUARY, 12); //Definindo Ano, Mes, dia
		Date data = calendario.getTime(); //Recuperar um objeto do tipo DATE para formata��o
		System.out.println("Data definida: "+data);
		
		
		
		/////////// FORMATA��O DE DATAS ///////////
		
		DateFormat formataData = DateFormat.getDateInstance();//� tambem um classe abstrata, n�o pode inicializa com o new
		System.out.println("Data definida formatada: "+formataData.format(data));
		
		
		/////////// FORMATA��O DE TIMES ///////////
		
		formataData = DateFormat.getTimeInstance();//� tambem um classe abstrata, n�o pode inicializa com o new
		System.out.println("Horario atual formatada: "+formataData.format(data));
		
		
		///////// FORMATA��O DE DATA E HORA ///////////

		formataData = DateFormat.getDateTimeInstance();//� tambem um classe abstrata, n�o pode inicializa com o new
		System.out.println("Data Horario formatada: "+formataData.format(data));
		
		
		
		/////// ESTILO DE FORMATA��O DE DATA E HORA ///////////		
		
		formataData = DateFormat.getDateInstance(DateFormat.FULL);//� tambem um classe abstrata, n�o pode inicializa com o new
		System.out.println("Data Horario formatada completa: "+formataData.format(data));
		
		formataData = DateFormat.getDateInstance(DateFormat.LONG);//� tambem um classe abstrata, n�o pode inicializa com o new
		System.out.println("Data Horario formatada longo: "+formataData.format(data));
	
		formataData = DateFormat.getDateInstance(DateFormat.MEDIUM);//� tambem um classe abstrata, n�o pode inicializa com o new
		System.out.println("Data Horario formatada Mediu: "+formataData.format(data));
		
		formataData = DateFormat.getDateInstance(DateFormat.SHORT);//� tambem um classe abstrata, n�o pode inicializa com o new
		System.out.println("Data Horario formatada simples: "+formataData.format(data));
		
		Date data2 = formataData.parse("12/02/1980");//Formatando data
		System.out.println("Data Parse: "+data2); 
		
		
		/////// SimpleDateFormat ///////////
		
		SimpleDateFormat simplesDataFormata = new SimpleDateFormat("dd/MM/yyy");
		System.out.println("Data Formatada SimpleDateFormat: "+simplesDataFormata.format(data));
		System.out.println("Data Formatada SimpleDateFormat: "+simplesDataFormata.parse("10/10/2012"));
		
	}

}
