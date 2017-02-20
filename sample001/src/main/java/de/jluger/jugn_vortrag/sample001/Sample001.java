package de.jluger.jugn_vortrag.sample001;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

/**
 * Hello world!
 *
 */
public class Sample001 {
	private static final String PLUS_OPERATION = "+";
	private static final String MINUS_OPERATION = "-";
	private JFrame frame = new JFrame();
	private JTextField firstOperandTextField;
	private JTextField secondOperandTextField;
	private JComboBox<String> operationComboBox;
	private JButton calcButton;
	private JLabel resultLabel;

	public Sample001() {
		initComponents();
	}

	private void initComponents() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel titlePane = new JPanel();
		titlePane.setBorder(new TitledBorder("Rechner"));
		frame.getContentPane().add(titlePane, BorderLayout.CENTER);
		titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.Y_AXIS));

		JPanel calculationPanel = new JPanel();
		titlePane.add(calculationPanel);
		calculationPanel.setLayout(new BoxLayout(calculationPanel, BoxLayout.X_AXIS));

		firstOperandTextField = new JTextField();
		calculationPanel.add(firstOperandTextField);
		calculationPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		firstOperandTextField.setColumns(10);

		operationComboBox = new JComboBox<>(new String[] { PLUS_OPERATION, MINUS_OPERATION });
		calculationPanel.add(operationComboBox);
		calculationPanel.add(Box.createRigidArea(new Dimension(5, 0)));

		secondOperandTextField = new JTextField();
		calculationPanel.add(secondOperandTextField);
		calculationPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		secondOperandTextField.setColumns(10);

		calcButton = new JButton("=");
		calcButton.addActionListener(this::calculate);
		calculationPanel.add(calcButton);
		calculationPanel.add(Box.createRigidArea(new Dimension(5, 0)));

		resultLabel = new JLabel("");
		calculationPanel.add(resultLabel);

		JPanel copyrightPanel = new JPanel();
		titlePane.add(copyrightPanel);
		copyrightPanel.setLayout(new BorderLayout());

		JLabel copyrightLabel = new JLabel("\u00A9 Jörg Luger");
		copyrightPanel.add(copyrightLabel, BorderLayout.EAST);
		frame.pack();
	}

	private void calculate(ActionEvent e) {
		try {
			int op1 = Integer.parseInt(firstOperandTextField.getText());
			int op2 = Integer.parseInt(secondOperandTextField.getText());
			int result = 0;
			if (operationComboBox.getSelectedItem().equals(PLUS_OPERATION)) {
				result = op1 + op2;
			} else {
				result = op1 - op2;
			}
			resultLabel.setText(Integer.toString(result));
		} catch (RuntimeException ex) {
			resultLabel.setText("Fehler");
		}
		frame.pack();
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Sample001 sample = new Sample001();
		/*
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		*/
		sample.setVisible(true);
	}
}
