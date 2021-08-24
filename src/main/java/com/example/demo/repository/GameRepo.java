package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Game;

@RepositoryRestResource(collectionResourceRel="game",path="game")
public interface GameRepo extends JpaRepository<Game,Integer>
{
	
}
