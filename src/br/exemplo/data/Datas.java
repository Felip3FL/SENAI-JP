package br.exemplo.data;

import java.util.Calendar;
import java.util.Date; //Importa a classe Date para ultiliza os objetos Date

public class Datas {

	
	public static void main(String[] args) {

		/**
		 * @author Felipe Lima
		 * 
		 * Todo o tempo em java é em millissegundos
		 * O tempo é medido a parti do dia 01 jan 1970
		 * é representado pelo tipo <code>long</code>
		 */
		
		//Imprimi total de millissegundos de 01 jan 1970 até agora
		System.out.println(System.currentTimeMillis());

		//DATE é um objeto da classe util.date
		Date agora = new Date();
		
		
		//Exibir a data completa de hoje,  representada no formato String
		System.out.println(agora);
		
		
		//Qual é a data representada 1_000_000_000_000 a parti de 1/1/1970
		Date data = new Date(1_000_000_000_000L);
		System.out.println("Qual é a data representada 1_000_000_000_000 a parti de 1/1/1970: "+data);
		
		
		
		///////// METODOS DO DATE //////////
		
		Date tempo = new Date();
		
		System.out.println("Recupera o tempo atual em millessegundos: "+tempo.getTime());
		
		//Definir um tempo em millessegundpos
		tempo.setTime(1_000_000_000_000L);
		  
		//Compara o tempo com da data atual, caso for menor = -1 ; Iguais = 0 ; Maior = 1
		System.out.println("1.000.000.000.000: "+data.compareTo(agora));
		
		
		
		
		///////// MANIPULAR DATA //////////
		
		
		//A Classe Calendar não pode ser inicializada, pois ela é uma classe abstrata
		//Esse metodo static que retorna uma instancia de calendario, volta com o calendario Gregoriando
		Calendar calendario = Calendar.getInstance();
		
		//Definindo uma data (ano, mes, dia)
		calendario.set(1992, Calendar.FEBRUARY, 12);
		System.out.println("Imprimir o dia atual com Calendar: "+calendario.getTime());
		System.out.println("Ano: "+(calendario.get(Calendar.YEAR)));
		
		//Mes comeca a conta aparti do 0
		System.out.println("Mes: "+(calendario.get(Calendar.MONTH)+1));
		System.out.println("Dia do mes: "+calendario.get(Calendar.DAY_OF_MONTH));
		
		calendario.set(Calendar.YEAR, 2010); //Alterar ano
		calendario.set(Calendar.MONTH, Calendar.JUNE); //Alterar Mes
		calendario.set(Calendar.DAY_OF_MONTH, 30); //Alterar Ano
		
		System.out.println("Nova data: "+calendario.getTime());
		
		
		//Limpar campos de minutos e segundos
		calendario.clear(Calendar.MINUTE);
		calendario.clear(Calendar.SECOND);
		System.out.println("Minutos e segundos limpos: "+calendario.getTime());
		
		
		//Metodo que permite adicionar unidades de tempo
		calendario.add(Calendar.DAY_OF_MONTH, 1);
		calendario.add(Calendar.YEAR, 1);
		System.out.println("Dia e ano com 1 unidade a mais: "+calendario.getTime());
		
		
		//Metodo que permite aumenta a unidade de tempo, mas não alterar tipos maiores
		calendario.roll(Calendar.DAY_OF_MONTH, 50);
		System.out.println("Adicionando 50 dias com o roll: "+calendario.getTime());
		
		
		///////// SAUDACAO PARA USUARIO ///////////
		
		Calendar calendarioAtual = Calendar.getInstance();
	
		int hora = calendarioAtual.get(Calendar.HOUR_OF_DAY);		//Adquirindo o a hora do dia
		if(hora <= 12){												
			System.out.println("Bom dia");
		}else if (hora > 12 && hora < 18){
			System.out.println("Bom tarde");
		}else{
			System.out.println("Bom noite");
		}
		
		
		
	}

}
