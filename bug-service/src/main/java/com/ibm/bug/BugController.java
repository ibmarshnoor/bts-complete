package com.ibm.bug;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bug.entity.Bug;
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

	@GetMapping("/bug/{name}")
	Optional<Bug> getBug(@PathVariable("name") String bugName) {
//		System.out.println(bug);
		return bugService.getBug(bugName);
	}

	@PutMapping("/bug/{id}")
	void updateBug(@RequestBody @Valid Bug bug, BindingResult bindingResult, @PathVariable("id") String bugId) {
		validateModel(bindingResult);
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