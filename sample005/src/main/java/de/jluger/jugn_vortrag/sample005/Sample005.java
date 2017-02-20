package de.jluger.jugn_vortrag.sample005;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Sample005 extends Application {
	public Sample005() {
	}


	@Override
    public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen.fxml"));
		loader.setController(new Sample005Controller(new Sample005ViewModel()));
		Parent root = loader.load();
		Scene scene = new Scene(root, 500, 275);
		stage.setTitle("Rechner");
        stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
