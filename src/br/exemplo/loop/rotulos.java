package br.exemplo.loop;

public class rotulos {

	public static void main(String[] args) {

		//Array boolean de 5 x 5
		boolean[][] matrix = { { false, true, false, false, false }, { false, false, false, false } };

		//Busca = rotulo aonde o break ira parar quando for chamado
		busca:
		for (int a = 0; a < matrix.length; a++) {
			System.out.print("A ");
			for (int b = 0; b < matrix[a].length; b++) {
				if (matrix[a][b]) {
					System.out.print("True ");
					break busca; //Para a execução desses looper
				}
				System.out.print("B ");
			}
		}

	}

}
