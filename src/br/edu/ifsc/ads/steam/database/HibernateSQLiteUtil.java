package br.edu.ifsc.ads.steam.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.edu.ifsc.ads.steam.entities.Game;
import br.edu.ifsc.ads.steam.entities.Genre;
import br.edu.ifsc.ads.steam.entities.Player;

public class HibernateSQLiteUtil implements DBUtil {
	private static EntityManagerFactory dbFac;

	@Override
	public void addGenre(Genre genre) {
		add(genre);
	}

	@Override
	public Genre getGenre(String description) {
		EntityManager conn = getConn();
		Genre genre = conn.find(Genre.class, description);
		conn.close();
		return genre;
	}

	@SuppressWarnings("unchecked")
	public List<Genre> getGenres() {
		EntityManager conn = getConn();
		List<Genre> genres = conn.createQuery("from Genre").getResultList();
		conn.close();
		return genres;
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
		for (Game game : gameList)
			add(game);
	}

	@Override
	public Game getGame(String name) {
		EntityManager conn = getConn();
		Game game = conn.find(Game.class, name);
		conn.close();
		return game;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getGames() {
		EntityManager conn = getConn();
		List<Game> games = conn.createQuery("from Game").getResultList();
		conn.close();
		return games;
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
		EntityManager conn = getConn();
		Player player = conn.find(Player.class, name);
		conn.close();
		return player;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayers() {
		EntityManager conn = getConn();
		List<Player> players = conn.createQuery("from Player").getResultList();
		conn.close();
		return players;
	}

	@Override
	public void removePlayer(Player player) {
		remove(player);
	}

	@Override
	public void updateDB() {
		EntityManager conn = getConn();
		EntityTransaction transac = conn.getTransaction();
		transac.begin();
		transac.commit();
		conn.close();
	}

	@Override
	public void deadPool() {
		if (dbFac == null)
			return;
		if (!dbFac.isOpen())
			return;
		dbFac.close();
	}
	
	public void openPool() {
		if (dbFac == null)
			dbFac = Persistence.createEntityManagerFactory("SteamClone");
	}

	private EntityManager getConn() {
		openPool();
		return dbFac.createEntityManager();
	}

	private void add(Object object) {
		EntityManager conn = getConn();
		EntityTransaction transac = conn.getTransaction();
		transac.begin();
		conn.persist(object);
		transac.commit();
		conn.close();
	}

	private void remove(Object object) {
		EntityManager conn = getConn();
		EntityTransaction transac = conn.getTransaction();
		transac.begin();
		conn.remove(object);
		transac.commit();
		conn.close();
	}
}