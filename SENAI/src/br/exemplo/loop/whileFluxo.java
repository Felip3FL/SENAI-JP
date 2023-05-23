package br.exemplo.loop;

import java.util.ArrayList;
import java.util.Scanner;

public class whileFluxo {

	private static Scanner entradaTeclado;

	public static void main (String[] args){
	
	ArrayList<String> produtos = new ArrayList<String>();
	entradaTeclado = new Scanner(System.in);
	
	System.out.println("Liste seus produtos: (Para sair, digite FIM)");
	
	String produto;
	
	while(!"FIM".equals(produto = entradaTeclado.nextLine())){
		produtos.add(produto);
	}
	
	System.out.println(produtos.toString());
		
	}
	
}
