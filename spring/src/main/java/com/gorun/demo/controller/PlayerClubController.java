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

import com.gorun.demo.dao.ClubRepo;
import com.gorun.demo.dao.PlayerClubRepo;
import com.gorun.demo.dao.PlayerRepo;
import com.gorun.demo.dto.PlayerclubDTO;
import com.gorun.demo.model.Club;
import com.gorun.demo.model.Nation;
import com.gorun.demo.model.Player;
import com.gorun.demo.model.Playerclub;

@Controller
public class PlayerClubController {
	
	@Autowired
	PlayerClubRepo repo;
	
	@Autowired
	PlayerRepo playerRepo;
	
	@Autowired
	ClubRepo clubRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/playerclubs")
	@ResponseBody
	public List<Playerclub> getPlayerCLubs() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/playerclub/{playerclubId}")
	@ResponseBody
	public Optional<Playerclub> getPlayerclub(@PathVariable("playerclubId") int playerclubId) {
		return repo.findById(playerclubId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/playerclub")
	@ResponseBody
	public int addPlayerClub(@RequestBody PlayerclubDTO playerclubDTO) {
		Optional<Player> player = playerRepo.findById(playerclubDTO.getPlayerid());
		Optional<Club> club = clubRepo.findById(playerclubDTO.getClubid());
		Playerclub pc = new Playerclub();
		if (!player.isEmpty()) {
			pc.setPlayer(player.get());
			if (!club.isEmpty()) {
				pc.setClub(club.get());
				repo.save(pc);
				return 1;
			}
		}
		return 0;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteplayerclub/{playerclubId}")
	@ResponseBody
	public String deletePlayerclub(@PathVariable("playerclubId") int playerclubId) {
		Optional<Playerclub> pc = repo.findById(playerclubId);
		if (pc.isPresent()) {
			repo.delete(pc.get());
			System.out.println("Deleted!");
			return "Deleted";
		}else {
			System.out.println("Not Deleted!");
			return "Not Deleted!";
		}	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/playerclub")
	@ResponseBody
	public  Playerclub saveOrUpdatePlayerclub(@RequestBody Playerclub playerclub) {
		System.out.println("llsadwddddddddddddddddddddddddddddddddd");
		repo.save(playerclub);
		return playerclub;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/remembered/{clubId}")
	@ResponseBody
	public List<Playerclub> getRememberdPlayers(@PathVariable("clubId") int clubId) {
		return repo.findByClubid(clubId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/isremembered")
	@ResponseBody
	public int getRememberdPlayers(@RequestBody PlayerclubDTO pc) {
		List<Playerclub> list = repo.findPlayerClub(pc.getClubid(), pc.getPlayerid());
		if (!list.isEmpty()) {
			return list.get(0).getPlayerclubid();
		}
		return 0;
	}
	
	
	
	
	public void deleteRememberedPlayer(int playerId) {
		repo.deletePlayerclubByPlayer(playerId);
	}
	

}
