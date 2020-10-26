package com.gorun.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gorun.demo.dao.StadiumRepo;
import com.gorun.demo.model.Stadium;


@Controller
public class StadiumController {
	
	@Autowired
	StadiumRepo repo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/stadiums")
	@ResponseBody
	public List<Stadium> getStadium() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/stadium/{stadiumId}")
	@ResponseBody
	public Optional<Stadium> getStadium(@PathVariable("stadiumId") int stadiumId) {
		return repo.findById(stadiumId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/stadium")
	@ResponseBody
	public Stadium addStadium(@RequestBody Stadium stadium) {
		repo.save(stadium);
		return stadium;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/stadium/{stadiumId}")
	@ResponseBody
	public String deleteStadium(@PathVariable("stadiumId") int stadiumId) {
		Optional<Stadium> s = repo.findById(stadiumId);
		if (s.isPresent()) {
			repo.delete(s.get());
			System.out.println("Deleted!");
			return "Deleted";
		}else {
			System.out.println("Not Deleted!");
			return "Not Deleted!";
		}	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/stadium")
	@ResponseBody
	public Stadium saveOrUpdateStadium(@RequestBody Stadium stadium) {
		Optional<Stadium> stadiumOptional = repo.findById(stadium.getStadiumid());
		Stadium s;
		if (!stadiumOptional.isEmpty()) {
			s = stadiumOptional.get();
		}else {
			s = new Stadium();
		}
		s.setName(stadium.getName());
		s.setCapacity(stadium.getCapacity());
		s.setImgurl(stadium.getImgurl());
		repo.save(s);
		return stadium;
	}
	

}
