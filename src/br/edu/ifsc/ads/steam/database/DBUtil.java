package br.edu.ifsc.ads.steam.database;

import java.util.List;

import br.edu.ifsc.ads.steam.entities.*;

public interface DBUtil {
	
	// Developer
	public void addDeveloper(Developer dev);
	public void addDevelopers(List<Developer> devList);
	public Developer getDeveloper(String name);
	public List<Developer> getDevelopers();
	public void removeDeveloper(Developer dev);
	
	// Game
	public void addGame(Game game);
	public void addGames(List<Game> gameList);
	public Game getGame(String name);
	public List<Game> getGames();
	public void removeGame(Game game);
	
	// Genre
	public void addGenre(Genre genre);
	public Genre getGenre(String description);
	public List<Genre> getGenres();
	public void removeGenre(Genre genre);
	
	// Player
	public void addPlayer(Player player);
	public Player getPlayer(String nickname);
	public List<Player> getPlayers();
	public void removePlayer(Player player);

	// Common
	public void updateDB();	
	public void close();
}
