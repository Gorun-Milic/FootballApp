package com.gorun.demo.dto;

import org.springframework.web.multipart.MultipartFile;

public class PlayerDTO {
	
	private int playerid;
	private String name;
	private String surname;
	private int age;
	private int goals;
	private int assists;
	private String foot;
	private int height;
	private String dateofbirth;
	private String position;
	private String imgUrl;
	
	private int clubid;
	
	public PlayerDTO() {
		
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getClubid() {
		return clubid;
	}

	public void setClubid(int clubid) {
		this.clubid = clubid;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "PlayerDTO [playerid=" + playerid + ", name=" + name + ", surname=" + surname + ", age=" + age
				+ ", goals=" + goals + ", assists=" + assists + ", foot=" + foot + ", height=" + height
				+ ", dateofbirth=" + dateofbirth + ", position=" + position + "]";
	}
	
	

}
