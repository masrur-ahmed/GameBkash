package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Player;
@RepositoryRestResource(collectionResourceRel="session",path="session")
public interface SessionRepo extends JpaRepository<Player,Integer> {

}
