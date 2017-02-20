package de.jluger.jugn_vortrag.sample002;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Sample002Controller {
	private static final String PLUS_OPERATION = "+";
	private static final String MINUS_OPERATION = "-";


    @FXML
    private TextField firstOperandTextField;

    @FXML
    private ComboBox<String> operationComboBox;

    @FXML
    private TextField secondOperandTextField;

    @FXML
    private Button calcButton;

    @FXML
    private Label resultLabel;
    
    @FXML
    public void initialize() {
    	ObservableList<String> list = FXCollections.observableArrayList();
    	list.add(PLUS_OPERATION);
    	list.add(MINUS_OPERATION);
        operationComboBox.setItems(list);
        operationComboBox.getSelectionModel().select(0);
    }
    
    @FXML
    private void calculate(ActionEvent e) {
		try {
			int op1 = Integer.parseInt(firstOperandTextField.getText());
			int op2 = Integer.parseInt(secondOperandTextField.getText());
			int result = 0;
			if (operationComboBox.getSelectionModel().getSelectedItem().equals(PLUS_OPERATION)) {
				result = op1 + op2;
			} else {
				result = op1 - op2;
			}
			resultLabel.setText(Integer.toString(result));
		} catch (RuntimeException ex) {
			resultLabel.setText("Fehler");
		}
	}

}
