package com.gorun.demo.dto;

public class PlayerclubDTO {
	
	private int playerclubid;
	private int playerid;
	private int clubid;
	
	public PlayerclubDTO() {
		
	}
	
	public PlayerclubDTO(int playerclubid, int playerid, int clubid) {
		this.playerclubid = playerclubid;
		this.playerid = playerid;
		this.clubid = clubid;
	}

	public int getPlayerclubid() {
		return playerclubid;
	}

	public void setPlayerclubid(int playerclubid) {
		this.playerclubid = playerclubid;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public int getClubid() {
		return clubid;
	}

	public void setClubid(int clubid) {
		this.clubid = clubid;
	}

	@Override
	public String toString() {
		return "PlayerclubDTO [playerclubid=" + playerclubid + ", playerid=" + playerid + ", clubid=" + clubid + "]";
	}
	
	
	
}
