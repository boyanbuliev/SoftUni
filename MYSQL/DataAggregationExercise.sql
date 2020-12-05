SELECT count(*) count FROM wizzard_deposits;

SELECT max(magic_wand_size) longest_magic_wand FROM wizzard_deposits;

SELECT deposit_group, max(magic_wand_size) longest_magic_wand FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY longest_magic_wand, deposit_group;

SELECT deposit_group FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY avg(magic_wand_size)
LIMIT 1;

SELECT first_name FROM wizzard_deposits
LIMIT 4, 1;

SELECT deposit_group, sum(deposit_amount) total_sum FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY total_sum;

SELECT deposit_group, sum(deposit_amount) total_sum FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

SELECT deposit_group, sum(deposit_amount) total_sum FROM wizzard_deposits
WHERE magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING total_sum < 150000
ORDER BY total_sum DESC;

SELECT deposit_group, magic_wand_creator, min(deposit_charge) FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
ORDER BY magic_wand_creator, deposit_group;

SELECT CASE 
WHEN age BETWEEN 0 AND 10 THEN '[0-10]'
WHEN age <= 20 THEN '[11-20]'
WHEN age <= 30 THEN '[21-30]'
WHEN age <= 40 THEN '[31-40]'
WHEN age <= 50 THEN '[41-50]'
WHEN age <= 60 THEN '[51-60]'
ELSE '[61+]'
END age_group,
count(*) wizard_count
FROM wizzard_deposits
GROUP BY age_group
ORDER BY wizard_count;

SELECT left(first_name, 1) first_letter FROM wizzard_deposits
WHERE deposit_group = 'Troll Chest'
GROUP BY first_letter
ORDER BY first_letter;

SELECT deposit_group, is_deposit_expired, avg(deposit_interest)  average_interest FROM wizzard_deposits
WHERE deposit_start_date > 19850101
GROUP BY deposit_group, is_deposit_expired
ORDER BY deposit_group DESC, is_deposit_expired;


SELECT * FROM wizzard_deposits;
SELECT w1.first_name host_wizard, w1.deposit_amount host_wizard_deposit,
(SELECT w2.first_name FROM wizzard_deposits w2 WHERE w2.id = w1.id + 1) guest_wizard,
(SELECT w2.deposit_amount FROM wizzard_deposits w2 WHERE w2.id = w1.id + 1) guest_wizard_deposit,
w1.deposit_amount - (SELECT w2.deposit_amount FROM wizzard_deposits w2 WHERE w2.id = w1.id + 1) difference,
sum(w1.deposit_amount - (SELECT w2.deposit_amount FROM wizzard_deposits w2 WHERE w2.id = w1.id + 1)) sum_difference
FROM wizzard_deposits w1;

SELECT sum(w1.deposit_amount - (SELECT w2.deposit_amount FROM wizzard_deposits w2 WHERE w2.id = w1.id + 1)) sum_difference
FROM wizzard_deposits w1;

SELECT sum(w1.deposit_amount - w2.deposit_amount) sum_difference FROM wizzard_deposits w1, wizzard_deposits w2
WHERE w2.id = w1.id + 1;

SELECT department_id, min(salary) FROM employees
WHERE hire_date > 20000101 AND department_id IN(2, 5, 7)
GROUP BY department_id;

CREATE TABLE new_table AS
SELECT * FROM employees
WHERE salary > 30000 AND manager_id != 42;

UPDATE new_table
SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id, avg(salary) FROM new_table
GROUP BY department_id
ORDER BY department_id;

SELECT department_id, max(salary) max_salary FROM employees
GROUP BY department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000;

SELECT count(*) FROM employees
WHERE manager_id IS NULL;

SELECT DISTINCT salary FROM employees
WHERE department_id = 1
ORDER BY salary DESC
LIMIT 2, 1;

SELECT e.department_id, (SELECT DISTINCT e2.salary FROM employees e2
WHERE e2.department_id = e.department_id
ORDER BY e2.salary DESC
LIMIT 2, 1) third_highest_salary FROM employees e
GROUP BY e.department_id
HAVING third_highest_salary IS NOT NULL;

SELECT e1.first_name, e1.last_name, e1.department_id FROM employees e1
WHERE e1.salary > (SELECT avg(e2.salary) FROM employees e2 WHERE e2.department_id = e1.department_id)
ORDER BY department_id, employee_id
LIMIT 10;

SELECT department_id, sum(salary) FROM employees
GROUP BY department_id;