package com.gorun.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gorun.demo.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer> {
	
	@Query("from Player where club.clubid=?1")
	List<Player> findByClubid(int clubid);
	
	@Query("from Player where name=?1 or surname=?2 or position=?3 or age=?4 or foot=?5 or height=?6")
	List<Player> searchPlayers(String name, String surname, String position, int age, String foot, int height);
}
