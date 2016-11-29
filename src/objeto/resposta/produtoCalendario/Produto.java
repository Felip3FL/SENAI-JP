package objeto.resposta.produtoCalendario;

import java.time.LocalDate;

public class Produto {
	private String nome;
	private String descricao;
	private LocalDate validade;
	private TipoDeProduto tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public TipoDeProduto getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeProduto tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "nome: " + nome + " descricao: " + descricao + " validade: " + validade + " tipo: " + tipo;
	}

}
