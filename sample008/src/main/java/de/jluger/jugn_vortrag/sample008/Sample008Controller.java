package de.jluger.jugn_vortrag.sample008;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class Sample008Controller {
    @FXML
    private TextField urlTextField;

    @FXML
    private Button goButton;

    @FXML
    private WebView webview;
    
	@FXML
	public void initialize() {
		//https://www.whatismybrowser.com/detect/what-http-headers-is-my-browser-sending
		goButton.setOnAction((ActionEvent e)->{
			System.out.println("Go");
			System.out.println(urlTextField.getText());
			webview.getEngine().load(urlTextField.getText());
		});
	}

}
