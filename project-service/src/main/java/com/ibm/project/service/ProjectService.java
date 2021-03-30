package com.ibm.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.project.entity.Project;
import com.ibm.project.repo.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	public String getProject(Project project) {
		return "project1";
	}

	public void updateProject(Project project) {
		projectRepository.save(project);
	}

	public Optional<Project> getProject(String projectId) {
		return projectRepository.findById(projectId);
	}

}
