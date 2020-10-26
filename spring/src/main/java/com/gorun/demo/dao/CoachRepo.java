package com.gorun.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorun.demo.model.Coach;

public interface CoachRepo extends JpaRepository<Coach, Integer> {

}
