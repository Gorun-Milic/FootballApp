package com.gorun.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gorun.demo.model.Playernation;

public interface PlayernationRepo extends JpaRepository<Playernation, Integer> {
	
	@Query("from Playernation where playerid=?1")
	public List<Playernation> getPlayerNations(int playerid);
	
	@Transactional
	@Modifying
	@Query("delete from Playernation where player.playerid=?1")
	public void deletePlayernationByPlayer(int playerid);

}
