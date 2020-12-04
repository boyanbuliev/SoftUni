SELECT department_id, round(sum(salary), 2) 'Salary Sum' FROM employees
GROUP BY department_id
ORDER BY department_id;

SELECT job_title , count(employee_id) FROM employees
GROUP BY job_title;

SELECT department_id, count(id) 'Number of employees' FROM employees
GROUP BY department_id
ORDER BY department_id;

SELECT department_id, job, count(id) 'Number of employees' FROM employees
GROUP BY department_id
ORDER BY department_id;

SELECT department_id, count(DISTINCT salary) 'Number of Salaries' FROM employees
GROUP BY department_id
ORDER BY department_id;

SELECT * FROM employees;
SELECT department_id, ceil(salary / 1000) * 1000 'Number of Salaries', count(*)  FROM employees
GROUP BY department_id, `Number of Salaries`
ORDER BY department_id;

SELECT department_id, round(avg(salary), 2) 'Average Salary' FROM employees
GROUP BY department_id;

SELECT department_id, round(min(salary), 2) 'Min Salary' FROM employees
GROUP BY department_id
HAVING `Min Salary` > 800;

SELECT count(*) appetizers FROM products
WHERE price > 8 && category_id = 2;

SELECT category_id, round(avg(price), 2) 'Average Price', round(min(price), 2) 'Cheapest Product',
round(max(price), 2) 'Most Expensive Product' FROM products
GROUP BY category_id;

SELECT * FROM products;
SELECT category_id, country, count(price) 'Number of Products', round(avg(price), 2) 'Average Price' 
FROM products
GROUP BY category_id, country
HAVING `Number of Products` >= 2;

SELECT * FROM products;
SELECT IF(GROUPING(category_id) = 1, 'All categories', category_id) category_id,
IF(GROUPING(country) = 1, 'All countries', country) country,
count(price) 'Number of Products', round(sum(price), 2) 'Total Price'
FROM products
GROUP BY category_id, country WITH ROLLUP
HAVING `Number of Products` >= 2;

SELECT IF(GROUPING(category_id) = 1, 'All categories', category_id) category_id,
IF(GROUPING(country) = 1, 'All countries', country) country,
 count(price) 'Number of Products', round(sum(price), 2) 'Total Price'
FROM products
GROUP BY category_id, country WITH ROLLUP;
