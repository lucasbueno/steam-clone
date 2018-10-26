package br.edu.ifsc.ads.steam;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.ads.steam.database.DB;
import br.edu.ifsc.ads.steam.entities.Game;
import br.edu.ifsc.ads.steam.entities.Genre;
import br.edu.ifsc.ads.steam.entities.Player;
import br.edu.ifsc.ads.steam.properties.Images;
import br.edu.ifsc.ads.steam.properties.Strings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

//		generateData();
		launch(args);
		DB.conn.close();
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL url = getClass().getResource("./ux/fxml/Login.fxml");
		Parent parent = (Parent) FXMLLoader.load(url, Strings.getBundle());
		Scene scene = new Scene(parent);
		scene.getStylesheets().add("/br/edu/ifsc/ads/steam/ux/css/bootstrap3.css");
		stage.setScene(scene);
		stage.setTitle(Strings.get("appName"));		
		stage.getIcons().add(Images.getIcon());
		stage.show();
	}	

	private static void generateData() {
		// players
		Player tyler = new Player("tyler");
		Player marla = new Player("marla");
		Player bigBob = new Player("robert");

		// genres
		Genre fixedShooter = new Genre("Fixed Shooter");
		Genre actionAdventure = new Genre("Action-adventure");

		// games
		List<Genre> spaceInvadersGenres = new ArrayList<Genre>();
		spaceInvadersGenres.add(fixedShooter);
		Game spaceInvaders = new Game("Space Invaders",
				" is an arcade game created by Tomohiro Nishikado and released in 1978. It was manufactured and sold by Taito in Japan, and licensed in the United States by the Midway division of Bally. Space Invaders is one of the earliest shooting games; the aim is to defeat waves of aliens with a laser to earn as many points as possible.",
				spaceInvadersGenres);

		List<Genre> metroidGenres = new ArrayList<Genre>();
		metroidGenres.add(actionAdventure);
		Game metroid = new Game("Metroid",
				"Metroid follows space-faring bounty hunter Samus Aran, who protects the galaxy from the Space Pirates and their attempts to harness the power of the parasitic Metroid creatures. Metroid combines the platforming of Super Mario Bros. and the adventure of The Legend of Zelda with a dark science fiction atmosphere and greater emphasis on nonlinear gameplay.",
				metroidGenres);

		// relations
		tyler.addFriend(marla);
		tyler.addFriend(bigBob);
		tyler.addGame(spaceInvaders);
		tyler.addGame(metroid);
		marla.addFriend(tyler);
		marla.addGame(spaceInvaders);
		bigBob.addFriend(tyler);
		bigBob.addGame(metroid);

		DB.conn.addGenre(actionAdventure);
		DB.conn.addGenre(fixedShooter);
		DB.conn.addGame(metroid);
		DB.conn.addGame(spaceInvaders);
		DB.conn.addPlayer(tyler);
		DB.conn.addPlayer(marla);
		DB.conn.addPlayer(bigBob);
	}
}