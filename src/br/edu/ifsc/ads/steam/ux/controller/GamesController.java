package br.edu.ifsc.ads.steam.ux.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class GamesController {
	
	private Label lblGame;
	
	@FXML
	ComboBox<String> cbGames;
	
	public void save() {
		lblGame.setText(cbGames.getSelectionModel().getSelectedItem());
	}
	
	public void setData(Label lblGame) {
		this.lblGame = lblGame;
		
		cbGames.getItems().addAll("tetris", "lol");
		
		cbGames.getSelectionModel().select(0);
	}
}