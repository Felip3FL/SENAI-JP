package api.jdbc.resposta.ex01x;

import java.time.LocalDate;

import fundamentos.lib.SwUtil;

public class Amigo {
	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private String numTelefone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	@Override
	public String toString() {
		return "id: " + id + " nome: " + nome + " dataNascimento: "
				+ dataNascimento.format(SwUtil.getDateTimeFormatter())
				+ " numTelefone: " + numTelefone;
	}

}
