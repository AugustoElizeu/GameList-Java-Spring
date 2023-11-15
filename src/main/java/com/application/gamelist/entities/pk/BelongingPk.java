package com.application.gamelist.entities.pk;

import java.util.Objects;

import com.application.gamelist.entities.Game;
import com.application.gamelist.entities.GameList;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPk {
	
	@ManyToOne
	@JoinColumn(name="Game_Id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="GameList_Id")
	private GameList gameList;
	
	public BelongingPk() {
		
	}

	public BelongingPk(Game game, GameList gameList) {
		super();
		this.game = game;
		this.gameList = gameList;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getGameList() {
		return gameList;
	}

	public void setGameList(GameList gameList) {
		this.gameList = gameList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, gameList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPk other = (BelongingPk) obj;
		return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
	}
	
}
