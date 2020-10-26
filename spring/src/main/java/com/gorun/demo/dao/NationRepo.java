package com.gorun.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorun.demo.model.Nation;

public interface NationRepo extends JpaRepository<Nation, Integer> {

}
