package com.gorun.demo.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerid;

	private int age;

	private int assists;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String foot;

	private int goals;

	private int height;
	
	@Lob
	private byte[] img;

	private String imgurl;

	private String name;

	private String position;

	private String surname;

	//bi-directional many-to-one association to Club
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="clubid")
	private Club club;

	//bi-directional many-to-one association to Playerclub
	@JsonIgnore
	@OneToMany(mappedBy="player")
	private List<Playerclub> playerclubs;

	//bi-directional many-to-one association to Playernation
	@JsonIgnore
	@OneToMany(mappedBy="player")
	private List<Playernation> playernations;

	public Player() {
	}

	public int getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAssists() {
		return this.assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getFoot() {
		return this.foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}

	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public List<Playerclub> getPlayerclubs() {
		return this.playerclubs;
	}

	public void setPlayerclubs(List<Playerclub> playerclubs) {
		this.playerclubs = playerclubs;
	}

	public Playerclub addPlayerclub(Playerclub playerclub) {
		getPlayerclubs().add(playerclub);
		playerclub.setPlayer(this);

		return playerclub;
	}

	public Playerclub removePlayerclub(Playerclub playerclub) {
		getPlayerclubs().remove(playerclub);
		playerclub.setPlayer(null);

		return playerclub;
	}

	public List<Playernation> getPlayernations() {
		return this.playernations;
	}

	public void setPlayernations(List<Playernation> playernations) {
		this.playernations = playernations;
	}

	public Playernation addPlayernation(Playernation playernation) {
		getPlayernations().add(playernation);
		playernation.setPlayer(this);

		return playernation;
	}

	public Playernation removePlayernation(Playernation playernation) {
		getPlayernations().remove(playernation);
		playernation.setPlayer(null);

		return playernation;
	}

}