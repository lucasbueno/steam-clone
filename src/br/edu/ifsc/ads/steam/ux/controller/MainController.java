package br.edu.ifsc.ads.steam.ux.controller;

import br.edu.ifsc.ads.steam.properties.Strings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MainController {

	@FXML
	MenuBar menuBar;
	
	@FXML
	Button btnLocale;

	public void exit() {
		ButtonType yes = new ButtonType(Strings.get("yes"));
		ButtonType no = new ButtonType(Strings.get("no"));
		Alert alert = new Alert(AlertType.CONFIRMATION, Strings.get("exitConfirm"), yes,
				no);
		alert.setTitle(Strings.get("alertDialog"));
		alert.setHeaderText(null);
		alert.showAndWait();

		if (alert.getResult() == yes)
			((Stage) (menuBar.getScene().getWindow())).close();
	}
	
	public void changeLocale() {
		if(Strings.getLocale().equals("en-US")) {
			btnLocale.setText("en-US");
			Strings.setBR();
		}else {
			btnLocale.setText("pt-BR");
			Strings.setUS();
		}
	}
}