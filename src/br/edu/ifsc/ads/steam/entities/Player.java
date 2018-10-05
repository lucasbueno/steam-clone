package br.edu.ifsc.ads.steam.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Player {
	private String nickname;
	private Set<Player> friends;
	private Set<Game> games;

	public Player() {
	}

	public Player(String nickname) {
		super();
		this.nickname = nickname;
		emptyIni();
	}

	public Player(String nickname, Set<Player> friends, Set<Game> games) {
		super();
		this.nickname = nickname;
		this.friends = friends;
		this.games = games;
	}

	@SuppressWarnings("unchecked")
	public Player(String nickname, Set<?> set) {
		super();
		this.nickname = nickname;

		if (set == null || set.isEmpty()) {
			emptyIni();
			return;
		}

		if (set.iterator().next() instanceof Player) {
			this.friends = (Set<Player>) set;
			this.games = new LinkedHashSet<Game>();
		} else if (set.iterator().next() instanceof Game) {
			this.friends = new LinkedHashSet<Player>();
			this.games = (Set<Game>) set;
		} else {
			emptyIni();
		}
	}

	private void emptyIni() {
		this.friends = new LinkedHashSet<Player>();
		this.games = new LinkedHashSet<Game>();
	}

	@Id
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@ManyToMany
	public Set<Player> getFriends() {
		return friends;
	}

	public void setFriends(Set<Player> friends) {
		this.friends = friends;
	}

	@ManyToMany
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public void addFriend(Player player) {
		this.friends.add(player);
	}

	public void addGame(Game game) {
		this.games.add(game);
	}

	public void removeFriend(Player player) {
		this.friends.remove(player);
	}

	public void removeGame(Game game) {
		this.games.remove(game);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Player))
			return false;
		Player other = (Player) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}
}
