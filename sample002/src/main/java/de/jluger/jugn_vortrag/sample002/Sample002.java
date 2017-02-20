package de.jluger.jugn_vortrag.sample002;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Sample002 extends Application {
	public Sample002() {
	}


	@Override
    public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Screen.fxml"));
		Scene scene = new Scene(root, 500, 275);
		//scene.getStylesheets().add("/com/sun/javafx/scene/control/skin/caspian/caspian.css");
		//setUserAgentStylesheet(STYLESHEET_CASPIAN);
		//setUserAgentStylesheet(STYLESHEET_MODENA);
		stage.setTitle("Rechner");
        stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
