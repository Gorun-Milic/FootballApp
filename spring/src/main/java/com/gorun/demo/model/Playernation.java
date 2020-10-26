package com.gorun.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the playernation database table.
 * 
 */
@Entity
@NamedQuery(name="Playernation.findAll", query="SELECT p FROM Playernation p")
public class Playernation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playernationid;

	//bi-directional many-to-one association to Nation
	@ManyToOne
	@JoinColumn(name="nationid")
	private Nation nation;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="playerid")
	private Player player;

	public Playernation() {
	}

	public int getPlayernationid() {
		return this.playernationid;
	}

	public void setPlayernationid(int playernationid) {
		this.playernationid = playernationid;
	}

	public Nation getNation() {
		return this.nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}