INSERT INTO projects (name, description, status, github_url, github_url_backend, livelink_url, thumbnail_url, featured, created_at)
VALUES (
           'Job Application Tracker',
           'A full stack job application tracking tool built to manage and monitor job applications through the hiring process. Features application status tracking, notes, and a dashboard overview built with React and Spring Boot.',
           'IN_PROGRESS',
           NULL,
           NULL,
           NULL,
           NULL,
           false,
           NOW()
       );

INSERT INTO project_technology (project_id, technology_id)
SELECT p.id, t.id
FROM projects p, technology t
WHERE p.name = 'Job Application Tracker'
  AND t.name IN ('Java', 'Spring Boot', 'PostgreSQL', 'React', 'TypeScript', 'Tailwind CSS', 'Flyway');