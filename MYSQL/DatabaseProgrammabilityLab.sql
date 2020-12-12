DELIMITER //
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50)) 
RETURNS INT DETERMINISTIC
BEGIN
DECLARE emp_count INT;
SET emp_count := (SELECT count(*) FROM employees 
NATURAL JOIN addresses
NATURAL JOIN towns t WHERE t.`name` = town_name);
RETURN emp_count;
END//
DELIMITER ;

SELECT ufn_count_employees_by_town('Carnation');

DELIMITER $$
CREATE FUNCTION ufn_diff_years(date1 DATETIME, date2 DATETIME)
RETURNS INT DETERMINISTIC
BEGIN
RETURN ROUND(DATEDIFF(date1, date2) / 365.25);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_select_employees_by_seniority(years_employed INT)
BEGIN
SELECT employee_id, first_name, last_name, hire_date, ufn_diff_years(NOW(), hire_date)
FROM employees
WHERE ufn_diff_years(NOW(), hire_date) < years_employed;
END$$
DELIMITER ;

CALL usp_select_employees_by_seniority(20);

DELIMITER $$
CREATE PROCEDURE usp_add_numbers(IN a INT, IN b INT, OUT result INT)
BEGIN
SET result := a + b;
END$$
DELIMITER ;

SET @answer = 0;
CALL usp_add_numbers(37, 5, @answer);

SELECT @answer;

DELIMITER $$
CREATE PROCEDURE usp_increment(INOUT result INT)
BEGIN
SET result := result + 1;
END$$
DELIMITER ;

CALL usp_increment(@answer);

SELECT @answer;


DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
UPDATE employees NATURAL JOIN departments
SET salary = salary * 1.05
WHERE `name` = department_name;
END$$
DELIMITER ;

SELECT employee_id, salary FROM employees
WHERE department_id = 3;
CALL usp_raise_salaries('Sales');

DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)	
BEGIN
START TRANSACTION;
IF((SELECT count(*) FROM employees WHERE employee_id = id) <> 1)
THEN
ROLLBACK;
ELSE
UPDATE employees
SET salary = salary * 1.05
WHERE employee_id = id;
COMMIT;
END IF;
END$$
DELIMITER ;

CALL usp_raise_salary_by_id(5100);


CREATE TABLE deleted_employees(
employee_id INT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
middle_name VARCHAR(50) DEFAULT NULL,
job_title VARCHAR(50) NOT NULL,
department_id INT DEFAULT NULL,
salary DECIMAL (19,4) NOT NULL);

DELIMITER $$
CREATE TRIGGER tr_deleted_employees AFTER DELETE ON employees
FOR EACH ROW
BEGIN
INSERT INTO deleted_employees(employee_id, first_name, last_name, middle_name, job_title,
department_id, salary)
VALUES (OLD. employee_id, OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END$$
DELIMITER ;

DELETE FROM employees
WHERE employee_id = 3;