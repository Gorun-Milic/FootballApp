package com.gorun.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gorun.demo.dao.NationRepo;
import com.gorun.demo.dao.PlayerRepo;
import com.gorun.demo.dao.PlayernationRepo;
import com.gorun.demo.dto.PlayerNationDTO;
import com.gorun.demo.model.Nation;
import com.gorun.demo.model.Player;
import com.gorun.demo.model.Playernation;

@Controller
public class PlayerNationController {
	
	@Autowired
	PlayernationRepo repo;
	
	@Autowired
	PlayerRepo repoPlayer;
	
	@Autowired
	NationRepo repoNation;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/playernation")
	@ResponseBody
	public String addPlayerNation(@RequestBody PlayerNationDTO playernation) {
		if (playernation.getNationid1()!=0 && playernation.getPlayerid()!=0) {
			Optional<Player> optPlayer = repoPlayer.findById(playernation.getPlayerid());
			Optional<Nation> optNation1 = repoNation.findById(playernation.getNationid1());
			
			Player p = optPlayer.get();
			Nation n1 = optNation1.get();
			if (p!=null && n1!=null) {
				Playernation pn1 = new Playernation();
				pn1.setPlayer(p);
				pn1.setNation(n1);
				repo.save(pn1);
			}
		}
		if (playernation.getNationid2()!=0 && playernation.getPlayerid()!=0) {
			Optional<Player> optPlayer = repoPlayer.findById(playernation.getPlayerid());
			Optional<Nation> optNation2 = repoNation.findById(playernation.getNationid2());
			
			Player p = optPlayer.get();
			Nation n2 = optNation2.get();
			if (p!=null && n2!=null) {
				Playernation pn2 = new Playernation();
				pn2.setPlayer(p);
				pn2.setNation(n2);
				repo.save(pn2);
			}
		}
		return "Object added!";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/playernation/{playerid}")
	@ResponseBody
	public List<Nation> getPlayerNations(@PathVariable("playerid") int playerid) {
		System.out.println("\n ZASTAVE \n ZASTAVE");
		List<Nation> nations = new ArrayList<>();
		List<Playernation> listPlayernation = repo.getPlayerNations(playerid);
		
		for (Playernation pn: listPlayernation) {
			nations.add(pn.getNation());
		}
		
		System.out.println(nations);
		
		return nations;
		
	}
	
	public void deletePlayerWithNation(int playerId) {
		repo.deletePlayernationByPlayer(playerId);
	}

}
