package de.jluger.jugn_vortrag.sample013;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 * Hello world!
 *
 */
public class Sample013 {
	private static SecureRandom random = new SecureRandom();
	private JFrame frame = new JFrame();

	public Sample013() {
		initComponents();
	}

	private void initComponents() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel titlePane = new JPanel();
		titlePane.setBorder(new TitledBorder("Tabellen-Beispiel"));
		frame.getContentPane().add(titlePane, BorderLayout.CENTER);
		titlePane.setLayout(new BorderLayout());
		String[][] data = new String[100][2];
		for(int i=0;i<data.length;i++) {
			data[i][0]=Integer.toString(i+1);
			data[i][1]=new BigInteger(60, random).toString(32);
		}
		JTable sampleTable = new JTable(data,new String[] {"Id","text"});
		titlePane.add(new JScrollPane(sampleTable),BorderLayout.CENTER);
		JButton printButton = new JButton("Drucken");
		printButton.addActionListener((ActionEvent e)-> {
			try {
				sampleTable.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		});
		titlePane.add(printButton,BorderLayout.SOUTH);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.pack();
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		Sample013 sample = new Sample013();
		sample.setVisible(true);
	}
}
