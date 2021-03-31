package com.ibm.bug.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bug.entity.Bug;
import com.ibm.bug.repo.BugRepository;
@Service
public class BugService {
	
	@Autowired
	BugRepository bugRepository;
	public String createBug(Bug bug) {
		Bug savedBug=bugRepository.save(bug);
		return savedBug.getId();
	}
	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}
	
}
