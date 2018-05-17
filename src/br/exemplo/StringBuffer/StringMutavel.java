package br.exemplo.StringBuffer;

public class StringMutavel {

	public static void main(String[] args) {

		//Pode iniciar fazia ou ja atribuido algum valor
		//StringBuffer s0 = new StringBuffer(); //Metodos sincronizados
		StringBuilder s1 = new StringBuilder("Java"); //Para milhares de requisizão ao mesmo tempo
		
		System.out.println("Valor na String: "+s1.toString()); //Retorna valor string 
		System.out.println("Tamanho da String: "+s1.length());
		System.out.println("Capacidade de armazenamento da String Atual: "+s1.capacity());
		System.out.println("Adicionar novos valores na String: "+s1.append(" JDK"));
		System.out.println("Invertendo valores da String: "+s1.reverse());
		

		String url = new StringBuilder("www.google.com.br").delete(0, 4).toString();
		System.out.println("Remover o www. da URL acima: "+url);
		
	}

}
