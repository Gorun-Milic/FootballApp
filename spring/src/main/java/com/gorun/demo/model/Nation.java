package com.gorun.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the nation database table.
 * 
 */
@Entity
@NamedQuery(name="Nation.findAll", query="SELECT n FROM Nation n")
public class Nation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nationid;

	@JsonIgnore
	@Lob
	private byte[] img;

	private String imgurl;

	private String name;

	@JsonIgnore
	//bi-directional many-to-one association to Coachnation
	@OneToMany(mappedBy="nation")
	private List<Coachnation> coachnations;

	@JsonIgnore
	//bi-directional many-to-one association to Playernation
	@OneToMany(mappedBy="nation")
	private List<Playernation> playernations;

	public Nation() {
	}

	public int getNationid() {
		return this.nationid;
	}

	public void setNationid(int nationid) {
		this.nationid = nationid;
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

	public List<Coachnation> getCoachnations() {
		return this.coachnations;
	}

	public void setCoachnations(List<Coachnation> coachnations) {
		this.coachnations = coachnations;
	}

	public Coachnation addCoachnation(Coachnation coachnation) {
		getCoachnations().add(coachnation);
		coachnation.setNation(this);

		return coachnation;
	}

	public Coachnation removeCoachnation(Coachnation coachnation) {
		getCoachnations().remove(coachnation);
		coachnation.setNation(null);

		return coachnation;
	}

	public List<Playernation> getPlayernations() {
		return this.playernations;
	}

	public void setPlayernations(List<Playernation> playernations) {
		this.playernations = playernations;
	}

	public Playernation addPlayernation(Playernation playernation) {
		getPlayernations().add(playernation);
		playernation.setNation(this);

		return playernation;
	}

	public Playernation removePlayernation(Playernation playernation) {
		getPlayernations().remove(playernation);
		playernation.setNation(null);

		return playernation;
	}

}