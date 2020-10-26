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

import com.gorun.demo.dao.NationRepo;
import com.gorun.demo.model.Nation;

@Controller
public class NationController {
	
	@Autowired
	NationRepo repo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/nations")
	@ResponseBody
	public List<Nation> getNation() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/nation/{nationId}")
	@ResponseBody
	public Optional<Nation> getNation(@PathVariable("nationId") int nationId) {
		return repo.findById(nationId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/nation")
	@ResponseBody
	public Nation addNation(@RequestBody Nation nation) {
		repo.save(nation);
		return nation;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/nation/{nationId}")
	@ResponseBody
	public String deleteNation(@PathVariable("nationId") int nationId) {
		Optional<Nation> n = repo.findById(nationId);
		if (n.isPresent()) {
			repo.delete(n.get());
			System.out.println("Deleted!");
			return "Deleted";
		}else {
			System.out.println("Not Deleted!");
			return "Not Deleted!";
		}	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/nation")
	@ResponseBody
	public  Nation saveOrUpdateNation(@RequestBody Nation nation) {
		System.out.println("llsadwddddddddddddddddddddddddddddddddd");
		repo.save(nation);
		return nation;
	}
	

}
