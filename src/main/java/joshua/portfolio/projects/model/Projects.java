package joshua.portfolio.projects.model;

import jakarta.persistence.*;
import joshua.portfolio.projects.enums.ProjectStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 128, nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column(nullable = false, columnDefinition = "project_status")
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    @Column(name = "github_url", columnDefinition = "text")
    private String githubUrl;
    @Column(name = "github_url_backend")
    private String githubUrlBackend;
    @Column(name = "livelink_url", columnDefinition = "text")
    private String livelinkUrl;
    @Column(name = "thumbnail_url", columnDefinition = "text")
    private String thumbnailUrl;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean featured;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany()
    @JoinTable(
            name = "project_technology",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies;


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
