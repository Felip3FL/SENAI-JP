package objeto.exemplos._interface;

import java.util.Comparator;

public class ComparaPorIdade implements Comparator<Amigo> {
	@Override
	public int compare(Amigo amigo1, Amigo amigo2) {
		return amigo2.getIdade() - amigo1.getIdade();
	}
}
