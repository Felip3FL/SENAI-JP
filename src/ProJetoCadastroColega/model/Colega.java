package ProJetoCadastroColega.model;

import java.util.Date;

/*
 * Um Colega 
 *    tem nome, email, idade, nascimento, residencia
 */
public class Colega {
	private String nome;
	private String email;
	private int idade;
	private Date nascimento;
	private Endereco residencia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Endereco getResidencia() {
		return residencia;
	}

	public void setResidencia(Endereco residencia) {
		this.residencia = residencia;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " E-mail: " + email + " Idade: " + idade 
				+ " Nascimento: " + nascimento + " End.: " + residencia;
	}

}
