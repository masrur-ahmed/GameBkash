package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Player;

@RepositoryRestResource(collectionResourceRel="player",path="player")
public interface PlayerRepo extends JpaRepository<Player,Integer>
{
}
