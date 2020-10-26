package com.gorun.demo.dto;

public class PlayerNationDTO {
	
	private int nationid1;
	private int nationid2;
	private int playerid;
		
	public PlayerNationDTO(int nationid1, int nationid2, int playerid) {
		super();
		this.nationid1 = nationid1;
		this.nationid2 = nationid2;
		this.playerid = playerid;
	}
	
	public int getNationid1() {
		return nationid1;
	}
	public void setNationid1(int nationid1) {
		this.nationid1 = nationid1;
	}
	public int getNationid2() {
		return nationid2;
	}
	public void setNationid2(int nationid2) {
		this.nationid2 = nationid2;
	}
	public int getPlayerid() {
		return playerid;
	}
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	@Override
	public String toString() {
		return "PlayerNationDTO [nationid1=" + nationid1 + ", nationid2=" + nationid2 + ", playerid=" + playerid + "]";
	}
	
	
	
	

}
