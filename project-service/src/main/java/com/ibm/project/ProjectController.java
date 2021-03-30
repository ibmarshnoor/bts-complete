package com.ibm.project;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.project.entity.Project;
import com.ibm.project.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@GetMapping("/project/{id}")
	String getProject(Project project) {
		System.out.println(project);
		return projectService.getProject(project);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please retry");
		}
	}

	@PutMapping("/project/{id}")
	void updateProject(@RequestBody @Valid Project project, BindingResult bindingResult,
			@PathVariable("id") String projectId) {
		validateModel(bindingResult);
		System.out.println(projectId);
		projectService.updateProject(project);
	}

}
