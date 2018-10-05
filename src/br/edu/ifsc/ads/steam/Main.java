package br.edu.ifsc.ads.steam;


import java.net.URL;

import br.edu.ifsc.ads.steam.database.DB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
		DB.conn.close();
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL url = getClass().getResource("./ux/fxml/Main.fxml");
		Parent parent = (Parent) FXMLLoader.load(url);
		stage.setScene(new Scene(parent, 800, 600));
		stage.setTitle("Sensitive Button");
		stage.show();
	}
}