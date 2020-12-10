SELECT employee_id, job_title, e.address_id, address_text FROM employees e JOIN addresses a ON 
e.address_id = a.address_id
ORDER BY address_id
LIMIT 5;


SELECT first_name, last_name, t.name town, address_text FROM employees e JOIN addresses a ON
e.address_id = a.address_id JOIN towns t ON t.town_id = a.town_id
ORDER BY first_name, last_name LIMIT 5;


SELECT employee_id, first_name, last_name, name department_name 
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE name = 'Sales'
ORDER BY employee_id DESC;

SELECT employee_id, first_name, salary, 'Sales' department_name FROM employees
WHERE (SELECT department_id FROM departments WHERE name = 'Sales')
ORDER BY employee_id DESC;


SELECT employee_id, first_name, salary, name department_name
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;


SELECT e.employee_id, first_name FROM employees e 
LEFT JOIN employees_projects ep ON e.employee_id = ep.employee_id
WHERE project_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;

SELECT employee_id, first_name FROM employees e
WHERE (SELECT count(*) FROM employees_projects ep WHERE ep.employee_id = e.employee_id) = 0
ORDER BY employee_id DESC
LIMIT 3;

SELECT employee_id, first_name FROM employees
WHERE employee_id NOT IN (SELECT employee_id FROM employees_projects)
ORDER BY employee_id DESC
LIMIT 3;


SELECT e.first_name, e.last_name, e.hire_date, d.name dept_name
FROM employees e JOIN departments d ON e.department_id = d.department_id
WHERE hire_date > 19990101 AND d.name IN('Sales', 'Finance')
ORDER BY hire_date;


SELECT e.employee_id, e.first_name, p.name project_name FROM employees e
JOIN employees_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON p.project_id = ep.project_id
WHERE p.start_date > 20020813 AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;


SELECT e.employee_id, e.first_name, IF(year(p.start_date) < 2005, p.name, NULL) project_name FROM employees e
JOIN employees_projects ep ON e.employee_id = ep.employee_id
JOIN projects p ON p.project_id = ep.project_id
WHERE e.employee_id = 24
ORDER BY project_name;


SELECT e.employee_id, e.first_name, e.manager_id, 
(SELECT first_name FROM employees e1 WHERE e1.employee_id = e.manager_id) manager_name
FROM employees e
WHERE manager_id IN (3, 7)
ORDER BY e.first_name;

SELECT e.employee_id, e.first_name, e.manager_id, e1.first_name FROM employees e 
JOIN employees e1 ON e.manager_id = e1.employee_id
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name;


SELECT e.employee_id, concat(e.first_name, ' ', e.last_name) employee_name, 
concat(e1.first_name, ' ', e1.last_name) manager_name, d.name FROM employees e
JOIN employees e1 ON e.manager_id = e1.employee_id 
JOIN departments d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;


SELECT min(min_average_salary) min_average_salary FROM (SELECT avg(salary) min_average_salary FROM employees GROUP BY department_id) e;

SELECT department_id, avg(salary) min_average_salary FROM employees GROUP BY department_id
ORDER BY min_average_salary
LIMIT 1;


SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation FROM countries c
JOIN mountains_countries mc ON c.country_code = mc.country_code
JOIN mountains m ON mc.mountain_id = m.id
JOIN peaks p ON p.mountain_id = m.id
WHERE c.country_code = 'BG' AND p.elevation > 2835
ORDER BY p.elevation DESC;


SELECT country_code, count(*) mountain_range FROM mountains_countries
GROUP BY country_code
HAVING country_code IN('BG', 'RU', 'US')
ORDER BY mountain_range DESC;


SELECT c.country_name, r.river_name FROM countries c
LEFT JOIN countries_rivers cr ON c.country_code = cr.country_code
LEFT JOIN rivers r ON cr.river_id = r.id
WHERE c.continent_code = 'AF'
ORDER BY country_name;


SELECT count(*) FROM countries c
LEFT JOIN mountains_countries mc ON c.country_code = mc.country_code
WHERE mountain_id IS NULL;


SELECT c.country_name, max(p.elevation) highest_peak_elevation, max(r.length) longest_river_length FROM countries c
JOIN countries_rivers cr ON c.country_code = cr.country_code
JOIN rivers r ON cr.river_id = r.id
JOIN mountains_countries mc ON c.country_code = mc.country_code
JOIN mountains m ON mc.mountain_id = m.id
JOIN peaks p ON p.mountain_id = m.id
GROUP BY country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, country_name
LIMIT 5;