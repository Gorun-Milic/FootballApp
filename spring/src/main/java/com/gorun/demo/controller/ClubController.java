package com.gorun.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gorun.demo.dao.ClubRepo;
import com.gorun.demo.dao.LeagueRepo;
import com.gorun.demo.dao.StadiumRepo;
import com.gorun.demo.dto.ClubDTO;
import com.gorun.demo.dto.SearchclubDTO;
import com.gorun.demo.model.Club;
import com.gorun.demo.model.League;
import com.gorun.demo.model.Stadium;

@Controller
public class ClubController {
	
	@Autowired
	ClubRepo repo;
	
	@Autowired
	LeagueRepo repoLeague;
	
	@Autowired
	StadiumRepo repoStadium;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/clubs")
	@ResponseBody
	public List<Club> getClubs() {
		System.out.println("aaa");
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/club/{clubId}")
	@ResponseBody
	public Optional<Club> getClub(@PathVariable("clubId") int clubId) {
		return repo.findById(clubId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/club")
	@ResponseBody
	public Club addClub(@RequestBody ClubDTO clubDTO) {
		System.out.println("RRRRRRRRREEEEEEEEEEEEEGGGGGGGGGGGGG");
		System.out.println(clubDTO);
		Club club = new Club();
		Optional<League> optL = repoLeague.findById(clubDTO.getLeagueid());
		Optional<Stadium> optS = repoStadium.findById(clubDTO.getStadiumid());
		if (!optL.isEmpty()) {
			System.out.println("USAAAAO LEAGUEEEE");
			club.setLeague(optL.get());
			System.out.println(optL.get());
		}
		if (!optS.isEmpty()) {
			System.out.println("USAAAAO STADIUM");
			club.setStadium(optS.get());
			System.out.println(optS.get());
		}
		club.setName(clubDTO.getName());
		club.setValue(clubDTO.getValue());
		club.setImgurl(clubDTO.getImgUrl());
		club.setPassword(clubDTO.getPassword());
		System.out.println(clubDTO.getImg());
		if (clubDTO.getImg()!=null) {
			System.out.println("SSSSSSSSSSSSSSSSLLLLLLLLLLLLLLLLLIIIIIIIIIIIIIIIKKKKKKKKKKKKAAAAAAAAAAAAAAA");
			club.setImg(clubDTO.getImg());
		}
		repo.save(club);
		return club;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/club/{clubId}")
	@ResponseBody
	public String deleteClub(@PathVariable("clubId") int clubId) {
		Optional<Club> c = repo.findById(clubId);
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
	@PutMapping("/club")
	@ResponseBody
	public Club saveOrUpdateClub(@RequestBody ClubDTO clubDTO) {
		System.out.println(clubDTO);
		Optional<Club> clubOpt = repo.findById(clubDTO.getClubid());
		Optional<League> optL = repoLeague.findById(clubDTO.getLeagueid());
		Optional<Stadium> optS = repoStadium.findById(clubDTO.getStadiumid());
		Club c;
		if (!clubOpt.isEmpty()) {
			c = clubOpt.get();
		}else {
			c = new Club();
		}
		if (!optL.isEmpty()) {
			System.out.println("USAAAAO LEAGUEEEE");
			c.setLeague(optL.get());
			System.out.println(optL.get());
		}
		if (!optS.isEmpty()) {
			System.out.println("USAAAAO STADIUM");
			c.setStadium(optS.get());
			System.out.println(optS.get());
		}
		c.setName(clubDTO.getName());
		c.setValue(clubDTO.getValue());
		c.setImgurl(clubDTO.getImgUrl());
		repo.save(c);
		return c;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	@ResponseBody
	public Club login(@RequestBody ClubDTO clubDTO) {
		System.out.println("LLLLLLLLLLLLLOOOOOOOOOOOOOOGGGGGGGGGGIIIIIIIIIIINNNNNNNNNNNNNN");
		System.out.println(clubDTO.getName() + " " + clubDTO.getPassword());
		List<Club> clubs = repo.login(clubDTO.getName(), clubDTO.getPassword()); 
		System.out.println(clubs);
		if (clubs.isEmpty()) {
			return null;
		}else {
			return clubs.get(0);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/searchclubs")
	@ResponseBody
	public List<Club> searchClubs(@RequestBody SearchclubDTO searchClub) {
		return repo.searchClubs(searchClub.getName(), searchClub.getValue(), searchClub.getLeagueid());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public Club addImage(@RequestParam(name = "myFile") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		int id = Integer.parseInt(file.getOriginalFilename());
		Optional<Club> c = repo.findById(id);
		Club club = c.get();
		try {
			club.setImg(file.getBytes());
			//club.setImgurl("data:image/jpeg;base64," + file.getBytes());
			repo.save(club);
			return club;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return club;
	}
	

}
