package api.fileio.exercicio03;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ControleEntradaModel extends AbstractTableModel {

	private String[] colunas = {"Placa","Hora","Motorista"};
	private Map<Integer, ControleEntradaVeiculos> mapa;
	
	
	public int getRowCount() {
		return 0;
	}
	
	public int getColumnCount() {
		return 0;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	
	
	
}
