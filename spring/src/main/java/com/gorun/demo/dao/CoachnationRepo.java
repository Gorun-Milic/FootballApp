package com.gorun.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorun.demo.model.Coachnation;

public interface CoachnationRepo extends JpaRepository<Coachnation, Integer> {

}
