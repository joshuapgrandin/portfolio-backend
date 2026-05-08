INSERT INTO technology (name) VALUES
                                  ('Java'),
                                  ('Spring Boot'),
                                  ('PostgreSQL'),
                                  ('React'),
                                  ('TypeScript'),
                                  ('Tailwind CSS'),
                                  ('Flyway'),
                                  ('Docker');

INSERT INTO projects (name, description, status, github_url, livelink_url, thumbnail_url, featured)
VALUES (
           'Personal Portfolio',
           'A full stack personal portfolio website built with a React frontend and Java Spring Boot REST API backend. Features a live request stream dashboard, project showcase with technology stack display, and a PostgreSQL database managed with Flyway migrations.',
           'IN_PROGRESS',
           'https://github.com/joshua/portfolio',
           null,
           null,
           true
       );

INSERT INTO project_technology (project_id, technology_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6),
    (1, 7),
    (1, 8);