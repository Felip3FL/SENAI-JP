package fundamentos;

import javax.swing.JOptionPane;

public class Exercicio01 {
	public static void main(String[] args) {

	Exercicio01_Produto Produtos[] = new Exercicio01_Produto[3];
		
		for (int i = 0; i < 3; i++) {
			
			Exercicio01_Produto item = new Exercicio01_Produto();
			
			String entQuantidade = JOptionPane.showInputDialog("Digite o " + (i+1) +"º Quantidade do produto");
			item.setQuantidade(Integer.parseInt(entQuantidade));
			
			String entValor = JOptionPane.showInputDialog("Digite o " + (i+1) + "º Valor do produto");
			item.setValor(Double.parseDouble(entValor));
			Produtos[i] = item;
			
		}
		
		//double oi = soma(Produtos);
		JOptionPane.showMessageDialog(null, "A soma total dos produtos são R$ " + somaProduto(Produtos));
		
	}
	
	public static double somaProduto(Exercicio01_Produto produtos[]){
		double soma = 0;
		for (Exercicio01_Produto vetorProduto : produtos) {
			soma += (vetorProduto.getValor() * vetorProduto.getQuantidade());
		}
		return soma;
	}
	

}


