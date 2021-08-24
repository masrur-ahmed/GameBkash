package com.example.demo.controller;


import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.PlayerRepo;
import com.example.demo.entity.Player;

@RestController
public class PlayerController
{
	@Autowired
	PlayerRepo repo;

	@DeleteMapping("/removePlayer/{playerID}")
	public String deleteplayer(@PathVariable int playerID) {
	
		System.out.println("here");
		Player a = repo.getById(playerID);
		
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping(path="/updatePlayer/{id}",consumes= {"application/json"})
	public Player updatePlayer(@PathVariable("id") int id ,@RequestBody Player player)
	{	
		
		Player newPlayer = repo.findById(id).get();
		newPlayer.setPlayerName(player.getPlayerName());
		newPlayer.setPhone(player.getPhone());
		newPlayer.setBalance(player.getBalance());
		repo.save(newPlayer);
		
		return newPlayer;
	}
	@PostMapping(path="/addPlayer")
	public int addplayer(Player player)
	{	
		
		repo.save(player);
		return player.getPlayerID();
	}
	@GetMapping(path="/getListOfPlayers")
	public List<Player> getplayers()
	{
		
		return repo.findAll();
			
	}
	
	@GetMapping("/getPlayerDetails/{playerID}")
	public Optional<Player> getplayer(@PathVariable("playerID")int playerID)
	{
		return repo.findById(playerID);
		
		
	}
}
