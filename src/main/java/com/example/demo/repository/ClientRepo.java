package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Client;

@RepositoryRestResource(collectionResourceRel="client",path="client")
public interface ClientRepo extends JpaRepository<Client,Integer>
{
	@Query(value = "Select * from client where sessionID = ?1", nativeQuery = true)
	Client getSession(String sessionID);
	@Query(value = " Select  SUM(cost)FROM client where playerID = ?1", nativeQuery = true)
	double getPlayerCost(int playerID);
	@Query(value = "Select  PER_MINUTE_COST from game where gameID = ?1", nativeQuery = true)
	int getCost(int gameID);
}
