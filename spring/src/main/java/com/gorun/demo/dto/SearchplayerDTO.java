package com.gorun.demo.dto;

public class SearchplayerDTO {
	
	private String name;
	private String surname;
	private String position;
	private int age;
	private String foot;
	private int height;
	
	public SearchplayerDTO(String name, String surname, String position, int age, String foot, int height) {
		super();
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.age = age;
		this.foot = foot;
		this.height = height;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	@Override
	public String toString() {
		return "SearchplayerDTO [name=" + name + ", surname=" + surname + ", position=" + position + ", age=" + age
				+ ", foot=" + foot + ", height=" + height + "]";
	}
	
	
	
	

}
