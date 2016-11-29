package objeto.exemplos._interface;

import java.util.ArrayList;
import java.util.List;

public class TesteDoListComContador {
	static List<Amigo> lista = new ArrayList<>();
	
	//TODO: implementar um exemplo que apresente a totalização dos nomes cadastrados utilizando stream
	
	public static void main(String[] args) {
		
		Amigo a = new Amigo();
		a.setNome("Beltrano");
		a.setEmail("bel@uol.com.br");
		a.setIdade(15);
		
		Amigo b = new Amigo("Fulano", "fufu@gmail.com");
		b.setNome(b.getNome() + " de Tal");
		b.setIdade(22);
	
		Amigo c = new Amigo("Beltrano", "bel@uol.com.br", 15);
		
		lista.add(b);
		System.out.println(b.getNome() + " : " + conta(b));
		
		lista.add(a);
		System.out.println(a.getNome() + " : " + conta(a));
		
		lista.add(c);
		System.out.println(c.getNome() + " : " + conta(c));
		
		
		for (Amigo amigo : lista) {
			System.out.println(amigo);
		}
	}
	
	private static long conta(Amigo a) {
		return lista.stream()
				.map(amigo -> amigo.getNome())
				.filter(nome -> nome.equals(a.getNome()))
				.count();
	}
}
