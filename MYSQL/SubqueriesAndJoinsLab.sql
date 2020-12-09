SELECT employee_id, concat(first_name, ' ', last_name) full_name, d.department_id, 
name department_name FROM employees e JOIN departments d ON e.employee_id = d.manager_id
ORDER BY employee_id
LIMIT 10;


SELECT a.town_id, name town_name, address_text FROM addresses a JOIN towns t ON a.town_id = t.town_id
WHERE name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id, address_id;


SELECT employee_id, first_name, last_name, department_id, salary FROM employees
WHERE manager_id IS NULL;


SELECT count(*) count FROM employees
WHERE salary > (SELECT avg(salary) FROM employees);


SELECT concat(e.first_name, ' ', e.last_name) full_name, p.name FROM employees e  
JOIN employees_projects ep ON ep.employee_id = e.employee_id
JOIN projects p ON p.project_id = ep.project_id
ORDER BY ep.project_id;


SELECT employee_id, first_name, e.last_name, d.name, a.address_text address, t.name
FROM departments d 
RIGHT JOIN employees e ON d.department_id = e.department_id
JOIN addresses a ON e.address_id = a.address_id
JOIN towns t ON a.town_id = t.town_id
ORDER BY e.employee_id;

SELECT employee_id, first_name, e.last_name, d.name, a.address_text address, t.name 
FROM departments d, employees e, addresses a, towns t
WHERE d.department_id = e.department_id AND e.address_id = a.address_id AND a.town_id = t.town_id
ORDER BY e.employee_id;


CREATE INDEX ix_employees_job_title
ON employees(job_title);