package br.edu.ifsc.ads.steam.ux.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

	private int numClicks;

	public MainController() {
		this.numClicks = 0;
	}

	@FXML
	Button btnSensitive;

	@FXML
	Label lblSensitive;

	public void sensitiveClick() {
		numClicks++;

		switch (numClicks) {
			case 1:
				lblSensitive.setText("Ouch!");
				break;
			case 2:
				lblSensitive.setText("Again?");
				break;
			case 3:
				lblSensitive.setText("Please, stop!");
				break;
			case 4:
				lblSensitive.setText("I died...");
				break;
			case 5:
				lblSensitive.setText("Just kidding.");
				break;
			default:
				lblSensitive.setText("Now I'm dead...");
				break;
		}
	}
}
