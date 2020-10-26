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

import com.gorun.demo.dao.LeagueRepo;
import com.gorun.demo.model.League;

@Controller
public class LeagueController {
	
	@Autowired
	LeagueRepo repo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/leagues")
	@ResponseBody
	public List<League> getLeague() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/league/{leagueId}")
	@ResponseBody
	public Optional<League> getLeague(@PathVariable("leagueId") int leagueId) {
		return repo.findById(leagueId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/league")
	@ResponseBody
	public League addLeague(@RequestBody League league) {
		repo.save(league);
		return league;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/league/{leagueId}")
	@ResponseBody
	public String deleteLeague(@PathVariable("leagueId") int leagueId) {
		Optional<League> l = repo.findById(leagueId);
		if (l.isPresent()) {
			repo.delete(l.get());
			System.out.println("Deleted!");
			return "Deleted";
		}else {
			System.out.println("Not Deleted!");
			return "Not Deleted!";
		}	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/league")
	@ResponseBody
	public League saveOrUpdateLeague(@RequestBody League league) {
		Optional<League> leagueOptional = repo.findById(league.getLeagueid());
		League l;
		if (!leagueOptional.isEmpty()) {
			l = leagueOptional.get();
		}else {
			l = new League();
		}
		l.setName(league.getName());
		l.setImgurl(league.getImgurl());
		repo.save(l);
		return l;
	}
	

}
