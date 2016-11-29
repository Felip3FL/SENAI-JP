package objeto.exemplos._interface;

import java.util.Set;
import java.util.TreeSet;

public class TesteDoSet {
	public static void main(String[] args) {
		Set<Amigo> lista = new TreeSet<>();
		
		Amigo a = new Amigo();
		a.setNome("Beltrano");
		a.setEmail("bel@uol.com.br");
		a.setIdade(15);
		
		Amigo b = new Amigo("Fulano", "fufu@gmail.com");
		b.setNome(b.getNome() + " de Tal");
		b.setIdade(22);
	
		Amigo c = new Amigo("Beltrano", "bel@uol.com.br", 16);
		
		System.out.println(b.getNome() + " : " + (lista.add(b) ? "Incluiu" : "Duplicado"));
		System.out.println(a.getNome() + " : " + (lista.add(a) ? "Incluiu" : "Duplicado"));
		System.out.println(c.getNome() + " : " + (lista.add(c) ? "Incluiu" : "Duplicado"));
		
		
		for (Amigo amigo : lista) {
			System.out.println(amigo);
		}
	}
}
