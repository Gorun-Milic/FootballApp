package com.gorun.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the playerclub database table.
 * 
 */
@Entity
@NamedQuery(name="Playerclub.findAll", query="SELECT p FROM Playerclub p")
public class Playerclub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerclubid;

	//bi-directional many-to-one association to Club
	@ManyToOne
	@JoinColumn(name="clubid")
	private Club club;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="playerid")
	private Player player;

	public Playerclub() {
	}

	public int getPlayerclubid() {
		return this.playerclubid;
	}

	public void setPlayerclubid(int playerclubid) {
		this.playerclubid = playerclubid;
	}

	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}