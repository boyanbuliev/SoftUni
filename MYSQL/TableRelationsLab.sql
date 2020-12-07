CREATE TABLE mountains(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30));

CREATE TABLE peaks(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
mountain_id INT NOT NULL,
CONSTRAINT fk_peaks_mountains FOREIGN KEY (mountain_id) REFERENCES mountains(id));

SELECT v.driver_id, v.vehicle_type, concat(c.first_name, ' ', c.last_name) driver_name 
FROM campers c JOIN vehicles v ON c.id = v.driver_id;

SELECT r.starting_point route_starting_point, r.end_point route_ending_point, r.leader_id,
concat(c.first_name, ' ', c.last_name) leader_name FROM routes r JOIN campers c ON 
r.leader_id = c.id;

DROP TABLE peaks;
DROP TABLE mountains;

CREATE TABLE mountains(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30));

CREATE TABLE peaks(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
mountain_id INT NOT NULL,
CONSTRAINT fk_peaks_mountains FOREIGN KEY (mountain_id) REFERENCES mountains(id) ON DELETE CASCADE);

CREATE DATABASE company;
USE company;

CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30),
last_name VARCHAR(30),
project_id INT);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
client_name VARCHAR(100));

CREATE TABLE projects(
id INT PRIMARY KEY AUTO_INCREMENT,
client_id INT,
project_lead_id INT,
CONSTRAINT fk_projects_clients FOREIGN KEY (client_id) REFERENCES clients(id),
CONSTRAINT fk_projects_employees FOREIGN KEY (project_lead_id) REFERENCES employees(id));

ALTER TABLE employees
ADD CONSTRAINT fk_employees_projects FOREIGN KEY (project_id) REFERENCES projects(id);