package fundamentos.math;

public class Exercicio03_caixaDAgua {
	int lado;
	
	public int getLado() {
		return lado;
	}
	
	public void setLado(int lado) {
		this.lado = lado;
	}
	
	public double suporteCaixaDAgua(){
		return lado * lado * lado;
	}
	
}
