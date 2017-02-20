package de.jluger.jugn_vortrag.sample005;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Sample005Controller {
	@FXML
	private TextField firstOperandTextField;
	@FXML
	private ComboBox<Operation> operationComboBox;
	@FXML
	private TextField secondOperandTextField;
	@FXML
	private Button calcButton;
	@FXML
	private Label resultLabel;
	private Sample005ViewModel viewModel;

	public Sample005Controller(Sample005ViewModel viewModel) {
		this.viewModel = viewModel;
	}

	@FXML
	public void initialize() {
		firstOperandTextField.setTextFormatter(viewModel.getOp1Formatter());
		operationComboBox.setItems(viewModel.getOperationList());
		operationComboBox.getSelectionModel().select(viewModel.getSelectedOperationItem().getValue());
		operationComboBox.getSelectionModel().selectedItemProperty().addListener(
				(ObservableValue<? extends Operation> observable, Operation oldValue, Operation newValue) -> {
					viewModel.getSelectedOperationItem().setValue(newValue);
				});
		operationComboBox.setConverter(viewModel.getOperationConverter());
		secondOperandTextField.setTextFormatter(viewModel.getOp2Formatter());
		calcButton.disableProperty().bind(viewModel.getCalcDisableProperty());
		calcButton.setOnAction((ActionEvent e) -> viewModel.calculate());
		resultLabel.textProperty().bind(viewModel.getResultProperty());
	}
}
