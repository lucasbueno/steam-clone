package br.edu.ifsc.ads.steam.ux.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MainController {

	@FXML
	MenuBar menuBar;

	public void exit() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Tem certeza que deseja sair?", ButtonType.YES,
				ButtonType.CANCEL);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES)
			((Stage) (menuBar.getScene().getWindow())).close();

	}
}