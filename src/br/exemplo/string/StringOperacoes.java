package br.exemplo.string;

public class StringOperacoes {

	public static void main(String[] args) {

		String s1 = "Write Once";
		String s2 = s1 + "Run AnyWhere";
		String s3 = new String ("Java Virtual Machine");
		//char[] array = {'J','a','v','a'};
		//String s4 = new String(array);
		
		
		//OPERA��ES
		int tamanho = s1.length();
		System.out.println("Numeros de caracteres: "+tamanho);
		
		char letra = s1.charAt(6);//0 a length()-1
		System.out.println("Letra na posi��o 6 de s1: "+letra);
		
		String texto = s1.toLowerCase();
		System.out.println("Retorna a String: "+texto);
		
		
		//LOCALIZA��O
		int posicao = s3.indexOf("Virtual");
		System.out.println("Pavavra VIRTUAL na S3 come�a na posi��o "+posicao);
		
		int ultimaPosicao = s3.lastIndexOf("a");
		System.out.println("Ultimo A na S3 esta na posi��o "+ultimaPosicao);
		
		boolean vazia = s3.isEmpty();
		System.out.println("Esta vazia S3? "+vazia);
		
		
		//COMPARA��O
		
		boolean igual = s1.equals("write once");
		System.out.println("S1 tem o texto write once (caixa baixa)? "+igual);
		
		igual = s1.equalsIgnoreCase("write once");
		System.out.println("S1 tem o texto write once (ignora caixa baixa)? "+igual);
		
		igual = s1.startsWith("Once");
		System.out.println("S1 come�a com Once? "+igual);
		
		igual = s1.endsWith("Once");
		System.out.println("S1 termina com Once? "+igual);
		
		int comparacao = " ".compareTo("bola");
		System.out.println("Abacaxi vem antes de bola? "+comparacao);
		
		igual = s3.regionMatches(true, 5, "virtual", 0, 7);
		System.out.println("A parti do 6� caractere, tem a palavra VIRTUAL? "+igual);
		
		String restante = s3.substring(13);
		System.out.println("Quais s�o os caracteres do S3 depois do 13�? "+restante);
		
		s3 = s3.replace("Machine", "Maquina");
		System.out.println("Subtituir Machine por Maquina: "+s3);
		
		s3 = s3.replace(" ", "");
		System.out.println("Retirar todos os espa�os: "+s3);
		
		s2 = s2.toUpperCase();
		System.out.println("S1 em caixa alta: "+s2);
		
		s2 = s2.toLowerCase();
		System.out.println("S1 em caixa alta: "+s2);
		
		System.out.println("   Retirar todos os espa�os antes de pois dos caracteres   ".trim());
		
	}
 
}
