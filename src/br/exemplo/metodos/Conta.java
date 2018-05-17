package br.exemplo.metodos;

@SuppressWarnings("serial")
public class Conta implements java.io.Serializable{
	
	/**
	 * Variaveis de classe (static) não são serializablo
	 * para não armazena por exemplo senhas no serialização
	 * ultiliza o <code>transient</code> ou
	 * alguma outra informação que não pode ser transferida
	 */
	
	public String cliente;
	//transient double saldo;
	public double saldo;

	double limiteDeposito = 10000;

	
	
	public String getCliente() {
		return cliente;
	}

	public double getSaldo() {
		System.out.println(this.cliente+", seu saldo é de ");
		return saldo;
	}

	public Conta(String nomeCliente, double valorInicial) {
		this.cliente = nomeCliente;
		setDepositar(valorInicial);
	}

	public void setDepositar(double valorParaDepositar) {
		if (valorParaDepositar <= limiteDeposito) {
			this.saldo += valorParaDepositar;
		}else{
			System.out.println("Limite estourado!");
		}
	}

	void setSacar(int valorParaSacar) {
		if (valorParaSacar <= this.saldo) {
			this.saldo -= valorParaSacar;
		}
	}

	void setNome(String nomeCliente) {
		this.cliente = nomeCliente;
	}

	double getValorConta() {
		return this.saldo;
	}

}
