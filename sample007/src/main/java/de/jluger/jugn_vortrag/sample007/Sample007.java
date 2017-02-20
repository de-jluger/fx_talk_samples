package de.jluger.jugn_vortrag.sample007;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Hello world!
 *
 */
public class Sample007 {
	private JFrame frame = new JFrame();

	public Sample007() {
		initComponents();
	}

	private void initComponents() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel titlePane = new JPanel();
		titlePane.setBorder(new TitledBorder("HTML-Beispiel"));
		frame.getContentPane().add(titlePane, BorderLayout.CENTER);
		titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.Y_AXIS));
		String html = "<html><font size=\"30\" color=\"red\">Line1</font><br>"
				+ "<font size=\"30\" color=\"green\">Line2</font><br>"
				+ "<font size=\"30\" color=\"blue\">Line3</font></html>";
		JLabel htmlLable = new JLabel(html);
		titlePane.add(htmlLable);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.pack();
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Sample007 sample = new Sample007();
		sample.setVisible(true);
	}
}
