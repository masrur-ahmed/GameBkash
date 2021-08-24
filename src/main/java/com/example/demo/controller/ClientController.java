package com.example.demo.controller;


import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.example.demo.repository.ClientRepo;
import com.example.demo.repository.GameRepo;
import com.example.demo.entity.Client;
import com.example.demo.entity.Game;
import com.example.demo.entity.Player;
@RestController
public class ClientController {
	@Autowired
	ClientRepo repo;
	@Autowired
	GameRepo grepo;
	@PostMapping(path="onBoard")
	public int onBoardMethod(Client client)
	{	
		
		repo.save(client);
		return client.getClientID();
	}
	@PutMapping(path="newGameSession/{playerID}/{gameID}")
	public String newSessionPlayer(@PathVariable("playerID") int pid,@PathVariable("gameID") int gid ,@RequestBody  Client client, HttpServletRequest request, HttpSession session)
	{	
		int cl = onBoardMethod(client);
		Client c = repo.findById(cl).get();
		SessionCollector s = new SessionCollector();
		s.sessionCreated(request,session);
		c.setSessionID(s.getId());
		c.setPlayerID(pid);
		c.setGameID(gid);
		repo.save(c);
		return c.getSessionID();
	}
	@DeleteMapping("/endGameSession/{sessionID}")
	public String endGame(@PathVariable String sessionID) {
	
		System.out.println("here");
		Client a = repo.getSession(sessionID);
		
		repo.delete(a);
		return "deleted";
	}
	@GetMapping(path="/currentActiveSessions")
	public List<Client> ActiveSession()
	{
		 for(Client c : repo.findAll()) {
			 double mins = (SessionCollector.findTime(c.getSessionID()))/60000.0;
			 c.setMins(mins);
			 float gameCost= (float) (repo.getCost(c.getGameID())*1.0);
			 c.setCost(c.getMins()*gameCost);
			 repo.save(c);
		 }
		return repo.findAll();
			
	}
	
	@GetMapping("/generateBillForPlayer/{playerID}")
	public double getplayer(@PathVariable("playerID")int playerID)
	{
		for(Client c : repo.findAll()) {
			 double mins = (SessionCollector.findTime(c.getSessionID()))/60000.0;
			 c.setMins(mins);
			 float gameCost= (float) (repo.getCost(c.getGameID())*1.0);
			 c.setCost(c.getMins()*gameCost);
			 repo.save(c);
		 }
		return repo.getPlayerCost(playerID);
		
		
	}
	
	
}
