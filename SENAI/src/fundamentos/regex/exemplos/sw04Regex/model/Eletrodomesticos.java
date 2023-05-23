package fundamentos.regex.exemplos.sw04Regex.model;

public class Eletrodomesticos extends Produto {
	private int codFornecedor;
	private String nomeFornecedor;

	public int getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(int codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	@Override
	public String toString() {
		return super.toString() + " codFornecedor: " + codFornecedor + " nomeFornecedor: "
				+ nomeFornecedor;
	}

}
