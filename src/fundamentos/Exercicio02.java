package fundamentos;

import javax.swing.JOptionPane;

public class Exercicio02 {
	public static void main(String[] args) {
		
		String entrada;
		int quantidadesHorasTrabalhadas;
		double salarioPorHora;
		int numeroDepedentes;
		
		entrada = JOptionPane.showInputDialog("Digite a quantidade de horas trabalhadas");
		quantidadesHorasTrabalhadas = Integer.parseInt(entrada);
		
		entrada = JOptionPane.showInputDialog("Digite o salário hora");
		salarioPorHora = Integer.parseInt(entrada);
		
		entrada = JOptionPane.showInputDialog("Digite o número de dependentes");
		numeroDepedentes = Integer.parseInt(entrada);
		
		JOptionPane.showMessageDialog(null, "Salário Bruto: " + getSalarioBruto(quantidadesHorasTrabalhadas, salarioPorHora, numeroDepedentes) +
											"\nDesconto INSS: " + getDescontoINSS(salarioPorHora) + 
											"\nDesconto IR: " + getDescontoIR(salarioPorHora) + 
											"\nSalário Líquido: " + getSalarioLiquido(quantidadesHorasTrabalhadas, salarioPorHora, numeroDepedentes));
		
	}
	
	public static double getSalarioBruto(int horaTrabalhada, double salarioPorHora, int numeroDependentes){		
		return (horaTrabalhada * salarioPorHora) + (50 * numeroDependentes);
	}

	public static double getDescontoINSS(double salario){
		if (salario <= 1000)
			return (salario * 8.5) / 100;
		else
			return (salario * 9) / 100;
	}
	
	public static double getDescontoIR(double salario){
		if (salario <= 500)
			return salario;
		else if (salario <= 1000)
			return (salario * 5) / 100;
		else
			return (salario * 7) / 100;
	}
	
	public static double getSalarioLiquido(int horaTrabalhada, double salarioPorHora, int numeroDependentes){
		return getSalarioBruto(horaTrabalhada, salarioPorHora, numeroDependentes) - getDescontoINSS(salarioPorHora) - getDescontoIR(salarioPorHora);
	}	
	
}
