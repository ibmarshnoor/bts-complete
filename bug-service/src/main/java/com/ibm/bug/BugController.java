package com.ibm.bug;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bug.entity.Bug;
import com.ibm.bug.entity.STATUS;
import com.ibm.bug.service.BugService;

@RestController
public class BugController {
	@Autowired
	BugService bugService;
	//test for Jenkins
	@PostMapping("/bug")
	String createBug(@RequestBody @Valid Bug bug, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(bug);
		return bugService.createBug(bug);

	}

	@GetMapping("/bug")
	List<Bug> getBugs() {
		return bugService.getBugs();

	}
//	//get by name
	@GetMapping("/bug/name/{name}")
	List<Bug> getBug(@PathVariable("name") String bugName) {
		//System.out.println(bug);
		return bugService.getBug(bugName);
	}
	//get by status
	@GetMapping("/bug/status/{status}")
	List<Bug> getBugByStatus(@PathVariable("status") STATUS bugStatus) {
		return bugService.getBugByStatus(bugStatus);
	}
	@GetMapping("/bug/search")
	List<Bug> getBugByStatusAndName(@RequestParam("status") STATUS bugStatus, @RequestParam("name") String bugName ) {
		return bugService.getBugByStatusAndName(bugStatus,bugName);
	}
	

	@PutMapping("/bug/{id}")
	void updateBug(@RequestBody @Valid Bug bug, BindingResult bindingResult, @PathVariable("id") String bugId) {
//		validateModel(bindingResult);
		System.out.println(bugId);
		bug.setId(bugId);
		bugService.updateBug(bug);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please retry");
		}
	}

}
