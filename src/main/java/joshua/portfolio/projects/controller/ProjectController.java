package joshua.portfolio.projects.controller;


import joshua.portfolio.projects.enums.ProjectStatus;
import joshua.portfolio.projects.model.Projects;
import joshua.portfolio.projects.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/projects")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Projects>> getAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Projects> getProject(@PathVariable Long id)
    {
        return ResponseEntity.ok(projectService.findById(id));
    }

    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<Projects>> getProjectsByStatus(@PathVariable ProjectStatus status)
    {
        return ResponseEntity.ok(projectService.findAllByStatus(status));
    }
}
