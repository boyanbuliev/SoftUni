SELECT first_name, last_name FROM employees
WHERE first_name LIKE 'Sa%' ORDER BY employee_id;

SELECT first_name, last_name FROM employees
WHERE LEFT(first_name, 2) = 'Sa';

SELECT first_name, last_name FROM employees
WHERE substr(first_name, 1, 2) = 'Sa';

SELECT first_name, last_name FROM employees
WHERE last_name LIKE '%ei%' ORDER BY employee_id;

SELECT * FROM employees;
SELECT first_name FROM employees
WHERE department_id IN(3, 10)
AND year(hire_date) BETWEEN '1995' AND '2005'
ORDER BY employee_id;

Select first_name, last_name, job_title FROM employees
WHERE job_title NOT LIKE '%engineer%';

SELECT `name` FROM towns
WHERE char_length(`name`) IN(5, 6)
ORDER BY `name`;

SELECT * FROM towns
WHERE `name` REGEXP '(?i)^[mkbe]'
ORDER BY `name`;

SELECT * FROM towns
WHERE LEFT(`name`, 1) IN ('m', 'k', 'b', 'e')
ORDER BY `name`;
 
SELECT * FROM towns
WHERE `name` REGEXP '(?i)^[^rbd]'
ORDER BY `name`;

SELECT * FROM towns
WHERE LEFT(`name`, 1) NOT IN ('r', 'b', 'd')
ORDER BY `name`;

CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name FROM employees
WHERE year(hire_date) > 2000;

SELECT * from v_employees_hired_after_2000;

SELECT first_name, last_name FROM employees
WHERE char_length(last_name) = 5;

SELECT country_name, iso_code FROM countries
#WHERE country_name REGEXP '(?i).*a.*a.*a.*'
WHERE country_name LIKE '%a%a%a%'
ORDER BY iso_code;

SELECT peak_name, river_name, lower(concat(peak_name, substr(river_name, 2))) mix
FROM peaks, rivers
WHERE right(peak_name, 1) = left(river_name, 1)
ORDER BY mix;

SELECT p.peak_name, r.river_name, LOWER(concat(p.peak_name, substr(r.river_name, 2))) mix FROM peaks p, rivers r
WHERE RIGHT(peak_name, 1) = LEFT(river_name, 1)
ORDER BY mix;

SELECT `name`, date(`start`) FROM games
WHERE year(`start`) BETWEEN '2011' AND '2012'
ORDER BY `start`, `name`
LIMIT 50;

SELECT user_name, substr(email, locate('@', email) + 1) `Email Provider` FROM users
ORDER BY `Email Provider`, user_name;

SELECT user_name, ip_address FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

SELECT `name` game, 
CASE
WHEN hour(`start`) BETWEEN 0 AND 11 THEN 'Morning'
WHEN hour(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
WHEN hour(`start`) BETWEEN 18 AND 23 THEN 'Evening'
#ELSE 'Evening'
END
`Part of the Day`,
CASE
WHEN duration <= 3 THEN 'Extra Short'
WHEN duration BETWEEN 4 AND 6 THEN 'Short'
WHEN duration BETWEEN 7 AND 10 THEN 'Long'
ELSE 'Extra Long'
END
Duration
FROM games;

SELECT product_name, order_date, 
timestamp(date_add(order_date, interval 3 day)) pay_due,
timestamp(date_add(order_date, interval 1 month)) deliver_due
 FROM orders;