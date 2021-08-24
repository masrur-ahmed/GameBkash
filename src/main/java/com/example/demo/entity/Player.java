package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "player")
public class Player {
	private int playerID;
	private int cost; 
	private int clientID;
	private String playerName;
	private String phone; 
	private int balance;
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	@Column
	@ColumnDefault(value = "0")
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Column
	@ColumnDefault(value = "-1")
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	@Column
	@ColumnDefault(value = "'user'")
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Column
	@ColumnDefault(value = "'-1'")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column
	@ColumnDefault(value = "-1")
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
