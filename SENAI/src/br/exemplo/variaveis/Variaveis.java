package br.exemplo.variaveis;

public class Variaveis {

	public Variaveis() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]){	
		
	//////////////////////////////////////////////////////////////////////////////////		
		
	//TIPOS E TAMANHO DE VARIAVEIS
		
	int i = 2_147_483_647;							//32-bit		
	byte b = 127; 									//8-bit		
	short s = 32767;								//16-bit		
	
	long l = 9_223_372_036_854_775_807L;			//64-bit		
	float f = 123F;									//32 bit		
	double d = 1.7976931348623157E+308;				//64-bit		
	
	char c = 'C' ;									//16-bit
  //void = 0 (vazio)								
	boolean bo = true;								//True or False
	
	
	
	System.out.println("int \t\t= "+i);
	System.out.println("byte \t\t= "+b);
	System.out.println("short \t\t= "+s);
	System.out.println("\nlong \t\t= "+l);
	System.out.println("float \t\t= "+f);
	System.out.println("double \t\t= "+d);
	System.out.println("\nchar \t\t= "+c);
	System.out.println("boolean \t= "+bo);
	
	
	
	//////////////////////////////////////////////////////////////////////////////////
	
	//VALORES EM BINARIO (Para reconhecer binario, colocar 0b antes do numero binario)
	
	int ii = 0b01110011001100110011001100110011;	//32-bit em binario	
	byte bb = 0b01101100; 							//8-bit	em binario
	short ss = 0b0101010101010101;					//16-bit em binario
	
	
	
	System.out.println("\nint (binario) \t= "+ii);
	System.out.println("byte (binario) \t= "+bb);
	System.out.println("short (binario) = "+ss);
	
	
	
	////////////////////////////////////////////////////////////////
	
	//CONVERTE VALORES DE UMA VARIAVEL
	
	i = s; //Cast Implícito
	System.out.println("\nNovo i \t\t= "+i);
	System.out.println("original s \t= "+s);
	
	i = (int) l;//Cat Explicito
	System.out.println("\nNovo i \t\t= "+i);
	System.out.println("original l \t= "+l);
	
	
	
	////////////////////////////////////////////////////////////////
	
	//VARIAVEIS PRIMITIVA
	
	int variavelPrimitivo = 7;
	//O valor 7 é realmente armazenado na variavel "variavelPrimitivo"
	
	System.out.println("\nVariavel Primitivo \t= "+variavelPrimitivo);
	
	
	
	//VARIAVEIS DE REFERENCIA (String são objetos), 
	
	String variavelReferencia = "FL";
	//ele não guarda o valor, ele aponta o local do valor
	
	variavelReferencia = "Felipe";
	//Nesse exemplo, o valor "FL" não é apagado, só que não há mais nada apontando para ele
	//Nesse caso, a virtual machine chama o GC (Garbage Collector)
	
	System.out.println("Variavel Referencia \t="+variavelReferencia);
	
	
	
	////////////////////////////////////////////////////////////////
	
	//MODIFICADORES DE VARIAVEIS
	
	final int TAMANHO_BRASIL =  203429773;
	//final não deixa mecher mais no valor de "populacaoBrasileira"
	//A Constante final, o nome da variavel deve ser declarada tudo em caixa alta (TAMANHO_BRASIL)
	
	
	System.out.print("\nTamanho do Brasileira é de "+TAMANHO_BRASIL+" \n(Valor fixo, não se mecher mas)");
	
	
	
	////////////////////////////////////////////////////////////////
	
	//CLASSES WRAPPER - Facilita a conversão de variaveis
	
	Double preco = new Double("21.45"); //empacotado
	//Objeto preco aponta para um valor 21.45
	//Para criar um objeto, ultilizamos a paravra new
	double valor1 = preco.doubleValue(); //desempacotar
	int valor2 = preco.intValue();
	byte valor3 = preco.byteValue();
	
	System.out.println("Valor original \t= "+preco);
	System.out.println("double \t\t= "+valor1);
	System.out.println("int  \t\t= "+valor2);
	System.out.println("byte \t\t= "+valor3);
	
	
	
	//CONVERSÃO ESTÁTICA
	
	double d1 = Double.parseDouble("123.45");
	int i1 = Integer.parseInt("123");
	float f1 = Float.parseFloat("3.14F");

	System.out.println("double \t\t= "+d1);
	System.out.println("int \t\t= "+i1);
	System.out.println("float \t\t= "+f1);
	
	
	
	//CONVERTE VALOR BINARIO
	int i2 = Integer.valueOf("101011", 2);
	//valueOf = converte numeros binario 
	//("101011" = valor binario, 2 é indica a base do valor, que no binario é o 2, Hexa é o 16...) 
	
	System.out.println("Valor 101011 \t= "+i2);
	
	}
}
