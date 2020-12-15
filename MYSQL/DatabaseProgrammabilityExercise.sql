DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
SELECT first_name, last_name FROM employees
WHERE salary > 35000
ORDER BY first_name, last_name;
END$$
DELIMITER ;
CALL usp_get_employees_salary_above_35000;


DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(target_salary DECIMAL(19,4))
BEGIN
SELECT first_name, last_name FROM employees
WHERE salary >= target_salary
ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;
CALL usp_get_employees_salary_above(45000);


DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(start_str VARCHAR(20))
BEGIN
SELECT `name` FROM towns
WHERE `name` LIKE concat(start_str, '%')
ORDER BY `name`;
#WHERE LEFT (`name`, char_length(start_string)) = start_str;
END$$
DELIMITER ;
CALL usp_get_towns_starting_with('b');


DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
SELECT first_name, last_name FROM employees NATURAL JOIN addresses NATURAL JOIN towns
WHERE name = town_name
ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;
CALL usp_get_employees_from_town('Sofia');


DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary INT)
RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
RETURN CASE 
WHEN salary < 30000 THEN 'Low'
WHEN salary BETWEEN 30000 AND 50000 THEN 'Average'
ELSE 'High'
END;
END$$
DELIMITER ;
SELECT salary, ufn_get_salary_level(salary) FROM employees;


DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
SELECT first_name, last_name FROM employees
WHERE ufn_get_salary_level(salary) = salary_level
ORDER BY first_name DESC, last_name DESC;
END$$
DELIMITER ;
CALL usp_get_employees_by_salary_level('high');

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BOOL DETERMINISTIC
BEGIN
RETURN IF(word REGEXP concat('^[',set_of_letters,']+$'), 1, 0);
END$$
DELIMITER ;
DROP FUNCTION ufn_is_word_comprised;
SELECT ufn_is_word_comprised('pppp', 'Guy');


DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
SELECT concat(first_name, ' ', last_name) full_name FROM account_holders
ORDER BY full_name, id;
END$$
DELIMITER ;
CALL usp_get_holders_full_name;

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(select_balance DECIMAL(19,4))
BEGIN
SELECT ac.id, first_name, last_name FROM account_holders ac 
JOIN accounts a ON ac.id = a.account_holder_id
GROUP BY ac.id
HAVING sum(balance) > select_balance
ORDER BY account_holder_id;
END$$
DELIMITER ;
CALL usp_get_holders_with_balance_higher_than(7000);


DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL (19, 4), interest DOUBLE, years INT)
RETURNS DECIMAL (19, 4) DETERMINISTIC
BEGIN
RETURN sum*pow(1+interest, years);
END$$
DELIMITER ;
SELECT ufn_calculate_future_value(1000, 0.5, 5);


DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT, interest_rate DOUBLE)
BEGIN
SELECT a.id account_id, first_name, last_name, balance current_balance,
ufn_calculate_future_value(balance, interest_rate, 5) FROM account_holders ah
JOIN accounts a ON ah.id = a.account_holder_id
WHERE a.id = acc_id;
END$$
DELIMITER ;
CALL usp_calculate_future_value_for_account(1, 0.1);


DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL (19, 4))
BEGIN
START TRANSACTION;
IF money_amount <= 0 OR (SELECT count(*) FROM accounts WHERE id = account_id) = 0 THEN ROLLBACK;
ELSE UPDATE accounts
SET balance = balance + money_amount
WHERE id = account_id;
COMMIT;
END IF;
END$$
DELIMITER ;
CALL usp_deposit_money(1, 10);
DROP PROCEDURE usp_deposit_money;


DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL (19, 4))
BEGIN
START TRANSACTION;
IF money_amount <= 0 OR 
money_amount > (SELECT balance FROM accounts WHERE id = account_id) OR
(SELECT count(*) FROM accounts WHERE id = account_id) = 0 
THEN ROLLBACK;
ELSE UPDATE accounts
SET balance = balance - money_amount
WHERE id = account_id;
END IF;
END$$
DELIMITER ;
CALL usp_withdraw_money(1, 10);


DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL (19, 4))
BEGIN
START TRANSACTION;
IF (SELECT count(*) FROM accounts WHERE from_account_id = id) <> 1 OR
(SELECT count(*) FROM accounts WHERE to_account_id = id) <> 1 OR
from_account_id = to_account_id OR
amount > (SELECT balance FROM accounts WHERE from_account_id = id) OR
amount <= 0
THEN ROLLBACK;
ELSE 
UPDATE accounts
SET balance = balance + amount WHERE id = to_account_id;
UPDATE accounts
SET balance = balance - amount WHERE id = from_account_id;
END IF;
END$$
DELIMITER ;
CALL usp_transfer_money(1, 2, 10);


CREATE TABLE `logs`(
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT,
old_sum DECIMAL (19, 2),
new_sum DECIMAL (19, 2));

DELIMITER $$
CREATE TRIGGER tr_log_accounts AFTER UPDATE ON accounts FOR EACH ROW
BEGIN
INSERT INTO `logs` (account_id, old_sum, new_sum)
VALUES (OLD.id, OLD.balance, NEW.balance);
END$$
DELIMITER ;


CREATE TABLE notification_emails(
id INT PRIMARY KEY AUTO_INCREMENT,
recipient INT,
subject TEXT,
body TEXT);

DELIMITER $$
CREATE TRIGGER tr_create_email AFTER INSERT ON logs FOR EACH ROW
BEGIN 
INSERT INTO notification_emails (recipient, `subject`, body)
VALUES (NEW.account_id, concat('Balance change for account: ', NEW.account_id),
concat('On ', DATE_FORMAT(NOW(), '%b %d %Y'), ' at ', TIME_FORMAT(NOW(), '%r'),
' your balance was changed from ', (SELECT NEW.old_sum FROM `logs` WHERE log_id = NEW.log_id),
' to ', (SELECT NEW.new_sum FROM `logs`WHERE log_id = NEW.log_id), '.'));
END$$
DELIMITER ;