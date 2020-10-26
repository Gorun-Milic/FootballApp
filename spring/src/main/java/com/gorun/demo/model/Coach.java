package com.gorun.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the coach database table.
 * 
 */
@Entity
@NamedQuery(name="Coach.findAll", query="SELECT c FROM Coach c")
public class Coach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int coachid;

	private int age;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	@Lob
	private byte[] img;

	private String imgurl;

	private String name;

	private String surname;

	//bi-directional many-to-one association to Coachnation
	@OneToMany(mappedBy="coach")
	private List<Coachnation> coachnations;

	public Coach() {
	}

	public int getCoachid() {
		return this.coachid;
	}

	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Coachnation> getCoachnations() {
		return this.coachnations;
	}

	public void setCoachnations(List<Coachnation> coachnations) {
		this.coachnations = coachnations;
	}

	public Coachnation addCoachnation(Coachnation coachnation) {
		getCoachnations().add(coachnation);
		coachnation.setCoach(this);

		return coachnation;
	}

	public Coachnation removeCoachnation(Coachnation coachnation) {
		getCoachnations().remove(coachnation);
		coachnation.setCoach(null);

		return coachnation;
	}

}