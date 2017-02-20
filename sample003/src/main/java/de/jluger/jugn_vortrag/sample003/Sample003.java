package de.jluger.jugn_vortrag.sample003;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Sample003 extends Application {
	private static final String PLUS_OPERATION = "+";
	private static final String MINUS_OPERATION = "-";
	private TextField firstOperandTextField;
	private ComboBox<String> operationComboBox;
	private TextField secondOperandTextField;
	private Button calcButton;
	private Label resultLabel;

	public Sample003() {
	}

	private Parent createGui() {
		VBox parentBox = new VBox(10);
		parentBox.setPadding(new Insets(0, 10, 0, 10));
		HBox titleBox = new HBox(10);
		titleBox.setAlignment(Pos.CENTER_LEFT);
		VBox.setMargin(titleBox, new Insets(10, 0, 0, 0));
		parentBox.getChildren().add(titleBox);
		Label rechnerLabel = new Label("Rechner");
		titleBox.getChildren().add(rechnerLabel);
		Separator rechnerSeparator = new Separator();
		HBox.setHgrow(rechnerSeparator, Priority.ALWAYS);
		titleBox.getChildren().add(rechnerSeparator);
		HBox operationBox = new HBox(10);
		operationBox.setAlignment(Pos.CENTER_LEFT);
		parentBox.getChildren().add(operationBox);
		firstOperandTextField = new TextField();
		firstOperandTextField.setPrefColumnCount(7);
		operationComboBox = new ComboBox<>();
		operationComboBox.setPrefWidth(60);
    	ObservableList<String> list = FXCollections.observableArrayList();
    	list.add(PLUS_OPERATION);
    	list.add(MINUS_OPERATION);
        operationComboBox.setItems(list);
        operationComboBox.getSelectionModel().select(0);
		secondOperandTextField = new TextField();
		secondOperandTextField.setPrefColumnCount(7);
		calcButton = new Button("=");
		calcButton.setOnAction(this::calculate);
		resultLabel = new Label();
		operationBox.getChildren().addAll(firstOperandTextField, operationComboBox, secondOperandTextField, calcButton,
				resultLabel);
		HBox copyrightBox = new HBox(10);
		copyrightBox.setAlignment(Pos.CENTER_RIGHT);
		parentBox.getChildren().add(copyrightBox);
		Label copyrightLabel = new Label("© Jörg Luger");
		copyrightBox.getChildren().add(copyrightLabel);
		return parentBox;
	}
	
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

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = createGui();
		Scene scene = new Scene(root, 500, 275);
		stage.setTitle("Rechner");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
