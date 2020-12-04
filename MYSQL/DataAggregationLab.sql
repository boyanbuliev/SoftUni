SELECT job_title , count(employee_id) FROM employees
GROUP BY job_title;

SELECT department_id, count(department_id) 'Number of employees' FROM employees
GROUP BY department_id
ORDER BY department_id, `Number of employees`;

SELECT * FROM employees;
SELECT department_id, round(avg(salary), 2) 'Average Salary' FROM employees
GROUP BY department_id;
