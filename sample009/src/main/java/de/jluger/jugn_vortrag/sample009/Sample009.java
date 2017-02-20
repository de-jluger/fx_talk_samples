package de.jluger.jugn_vortrag.sample009;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 * Hello world!
 *
 */
public class Sample009 {
	private JFrame frame = new JFrame();

	public Sample009() {
		initComponents();
	}

	private void initComponents() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel titlePane = new JPanel();
		titlePane.setBorder(new TitledBorder("Tabellen-Beispiel"));
		frame.getContentPane().add(titlePane, BorderLayout.CENTER);
		titlePane.setLayout(new BorderLayout());
		JTable sampleTable = new JTable(new MyTableModel());
		sampleTable.setDefaultRenderer(Object.class, new MyTableCellRenderer());
		titlePane.add(new JScrollPane(sampleTable),BorderLayout.CENTER);
		//titlePane.add(sampleTable,BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.pack();
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		Sample009 sample = new Sample009();
		sample.setVisible(true);
	}
}
