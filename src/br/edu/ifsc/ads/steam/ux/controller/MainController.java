package br.edu.ifsc.ads.steam.ux.controller;

import java.io.IOException;
import java.net.URL;

import br.edu.ifsc.ads.steam.properties.Images;
import br.edu.ifsc.ads.steam.properties.Strings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MainController {

	@FXML
	MenuBar menuBar;
	
	@FXML
	Label lblGame;

	public void exit() {
		ButtonType yes = new ButtonType(Strings.get("yes"));
		ButtonType no = new ButtonType(Strings.get("no"));
		Alert alert = new Alert(AlertType.CONFIRMATION, Strings.get("exitConfirm"), yes, no);
		alert.setTitle(Strings.get("exit"));
		alert.setHeaderText(null);
		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(Images.getIcon());
		alert.showAndWait();

		if (alert.getResult() == yes)
			((Stage) (menuBar.getScene().getWindow())).close();
	}

	public void openProfile() throws IOException {
		URL url = getClass().getResource("../fxml/Profile.fxml");
		FXMLLoader loader = new FXMLLoader(url, Strings.getBundle());
		Parent root = loader.load();
		ProfileController controller = loader.getController();
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(Strings.get("profile"));
		stage.getIcons().add(Images.getIcon());
		stage.show();
		controller.setData((Stage) (menuBar.getScene().getWindow()));
	}
	
	public void openGames() throws IOException {
		URL url = getClass().getResource("../fxml/Games.fxml");
		FXMLLoader loader = new FXMLLoader(url, Strings.getBundle());
		Parent root = loader.load();
		GamesController controller = loader.getController();
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle(Strings.get("games"));
		stage.getIcons().add(Images.getIcon());
		stage.show();
		controller.setData(lblGame);
	}
}