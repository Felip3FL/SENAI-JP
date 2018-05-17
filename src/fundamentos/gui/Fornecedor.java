package fundamentos.gui;

public class Fornecedor {
	
	private String nome;
	private String endereco;
	private static int id = 0;

	public void setId() {
		id += 1;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return "ID: " + id + " Nome: " + nome + " Endereco: " + endereco ;
	}
	
}
