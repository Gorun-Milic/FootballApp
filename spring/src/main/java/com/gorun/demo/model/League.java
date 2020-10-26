package com.gorun.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the league database table.
 * 
 */
@Entity
@NamedQuery(name="League.findAll", query="SELECT l FROM League l")
public class League implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int leagueid;

	@JsonIgnore
	@Lob
	private byte[] img;

	private String imgurl;

	private String name;

	//bi-directional many-to-one association to Club
	@JsonIgnore
	@OneToMany(mappedBy="league")
	private List<Club> clubs;

	public League() {
	}
	
	@JsonCreator
	public League (@JsonProperty("leagueid") int leagueid ) {
	    this.leagueid = leagueid;
	}


	public int getLeagueid() {
		return this.leagueid;
	}

	public void setLeagueid(int leagueid) {
		this.leagueid = leagueid;
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

	public List<Club> getClubs() {
		return this.clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

	public Club addClub(Club club) {
		getClubs().add(club);
		club.setLeague(this);

		return club;
	}

	public Club removeClub(Club club) {
		getClubs().remove(club);
		club.setLeague(null);

		return club;
	}

}