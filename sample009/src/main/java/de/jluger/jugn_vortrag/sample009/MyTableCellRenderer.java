package de.jluger.jugn_vortrag.sample009;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyTableCellRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		short wertung = (short)table.getModel().getValueAt(row, 2);
		String renderText = "";
		if (value!=null) {
			renderText = value.toString();
		}
		JLabel label = new JLabel(renderText);
		if (wertung>10) {
			label.setForeground(Color.GREEN);
		}
		if (wertung<-10) {
			label.setForeground(Color.red);
		}
		return label;
	}

}
