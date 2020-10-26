package com.gorun.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gorun.demo.model.Playerclub;

public interface PlayerClubRepo extends JpaRepository<Playerclub, Integer> {
	
	@Query("from Playerclub where club.clubid=?1")
	public List<Playerclub> findByClubid(int clubid);
	
	@Query("from Playerclub where club.clubid=?1 and player.playerid=?2")
	public List<Playerclub> findPlayerClub(int clubid, int playerid);
	
	@Transactional
	@Modifying
	@Query("delete from Playerclub where player.playerid=?1")
	public void deletePlayerclubByPlayer(int playerid);
}
