package de.jluger.jugn_vortrag.sample006;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Sample006Controller {
	@FXML
	private Button menu1Button;

	@FXML
	private Button menu2Button;

	@FXML
	private Button setupButton;

	@FXML
	private VBox workingPane;

	@FXML
	public void initialize() {
		setupLoadWorkingContent(menu1Button, "Menu1.fxml");
		setupLoadWorkingContent(menu2Button, "Menu2.fxml");
		setupLoadWorkingContent(setupButton, "Setup.fxml");
	}

	private void setupLoadWorkingContent(Button b, String fxmlName) {
		b.setOnAction((ActionEvent e) -> {
			try {
				Parent pane = FXMLLoader.load(getClass().getResource(fxmlName));
				workingPane.getChildren().setAll(pane);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
}
