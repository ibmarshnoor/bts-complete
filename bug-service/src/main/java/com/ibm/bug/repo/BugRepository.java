package com.ibm.bug.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.bug.entity.Bug;
import com.ibm.bug.entity.STATUS;

public interface BugRepository extends MongoRepository<Bug, String> {
	
	List<Bug> findByNameIsContainingIgnoreCase(String bugName);
	List<Bug> findByStatus(STATUS bugStatus);
	List<Bug> findByStatusAndNameIsContainingIgnoreCase(STATUS bugStatus,String bugName);
}
