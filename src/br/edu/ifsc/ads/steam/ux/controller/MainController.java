package br.edu.ifsc.ads.steam.ux.controller;

import org.controlsfx.control.WorldMapView;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MainController {

	@FXML
	MenuBar menuBar;
	
	@FXML
	WorldMapView map;

	public void exit() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Tem certeza que deseja sair?", ButtonType.YES,
				ButtonType.CANCEL);
		alert.showAndWait();

		if (alert.getResult() == ButtonType.YES)
			((Stage) (menuBar.getScene().getWindow())).close();

	}

	public void zoomIn() {
		map.setZoomFactor(map.getZoomFactor()+0.5);
	}

	public void zoomOut() {
		map.setZoomFactor(map.getZoomFactor()-0.5);
	}
}