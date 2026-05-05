package joshua.portfolio.projects;

import jakarta.persistence.*;
import joshua.portfolio.projects.util.StringArrayConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 64, nullable = false)
    private String slug;
    @Column(length = 128, nullable = false)
    private String name;
    @Column(length = 256)
    private String tagline;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(length = 16, nullable = false)
    private String status;
    @Convert(converter = StringArrayConverter.class)
    private String[] stack;
    private LocalDateTime createdAt;
}
