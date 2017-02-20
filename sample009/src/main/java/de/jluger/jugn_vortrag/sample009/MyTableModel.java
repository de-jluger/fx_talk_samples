package de.jluger.jugn_vortrag.sample009;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel implements TableModel {
	private String[] columnHeaders = {"Spalte 1","Vortrag","Wertung","Vierte Spalte"};
	private String[] vortraege = {"Java","PHP","Compliance"};
	private short[] wertung = {100,0,-100};
	
	@Override
	public int getRowCount() {
		return 3;
	}

	@Override
	public int getColumnCount() {
		return columnHeaders.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex<columnHeaders.length) {
			return columnHeaders[columnIndex];
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex==0) {
			return Integer.class;
		}
		if (columnIndex==1) {
			return String.class;
		}
		return Object.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex==0) {
			return rowIndex+1;
		}
		if (columnIndex==1) {
			return vortraege[rowIndex];
		}
		if (columnIndex==2) {
			return wertung[rowIndex];
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
