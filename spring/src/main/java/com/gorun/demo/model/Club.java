package com.gorun.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the club database table.
 * 
 */
@Entity
@NamedQuery(name="Club.findAll", query="SELECT c FROM Club c")
public class Club implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clubid;

	
	@Lob
	private byte[] img;

	private String imgurl;

	private String name;

	private String password;

	private int value;

	//bi-directional many-to-one association to League
	@ManyToOne
	@JoinColumn(name="leagueid")
	private League league;

	//bi-directional many-to-one association to Stadium
	@ManyToOne
	@JoinColumn(name="stadiumid")
	private Stadium stadium;

	//bi-directional many-to-one association to Player
	@JsonIgnore
	@OneToMany(mappedBy="club")
	private List<Player> players;

	//bi-directional many-to-one association to Playerclub
	@JsonIgnore
	@OneToMany(mappedBy="club")
	private List<Playerclub> playerclubs;

	public Club() {
	}

	public int getClubid() {
		return this.clubid;
	}

	public void setClubid(int clubid) {
		this.clubid = clubid;
	}

	public byte[] getImg() {
		return this.img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public League getLeague() {
		return this.league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Stadium getStadium() {
		return this.stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player addPlayer(Player player) {
		getPlayers().add(player);
		player.setClub(this);

		return player;
	}

	public Player removePlayer(Player player) {
		getPlayers().remove(player);
		player.setClub(null);

		return player;
	}

	public List<Playerclub> getPlayerclubs() {
		return this.playerclubs;
	}

	public void setPlayerclubs(List<Playerclub> playerclubs) {
		this.playerclubs = playerclubs;
	}

	public Playerclub addPlayerclub(Playerclub playerclub) {
		getPlayerclubs().add(playerclub);
		playerclub.setClub(this);

		return playerclub;
	}

	public Playerclub removePlayerclub(Playerclub playerclub) {
		getPlayerclubs().remove(playerclub);
		playerclub.setClub(null);

		return playerclub;
	}

}