package br.exemplo.refinado;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Felipe Lima
 * 
 * Aula 97 Garbage Collector
 * 
 */

public class Garbage {

	public static long carregarMemoria(){
		List<Integer> list = new ArrayList<>();
		for (int i=0; i < 100_100;i++){
			list.add(i);
		}
		return Runtime.getRuntime().freeMemory();
	}
	
	
	
	public static void main(String[] args) {
		
		//Recuperar metodo runtime
		Runtime rt = Runtime.getRuntime();
		
		////////// MaxMemory ////////// 
		
		//maxMemory retorna a quantidade total de memoria que JVM pode executar
		final int MB = 1_048_576;//Equivale a 1 Mega
		double total = rt.maxMemory()/MB; //Vem no formato de byte
		System.out.println("Memoria disponivel em Mega-Byte: "+total+" MB");
		
		//Sobrecarregar memoria do computador e verificar mundaça
		double inicio = total - (carregarMemoria() / MB);
		System.out.println("Memoria disponivel apos sobrecargar: "+inicio+" MB");
		
		
		////////// Limpar memoria ////////// 
		
		//Finalizar todos os objetos que foram carregadas na memoria
		rt.runFinalization();
		
		//Chamar o GC para força a execução do Gardage Collector
		rt.gc();
		
		double fim = total - (rt.freeMemory() / MB);
		System.out.println("Memoria disponivel depois de limpeza: "+fim+" MB");
		System.out.println("Total ultilizada: "+(inicio-fim)+" MB");
		
	}
	
}
