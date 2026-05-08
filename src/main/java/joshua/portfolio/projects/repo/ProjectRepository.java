package joshua.portfolio.projects.repo;

import joshua.portfolio.projects.enums.ProjectStatus;
import joshua.portfolio.projects.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {
    // Get all featured projects (true) ordered by newest.
    List<Projects> findAllByOrderByCreatedAtDesc();
    // Check if the name exists.
    boolean existsByNameIgnoreCase(String name);
    // Get featured by status
    @Query(value = "SELECT * FROM projects WHERE status = CAST(:status AS project_status)", nativeQuery = true)
    List<Projects> findAllByStatus(@Param("status") String status);
    // Get a project by name
    Optional<Projects> findByName(String name);
}
