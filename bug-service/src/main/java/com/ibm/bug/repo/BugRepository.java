package com.ibm.bug.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.bug.entity.Bug;
import com.ibm.bug.entity.STATUS;

public interface BugRepository extends MongoRepository<Bug, String> {
	
	List<Bug> findByNameIgnoreCase(String bugName);
	List<Bug> findByStatus(STATUS bugStatus);
	List<Bug> findByStatusAndNameIgnoreCase(STATUS bugStatus,String bugName);
}
