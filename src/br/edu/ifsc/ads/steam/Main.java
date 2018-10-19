package br.edu.ifsc.ads.steam;

import java.net.URL;

import br.edu.ifsc.ads.steam.database.DB;
import br.edu.ifsc.ads.steam.properties.Images;
import br.edu.ifsc.ads.steam.properties.Strings;
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
		Parent parent = (Parent) FXMLLoader.load(url, Strings.getBundle());
		Scene scene = new Scene(parent, 800, 600);
		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
		stage.setScene(scene);
		stage.setTitle(Strings.get("appName"));
		stage.setOnCloseRequest((WindowEvent event1) -> {
			closeEvent(stage, event1);
		});
		stage.getIcons().add(Images.getIcon());
		stage.show();
	}

	private void closeEvent(Stage stage, WindowEvent event) {
		ButtonType yes = new ButtonType(Strings.get("yes"));
		ButtonType no = new ButtonType(Strings.get("no"));
		Alert alert = new Alert(AlertType.CONFIRMATION, Strings.get("exitConfirm"), yes,
				no);
		alert.setTitle(Strings.get("exit"));
		alert.setHeaderText(null);
		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(Images.getIcon());
		alert.showAndWait();

		if (alert.getResult() == yes)
			stage.close();
		else
			event.consume();
	}
}