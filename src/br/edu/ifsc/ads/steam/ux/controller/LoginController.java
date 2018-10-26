package br.edu.ifsc.ads.steam.ux.controller;

import java.io.IOException;
import java.net.URL;

import br.edu.ifsc.ads.steam.database.DB;
import br.edu.ifsc.ads.steam.entities.Player;
import br.edu.ifsc.ads.steam.properties.Images;
import br.edu.ifsc.ads.steam.properties.Strings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController {

	@FXML
	TextField txtNickname;

	public void openMain() throws IOException {

		Player player = DB.conn.getPlayer(txtNickname.getText());
		if (player == null) {
			showAlert();
			return;
		}
		
		URL url = getClass().getResource("../fxml/Main.fxml");
		FXMLLoader loader = new FXMLLoader(url, Strings.getBundle());
		Parent root = loader.load();
		Scene scene = new Scene(root, 300, 600);
		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(Strings.get("appName"));
		stage.getIcons().add(Images.getIcon());
		stage.setOnCloseRequest((WindowEvent event1) -> {
			closeEvent(stage, event1);
		});
		stage.show();
		MainController controller = loader.getController();
		controller.setData(player);		
		((Stage) (txtNickname.getScene().getWindow())).close();
	}

	private void showAlert() {
		Alert alert = new Alert(AlertType.ERROR, Strings.get("invalidNick"));
		alert.setHeaderText(null);
		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(Images.getIcon());
		alert.showAndWait();
	}
	
	private void closeEvent(Stage stage, WindowEvent event) {
		ButtonType yes = new ButtonType(Strings.get("yes"));
		ButtonType no = new ButtonType(Strings.get("no"));
		Alert alert = new Alert(AlertType.CONFIRMATION, Strings.get("exitConfirm"), yes, no);
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