package com.gorun.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorun.demo.model.League;

public interface LeagueRepo extends JpaRepository<League, Integer> {

}
