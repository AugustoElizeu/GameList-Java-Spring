package com.application.gamelist.entities;

import java.io.Serializable;
import java.util.Objects;

import com.application.gamelist.entities.pk.BelongingPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Belongings")
public class Belonging implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BelongingPk id = new BelongingPk();
	private Integer position;
	private Float desconto;
	
	public Belonging() {
		
	}

	public Belonging(Game game,GameList list, Integer position, Float desconto) {
		super();
		id.setGame(game);
		id.setGameList(list);
		this.position = position;
		this.desconto = desconto;
	}

	public BelongingPk getId() {
		return id;
	}

	public void setId(BelongingPk id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Float getDesconto() {
		return desconto;
	}

	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Belonging [id=" + id + ", position=" + position + ", desconto=" + desconto + "]";
	}
	
	
	
}
