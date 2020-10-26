package com.gorun.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorun.demo.model.Stadium;

public interface StadiumRepo extends JpaRepository<Stadium, Integer> {

}
