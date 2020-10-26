package com.gorun.demo.dto;

import javax.persistence.Lob;

public class ClubDTO {
	
	private int clubid;
	private String name;
	private int value;
	private int leagueid;
	private int stadiumid;
	private String imgUrl;
	private String password;
	
	@Lob
	private byte[] img;
	
	public ClubDTO() {
		
	}
	
	public ClubDTO(int clubid, String name, int value, int leagueid, int stadiumid, String imgUrl, String password, byte[] img) {
		super();
		this.clubid = clubid;
		this.name = name;
		this.value = value;
		this.leagueid = leagueid;
		this.stadiumid = stadiumid;
		this.imgUrl = imgUrl;
		this.password = password;
		this.img = img;
	}
	public int getClubid() {
		return clubid;
	}

	public void setClubid(int clubid) {
		this.clubid = clubid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getLeagueid() {
		return leagueid;
	}
	public void setLeagueid(int leagueid) {
		this.leagueid = leagueid;
	}
	public int getStadiumid() {
		return stadiumid;
	}
	public void setStadiumid(int stadiumid) {
		this.stadiumid = stadiumid;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ClubDTO [name=" + name + ", value=" + value + ", leagueId=" + leagueid + ", stadiumid=" + stadiumid
				+ ", imgUrl=" + imgUrl + "]";
	}

	
	
	
	
	

}
