package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game 
{
	
	private int gameID;
	private int maxConcurrentUsers;
	private int perMinuteCost;
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	@Column
	public int getMaxConcurrentUsers() {
		return maxConcurrentUsers;
	}
	public void setMaxConcurrentUsers(int maxConcurrentUsers) {
		this.maxConcurrentUsers = maxConcurrentUsers;
	}
	@Column
	public int getPerMinuteCost() {
		return perMinuteCost;
	}
	public void setPerMinuteCost(int perMinuteCost) {
		this.perMinuteCost = perMinuteCost;
	} 
	
	
	
}
