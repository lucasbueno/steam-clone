package br.edu.ifsc.ads.steam.ux.controller;

import java.io.IOException;
import java.net.URL;

import br.edu.ifsc.ads.steam.properties.Strings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ProfileController {

	@FXML
	ComboBox<String> cbLanguage;
	
	private Stage mainStage;

	public void save() throws IOException {
		if(cbLanguage.getSelectionModel().getSelectedIndex() == 0)
			Strings.setBR();
		else
			Strings.setUS();
		URL url = getClass().getResource("../fxml/Main.fxml");
		Parent parent = (Parent) FXMLLoader.load(url, Strings.getBundle());
		Scene scene = new Scene(parent, 300, 600);
		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
		mainStage.setScene(scene);
		((Stage) (cbLanguage.getScene().getWindow())).close();
	}

	public void setData(Stage stage) {
		cbLanguage.getItems().addAll("pt-BR", "en-US");
		
		if(Strings.getLocale().equals("pt-BR"))
			cbLanguage.getSelectionModel().select(0);
		else
			cbLanguage.getSelectionModel().select(1);
		mainStage = stage;
	}
}