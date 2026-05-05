CREATE TABLE projects {
    id BIGSERIAL PRIMARY KEY,
    slug VARCHAR(64) UNIQUE NOT NULL,
    name VARCHAR(128) NOT NULL,
    tagline VARCHAR(256),
    description TEXT,
    status VARCHAR(16) NOT NULL,
    stack TEXT[],
    created_at TIMESTAMP DEFAULT NOW(),

};

INSERT INTO projects (slug, name, tagline, description, status, stack) VALUES
    (
        'finance-tracker',
        'Finance Tracker',
        'A SaaS application to track personal finances',
        'Finance Tracker is a web application that helps users manage their personal finances. It allows users to track their income, expenses, and budgets. The application provides insights and reports to help users make informed financial decisions.',
        'active',
        ARRAY['JavaScript', 'Java', 'React', 'PostgreSQL', 'Spring Boot']
    );


