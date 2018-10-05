package br.edu.ifsc.ads.steam.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.edu.ifsc.ads.steam.entities.Developer;
import br.edu.ifsc.ads.steam.entities.Game;
import br.edu.ifsc.ads.steam.entities.Genre;
import br.edu.ifsc.ads.steam.entities.Player;

public class HibernateSQLiteUtil implements DBUtil {
	private static EntityManager db;

	@Override
	public void addDeveloper(Developer dev) {
		add(dev);
	}
	
	@Override
	public void addDevelopers(List<Developer> devList) {
		for(Developer dev : devList)
			add(dev);
	}

	@Override
	public Developer getDeveloper(String name) {
		return getDB().find(Developer.class, name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Developer> getDevelopers() {
		return getDB().createQuery("from Developer").getResultList();
	}

	@Override
	public void removeDeveloper(Developer dev) {
		remove(dev);
	}

	@Override
	public void addGenre(Genre genre) {
		add(genre);
	}

	@Override
	public Genre getGenre(String description) {
		return getDB().find(Genre.class, description);
	}

	@SuppressWarnings("unchecked")
	public List<Genre> getGenres() {
		return getDB().createQuery("from Genre").getResultList();
	}

	@Override
	public void removeGenre(Genre genre) {
		remove(genre);
	}

	@Override
	public void addGame(Game game) {
		add(game);
	}
	
	@Override
	public void addGames(List<Game> gameList) {
		for(Game game : gameList)
			add(game);
	}

	@Override
	public Game getGame(String name) {
		return getDB().find(Game.class, name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getGames() {
		return getDB().createQuery("from Game").getResultList();
	}

	@Override
	public void removeGame(Game game) {
		remove(game);
	}

	@Override
	public void addPlayer(Player player) {
		add(player);
	}

	@Override
	public Player getPlayer(String name) {
		return getDB().find(Player.class, name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers() {
		return getDB().createQuery("from Player").getResultList();
	}

	@Override
	public void removePlayer(Player player) {
		remove(player);
	}

	@Override
	public void updateDB() {
		EntityTransaction transac = getDB().getTransaction();
		transac.begin();
		transac.commit();
	}

	@Override
	public void close() {
		if (db == null)
			return;
		if (!db.isOpen())
			return;

		db.close();
	}

	private EntityManager getDB() {
		if (db == null)
			db = Persistence.createEntityManagerFactory("Hibernate101PU").createEntityManager();
		return db;
	}

	private void add(Object object) {
		EntityTransaction transaction = getDB().getTransaction();
		transaction.begin();
		getDB().persist(object);
		transaction.commit();
	}

	private void remove(Object object) {
		EntityTransaction transac = getDB().getTransaction();
		transac.begin();
		getDB().remove(object);
		transac.commit();
	}

}
