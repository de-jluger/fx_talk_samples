package de.jluger.jugn_vortrag.sample014;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Sample014 extends Application {

	public Sample014() {
	}


	@Override
    public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen.fxml"));
		loader.setController(new Sample014Controller(new Sample14ViewModel()));
		Parent root = loader.load();
		Scene scene = new Scene(root, 700, 475);
		stage.setTitle("Table");
        stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) throws IOException {
		launch(args);
	}
}
