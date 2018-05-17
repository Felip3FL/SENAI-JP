package br.exemplo.string;

public class StringOperacoes {

	public static void main(String[] args) {

		String s1 = "Write Once";
		String s2 = s1 + "Run AnyWhere";
		String s3 = new String ("Java Virtual Machine");
		//char[] array = {'J','a','v','a'};
		//String s4 = new String(array);
		
		
		//OPERAÇÕES
		int tamanho = s1.length();
		System.out.println("Numeros de caracteres: "+tamanho);
		
		char letra = s1.charAt(6);//0 a length()-1
		System.out.println("Letra na posição 6 de s1: "+letra);
		
		String texto = s1.toLowerCase();
		System.out.println("Retorna a String: "+texto);
		
		
		//LOCALIZAÇÃO
		int posicao = s3.indexOf("Virtual");
		System.out.println("Pavavra VIRTUAL na S3 começa na posição "+posicao);
		
		int ultimaPosicao = s3.lastIndexOf("a");
		System.out.println("Ultimo A na S3 esta na posição "+ultimaPosicao);
		
		boolean vazia = s3.isEmpty();
		System.out.println("Esta vazia S3? "+vazia);
		
		
		//COMPARAÇÃO
		
		boolean igual = s1.equals("write once");
		System.out.println("S1 tem o texto write once (caixa baixa)? "+igual);
		
		igual = s1.equalsIgnoreCase("write once");
		System.out.println("S1 tem o texto write once (ignora caixa baixa)? "+igual);
		
		igual = s1.startsWith("Once");
		System.out.println("S1 começa com Once? "+igual);
		
		igual = s1.endsWith("Once");
		System.out.println("S1 termina com Once? "+igual);
		
		int comparacao = " ".compareTo("bola");
		System.out.println("Abacaxi vem antes de bola? "+comparacao);
		
		igual = s3.regionMatches(true, 5, "virtual", 0, 7);
		System.out.println("A parti do 6º caractere, tem a palavra VIRTUAL? "+igual);
		
		String restante = s3.substring(13);
		System.out.println("Quais são os caracteres do S3 depois do 13º? "+restante);
		
		s3 = s3.replace("Machine", "Maquina");
		System.out.println("Subtituir Machine por Maquina: "+s3);
		
		s3 = s3.replace(" ", "");
		System.out.println("Retirar todos os espaços: "+s3);
		
		s2 = s2.toUpperCase();
		System.out.println("S1 em caixa alta: "+s2);
		
		s2 = s2.toLowerCase();
		System.out.println("S1 em caixa alta: "+s2);
		
		System.out.println("   Retirar todos os espaços antes de pois dos caracteres   ".trim());
		
	}
 
}
