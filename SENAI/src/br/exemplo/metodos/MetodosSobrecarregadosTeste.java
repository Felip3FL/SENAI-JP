package br.exemplo.metodos;

public class MetodosSobrecarregadosTeste {

	public static void main(String[] args) {
		
		MetodosSobrecarregados teste = new MetodosSobrecarregados();
		
		System.out.println(teste.media(5));
		System.out.println(teste.media(5,3));
		System.out.println(teste.media("25","15"));
		System.out.println(teste.media(5,10,25));

	}

}
