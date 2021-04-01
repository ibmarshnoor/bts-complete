package com.ibm.bug.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ibm.bug.entity.Bug;
import com.ibm.bug.repo.BugRepository;

class BugServiceTest {

	@Test
	void testCreateBug() {
		BugService bugService = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugService.setBugRepository(dummyRepo);
		Bug bug = new Bug();
		String bugId = bugService.createBug(bug);
		assertNotNull(bugId);
	}

//	@Test
//	void testGetBugs() {
//		BugService bugService = new BugService();
//		BugRepository dummyRepo = new DummyBugRepository();
//		bugService.setBugRepository(dummyRepo);
//		Bug bug = new Bug();
//		List<Bug> bugId = bugService.getBugs();
//		
//	}
//
//	@Test
//	void testUpdateBug() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetBug() {
//		fail("Not yet implemented");
//	}

}
