package br.exemplo.enumeracoes;

public class EnumTeste {
	
	public static final double PI = 3.14;
	
	public static void andar(Medida medida1, int total){
		if(medida1 == Medida.M){
			//... codigo 
		}
	}
	
	
	public static void main(String[] args) {
	
		System.out.println(PecasXadrez.BISPO);
		
		System.out.println(Medida.M.titulo);
		
		for (Medida m : Medida.values()){
			System.out.println(m + " : "+m.titulo);
		}
		
		andar(Medida.M, 100);
		
	}
}
