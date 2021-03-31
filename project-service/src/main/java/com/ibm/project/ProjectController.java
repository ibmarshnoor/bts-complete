
package com.ibm.project;

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

import com.ibm.project.entity.Project;
import com.ibm.project.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@PostMapping("/project")
	String createProject(@RequestBody @Valid Project project, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(project);
		return projectService.createProject(project);

	}

	/**
	 * method to get all projects
	 * 
	 * @return all projects
	 */
	@GetMapping("/project")
	List<Project> getProjects() {
		return projectService.getProjects();
	}

	@GetMapping("/project/{id}")
	Optional<Project> getProject(@PathVariable("id") String projectId) {
//		System.out.println(project);
		return projectService.getProject(projectId);
	}

	@PutMapping("/project/{id}")
	void updateProject(@RequestBody @Valid Project project, BindingResult bindingResult,
			@PathVariable("id") String projectId) {
		validateModel(bindingResult);
		System.out.println(projectId);
		project.setId(projectId);
		projectService.updateProject(project);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please retry");
		}
	}

}
