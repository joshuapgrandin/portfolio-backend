CREATE TYPE project_status AS ENUM ('IN_PROGRESS', 'COMPLETED');

CREATE TABLE projects (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL,
    description TEXT,
    status project_status NOT NULL,
    github_url TEXT,
    livelink_url TEXT,
    thumbnail_url TEXT,
    featured BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE technology (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE project_technology (
    project_id BIGINT NOT NULL REFERENCES projects(id) ON DELETE CASCADE,
    technology_id BIGINT NOT NULL REFERENCES technology(id) ON DELETE CASCADE,
    PRIMARY KEY (project_id, technology_id)
)

