package com.gorun.demo.dto;

public class SearchclubDTO {
	
	private String name;
	private int value;
	private int leagueid;
	
	public SearchclubDTO(String name, int value, int leagueid) {
		super();
		this.name = name;
		this.value = value;
		this.leagueid = leagueid;
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

	public void setLeagueid(int leaguid) {
		this.leagueid = leaguid;
	}

	@Override
	public String toString() {
		return "SearchclubDTO [name=" + name + ", value=" + value + ", leaguid=" + leagueid + "]";
	}
	
	

}
