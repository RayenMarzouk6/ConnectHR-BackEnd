package com.example.connecthr.Service;

import com.example.connecthr.Entity.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    List<Project> getAllProjects();

    Optional<Project> getProjectById(Integer id);

    Project saveProject(Project project);

    void deleteProject(Integer id);
}
