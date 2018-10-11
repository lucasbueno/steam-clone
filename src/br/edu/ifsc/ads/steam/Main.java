package br.edu.ifsc.ads.steam;

import java.net.URL;

import br.edu.ifsc.ads.steam.database.DB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
//		new JMetro(JMetro.Style.LIGHT).applyTheme(scene);
		stage.setScene(scene);
		stage.setTitle("IFSteam");
		stage.setOnCloseRequest((WindowEvent event1) -> {
			closeEvent(stage, event1);
		});
		stage.show();
	}

	private void closeEvent(Stage stage, WindowEvent event1) {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Tem certeza que deseja sair?", ButtonType.YES,
				ButtonType.CANCEL);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES)
			stage.close();
		else
			event1.consume();
	}
}