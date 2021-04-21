
package com.ibm.bug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bug.entity.Bug;
import com.ibm.bug.entity.STATUS;
import com.ibm.bug.repo.BugRepository;

@Service
public class BugService {

	@Autowired
	BugRepository bugRepository;

	public String createBug(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}
	public List<Bug> getBug() {
		return bugRepository.findAll();
	}


	public void updateBug(Bug bug) {
		STATUS status = bug.getStatus();
		Optional<Bug> oldBug = bugRepository.findById(bug.getId());
		oldBug.ifPresent(oldbug -> {
			STATUS oldstatus = oldbug.getStatus();
			if (oldstatus == STATUS.NEW) {
				if (!(status == STATUS.ASSIGNED || status == STATUS.NEW)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if (oldstatus == STATUS.ASSIGNED) {
				if (!(status == STATUS.OPEN)) {
					throw new IllegalArgumentException("Status should be opened");
				}
			}
			if (oldstatus == STATUS.OPEN) {
				if (!(status == STATUS.FIXED)) {
					throw new IllegalArgumentException("Status should be fixed");
				}
			}
			if (oldstatus == STATUS.DEFERRED) {
				if (!(status == STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if (oldstatus == STATUS.DUPLICATE) {
				if (!(status == STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if (oldstatus == STATUS.REJECTED) {
				if (!(status == STATUS.CLOSED)) {
					throw new IllegalArgumentException("Status is Closed");
				}
			}
			if (oldstatus == STATUS.NOT_A_BUG) {
				if (!(status == STATUS.CLOSED)) {
					throw new IllegalArgumentException("Status is Closed");
				}
			}
			if (oldstatus == STATUS.FIXED) {
				if (!(status == STATUS.PENDING_RETEST)) {
					throw new IllegalArgumentException("Status should be Pending-Retest state");

				}
			}
			if (oldstatus == STATUS.PENDING_RETEST) {
				if (!(status == STATUS.REOPEN) || (status == STATUS.VERIFIED)) {
					throw new IllegalArgumentException("Status should be ropened");
				}
			}
			if (oldstatus == STATUS.REOPEN) {
				if (!(status == STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if (oldstatus == STATUS.VERIFIED) {
				if (!(status == STATUS.CLOSED)) {
					throw new IllegalArgumentException("Status should be closed");
				}
			}
		});
		bugRepository.save(bug);

	}

	public List<Bug> getBug(String bugName) {
		return bugRepository.findByNameIgnoreCase(bugName);
	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public BugRepository getBugRepository() {
		return bugRepository;
	}

	public List<Bug> getBugByStatus(STATUS bugStatus) {
		return bugRepository.findByStatus(bugStatus);
	}
	public List<Bug> getBugByStatusAndName(STATUS bugStatus,String bugName) {
		return bugRepository.findByStatusAndNameIgnoreCase(bugStatus,bugName);
	}

}
=======
package com.ibm.bug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bug.entity.Bug;
import com.ibm.bug.entity.STATUS;
import com.ibm.bug.repo.BugRepository;

@Service
public class BugService {

	@Autowired
	BugRepository bugRepository;

	public String createBug(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}
	
	public List<Bug> getBug() {
		return bugRepository.findAll();
	}

	public void updateBug(Bug bug) {
		STATUS status=bug.getStatus();
		Optional <Bug> oldBug=bugRepository.findById(bug.getId());
		oldBug.ifPresent(oldbug->{
			STATUS oldstatus=oldbug.getStatus();
			if(oldstatus==STATUS.NEW) {
				if(!(status==STATUS.ASSIGNED || status==STATUS.NEW)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if(oldstatus==STATUS.ASSIGNED) {
				if(!(status==STATUS.OPEN)) {
					throw new IllegalArgumentException("Status should be opened");
				}
			}
			if(oldstatus==STATUS.OPEN) {
				if(!(status==STATUS.FIXED)) {
					throw new IllegalArgumentException("Status should be fixed");
				}
			}
			if(oldstatus==STATUS.DEFERRED) {
				if(!(status==STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if(oldstatus==STATUS.DUPLICATE) {
				if(!(status==STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if(oldstatus==STATUS.REJECTED) {
				if(!(status==STATUS.CLOSED)) {
					throw new IllegalArgumentException("Status is Closed");
				}
			}
			if(oldstatus==STATUS.NOT_A_BUG) {
				if(!(status==STATUS.CLOSED)) {
					throw new IllegalArgumentException("Status is Closed");
				}
			}
			if(oldstatus==STATUS.FIXED) {
				if(!(status==STATUS.PENDING_RETEST)) {
					throw new IllegalArgumentException("Status should be Pending-Retest state");
				}
			}
			if(oldstatus==STATUS.PENDING_RETEST) {
				if(!(status==STATUS.REOPEN)|| (status==STATUS.VERIFIED)) {
					throw new IllegalArgumentException("Status should be ropened");
				}
			}
			if(oldstatus==STATUS.REOPEN) {
				if(!(status==STATUS.ASSIGNED)) {
					throw new IllegalArgumentException("Status should be assigned");
				}
			}
			if(oldstatus==STATUS.VERIFIED) {
				if(!(status==STATUS.CLOSED)) {
					throw new IllegalArgumentException("Status should be closed");
				}
			}
		});
		bugRepository.save(bug);
	}

	public Optional<Bug> getBug(String bugName) {
		return bugRepository.findByName(bugName);
	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public BugRepository getBugRepository() {
		return bugRepository;
	}
	
}
