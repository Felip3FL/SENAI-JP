package api.jdbc.exercicio02;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import fundamentos.lib.SwUtil;

@SuppressWarnings("serial")
public class CursoModel extends AbstractTableModel {
	private String[] colunas = { "Nome", "Matrícula", "Descrição" };
	private Map<Integer, CadastroContratos> mapa;
	
	public CursoModel() throws GerenteException {
		criaMapa();
	}
	
	private void criaMapa() throws GerenteException {
		int id = 0;
		mapa = new HashMap<>();
		for (CadastroContratos obj : CursoDao.manager.listaTodos()) {
			mapa.put(id++, obj);
		}
	}
	
	public void adiciona(CadastroContratos obj) throws GerenteException {
		CursoDao.manager.salvar(obj);
		criaMapa();
		fireTableDataChanged();
	}
	
	public void remove(int linha) throws GerenteException {
		CadastroContratos obj = mapa.get(linha);
		CursoDao.manager.apaga(obj.getidContrato());
		criaMapa();
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return mapa.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int col) {
		return colunas[col];
	}

	@Override
	public Object getValueAt(int lin, int col) {
		Object valor = null;
		
		// utilizar o Dao para localizar o objeto Curso por id
		CadastroContratos obj = mapa.get(lin);
		switch (col) {
		case 0:
			valor = obj.getNumero();
			break;
		case 1:
			valor = obj.getData().format(SwUtil.getDateTimeFormatter());
			break;
		case 2:
			valor = obj.getDescricao();
			break;
		}
		
		return valor;
	}

	@Override
	public void setValueAt(Object valor, int lin, int col) {
		CadastroContratos obj = mapa.get(lin);
		
		switch (col) {
		case 0:
			obj.setNumero((String)valor);
			break;
		case 1:
			obj.setData(LocalDate.parse((String)valor, SwUtil.getDateTimeFormatter()));
			break;
		case 2:
			obj.setDescricao((String)valor);
			break;
		}
		// utilizar o Dao para salvar o objeto Curso modificado
		try {
			CursoDao.manager.salvar(obj);
		} catch (GerenteException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public boolean isCellEditable(int lin, int col) {
		return true;
	}
}
