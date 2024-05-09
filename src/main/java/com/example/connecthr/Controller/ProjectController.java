package com.example.connecthr.Controller; // Corrected package name case


import com.example.connecthr.Entity.Project;
import com.example.connecthr.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Changed from Controller to RestController for proper REST handling
@RequestMapping("/api/projects") // Base URL for project-related operations
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/getAllProjects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); // Fixed 'or else'
    }

    @PostMapping("/addProject")
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody Project updatedProject) {
        if (!projectRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Corrected syntax with parentheses
        }
        updatedProject.setProject_id(id); // Set ID for update
        Project savedProject = projectRepository.save(updatedProject);
        return ResponseEntity.ok(savedProject); // Return the updated project
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        if (!projectRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Corrected parentheses and if-statement
        }
        projectRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // No content on successful delete
    }
}
