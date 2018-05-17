package br.exemplo.colecao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColecaoSet {


	
	public static void main(String[] args) {

		//Array com dados duplicados
		String[] cores = {"Verde","Amarelo","Azul","Branco","Amarelo","Verde"};
		
		List<String> list = Arrays.asList(cores);
		System.out.println(list);
		
		//Coleção que não aceita duplicados
		Set<String> set = new HashSet<>(list);
		System.out.println(set);
		
	} 

}
