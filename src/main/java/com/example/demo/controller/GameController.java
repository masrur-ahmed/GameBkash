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

import com.example.demo.repository.GameRepo;
import com.example.demo.entity.Game;

@RestController
public class GameController
{
	@Autowired
	GameRepo repo;

	@DeleteMapping("/unregisterGame/{gameID}")
	public String deleteGame(@PathVariable int gameID) {
	
		System.out.println("here");
		Game a = repo.getById(gameID);
		
		repo.delete(a);
		return "deleted";
	}
	
	@PostMapping(path="/registerGame",consumes= {"application/json"})
	public int addGame(@RequestBody Game game)
	{	
		
		repo.save(game);
		return game.getGameID();
	}
	@GetMapping(path="/Games")
	public List<Game> getGames()
	{
		return repo.findAll();
			
	}
	
	@RequestMapping("/Game/{gameID}")
	public Optional<Game> getGame(@PathVariable("gameID")int gameID)
	{
		return repo.findById(gameID);
		
		
	}
}
