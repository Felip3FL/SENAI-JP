package api.fileio.exercicio02.Prof;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModelProduto extends AbstractTableModel {
	private List<Produto> lista;
	
	public ModelProduto(List<Produto> lista) {
		this.lista = lista;
	}

	public void adiciona(Produto prod) {
		lista.add(prod);
		fireTableDataChanged();
	}

	public void setLista(List<Produto> lista) {		
		this.lista = lista;
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Object valor = null;
		Produto prod = lista.get(lin);
		
		switch (col) {
		case 0:
			valor = prod.getCodigo();
			break;
		case 1:
			valor = prod.getNome();
			break;
		case 2:
			valor = prod.getValor();
			break;
		case 3:
			valor = prod.getQuantidade();
			break;
		}
		
		return valor;
	}

	@Override
	public String getColumnName(int col) {
		String nome = "";
		
		switch (col) {
		case 0:
			nome = "Cod.";
			break;
		case 1:
			nome = "Nome";
			break;
		case 2:
			nome = "Valor";
			break;
		case 3:
			nome = "Qtd.";
			break;
		}
		return nome;
	}
}
