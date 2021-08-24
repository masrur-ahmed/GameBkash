package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "client")
public class Client {
	private int clientID;
	private String sessionID;
	private int playerID; 
	private double mins;
	private int gameID;
	private double cost;
	@Column
	@ColumnDefault(value = "0")
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	@Column
	@ColumnDefault(value = "0")
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	@Column
	@ColumnDefault(value = "0")
	public double getMins() {
		return this.mins;
	}
	public void setMins(double mins) {
		this.mins = mins;
	}
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	@Column
	@ColumnDefault(value = "0")
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", sessionID=" + sessionID + "]";
	}
	@Column
	@ColumnDefault(value = "0")
	public double getCost() {
		return cost;
	}
	public void setCost(double d) {
		this.cost = d;
	} 
	
}
