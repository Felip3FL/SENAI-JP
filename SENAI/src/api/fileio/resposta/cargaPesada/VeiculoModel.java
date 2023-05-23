package api.fileio.resposta.cargaPesada;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VeiculoModel extends AbstractTableModel {
	private List<Veiculo> lista;

	public VeiculoModel(List<Veiculo> lista) {
		this.lista = lista;
	}

	public void setLista(List<Veiculo> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Object valor = null;
		
		Veiculo obj = lista.get(lin);
		
		switch (col) {
		case 0:
			valor = obj.getPlaca();
			break;
		case 1:
			valor = obj.getHora();
			break;
		case 2:
			valor = obj.getMotorista();
			break;
		}
		
		return valor;
	}

	@Override
	public String getColumnName(int col) {
		String nome = "";
		
		switch (col) {
		case 0:
			nome = "Placa";
			break;
		case 1:
			nome = "Hora";
			break;
		case 2:
			nome = "Motorista";
			break;
		}
		
		return nome;
	}
}
