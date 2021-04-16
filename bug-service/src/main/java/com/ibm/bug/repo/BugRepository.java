package com.ibm.bug.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.bug.entity.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {
	
	Optional<Bug> findByName(String bugName);

	
	
}
