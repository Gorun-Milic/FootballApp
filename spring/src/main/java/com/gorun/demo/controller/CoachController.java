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

import com.gorun.demo.dao.CoachRepo;
import com.gorun.demo.model.Coach;



@Controller
public class CoachController {
	
	@Autowired
	CoachRepo repo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/coaches")
	@ResponseBody
	public List<Coach> getCoach() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/coach/{coachId}")
	@ResponseBody
	public Optional<Coach> getCoach(@PathVariable("coachId") int coachId) {
		return repo.findById(coachId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/coach")
	@ResponseBody
	public Coach addCoach(@RequestBody Coach coach) {
		repo.save(coach);
		return coach;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/coach/{coachId}")
	@ResponseBody
	public String deleteCoach(@PathVariable("coachId") int coachId) {
		Optional<Coach> c = repo.findById(coachId);
		if (c.isPresent()) {
			repo.delete(c.get());
			System.out.println("Deleted!");
			return "Deleted";
		}else {
			System.out.println("Not Deleted!");
			return "Not Deleted!";
		}	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/coach")
	@ResponseBody
	public Coach saveOrUpdateCoach(@RequestBody Coach coach) {
		System.out.println("llsadwddddddddddddddddddddddddddddddddd");
		Optional<Coach> coachOptional = repo.findById(coach.getCoachid());
		Coach c;
		if (!coachOptional.isEmpty()) {
			c = coachOptional.get();
		}else {
			c = new Coach();
		}
		c.setName(coach.getName());
		c.setAge(coach.getAge());
		c.setDateofbirth(coach.getDateofbirth());
		c.setImgurl(coach.getImgurl());
		repo.save(c);
		return c;
	}
	

}
