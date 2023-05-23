package ProJetoCadastroColega.model;

public class Endereco {
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		      // Rua Pedro de Toledo, 33 - Centro - CEP: 02129-322
		return logradouro + ", " + numero + " - " + bairro + " - CEP: " + cep;
	}

}
