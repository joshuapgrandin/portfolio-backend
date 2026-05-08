package joshua.portfolio.projects.service;

import joshua.portfolio.exceptions.custom.ProjectNotFoundException;
import joshua.portfolio.projects.enums.ProjectStatus;
import joshua.portfolio.projects.model.Projects;
import joshua.portfolio.projects.repo.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Projects> findAll() {
        return projectRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Projects> findAllByStatus(ProjectStatus status) {
        return projectRepository.findAllByStatus(status.name());
    }

    public Projects findById(Long id)
    {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
    }
}
