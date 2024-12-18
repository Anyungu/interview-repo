-- Insert Projects
-- Caution This was autogenerated to save on time

INSERT INTO Project (name, description) VALUES
('Project A', 'Description of Project A'),
('Project B', 'Description of Project B'),
('Project C', 'Description of Project C');


INSERT INTO Task (name, description, title, status, release_date, project_id) VALUES
('Task 1 for A', 'Description of Task 1 for Project A', 'Title 1', 'TO_DO', '2024-12-01', (SELECT id FROM Project WHERE name = 'Project A')),
('Task 2 for A', 'Description of Task 2 for Project A', 'Title 2', 'IN_PROGRESS', '2024-12-02', (SELECT id FROM Project WHERE name = 'Project A')),
('Task 3 for A', 'Description of Task 3 for Project A', 'Title 3', 'DONE', '2024-12-03', (SELECT id FROM Project WHERE name = 'Project A'));


INSERT INTO Task (name, description, title, status, release_date, project_id) VALUES
('Task 1 for B', 'Description of Task 1 for Project B', 'Title 1', 'TO_DO', '2024-12-01', (SELECT id FROM Project WHERE name = 'Project B')),
('Task 2 for B', 'Description of Task 2 for Project B', 'Title 2', 'IN_PROGRESS', '2024-12-02', (SELECT id FROM Project WHERE name = 'Project B'));

INSERT INTO Task (name, description, title, status, release_date, project_id) VALUES
('Task 1 for C', 'Description of Task 1 for Project C', 'Title 1', 'DONE', '2024-12-01', (SELECT id FROM Project WHERE name = 'Project C')),
('Task 2 for C', 'Description of Task 2 for Project C', 'Title 2', 'IN_PROGRESS', '2024-12-02', (SELECT id FROM Project WHERE name = 'Project C'));