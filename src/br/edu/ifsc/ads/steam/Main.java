package br.edu.ifsc.ads.steam;


import java.net.URL;

import br.edu.ifsc.ads.steam.database.DB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);
		DB.conn.close();
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL url = getClass().getResource("./ux/fxml/Main.fxml");
		Parent parent = (Parent) FXMLLoader.load(url);
		Scene scene = new Scene(parent, 800, 600);
//		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/materialfx-toggleswitch.css");
//		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/material-fx-v0_3.css");
//		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
		new JMetro(JMetro.Style.DARK).applyTheme(scene);
		stage.setScene(scene);
		stage.setTitle("IFSteam");
		stage.show();
	}
}