package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.PesquisasQuestionarios;

public class ConsultaPesquisaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUI = 1l;
	private static final int COL_ESTADO = 0;
	private static final int COL_TOTAL = 1;
	
	private List<PesquisasQuestionarios> valores;
	
	public ConsultaPesquisaTableModel(List<PesquisasQuestionarios> valores) {
		this.valores = new ArrayList<PesquisasQuestionarios>(valores);
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	public String getColumnName(int column) {
		
		if (column == COL_ESTADO) return "Estado";
		if (column == COL_TOTAL) return "Total";
		
		return "";
		
	}

	
	public Object getValue(int row, int column) {
		
		PesquisasQuestionarios pesquisaQuestionario = valores.get(row);
		
		if (column == COL_ESTADO)
			return pesquisaQuestionario.getId_candidato_fk();
		else
			if (column == COL_TOTAL)
				return pesquisaQuestionario.getCpfEleitor();
		return pesquisaQuestionario;
		
		
	}
	
	public Object setValue(Object aValue, int rowIndex, int columnIndex) {
		
		PesquisasQuestionarios pesquisaQuestionario = valores.get(rowIndex);
		
		if (columnIndex == COL_ESTADO)
			pesquisaQuestionario.setCpfEleitor(aValue.toString());
		else
			if (columnIndex == COL_TOTAL)
				pesquisaQuestionario.setId_candidato_fk(aValue.toString());
		return pesquisaQuestionario;
		
		
	}
	
	public Class<?> getColumnClass(int columnIndex){
		return String.class;
		
	}
	
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	

	public PesquisasQuestionarios get(int row) {
		return valores.get(row);
	}

}
