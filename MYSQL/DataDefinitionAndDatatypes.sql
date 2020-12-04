CREATE DATABASE `minions`;
USE `minions`;

CREATE TABLE `minions` (
`id` INT,
`name`  VARCHAR(50),
`age` INT);

CREATE TABLE `towns` (
`town_id` INT,
`name` VARCHAR(50));

ALTER TABLE `minions`
CHANGE COLUMN `id`
`id` INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE `towns`
CHANGE COLUMN `town_id`
`town_id` INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE `towns`
CHANGE COLUMN `town_id` `id` INT AUTO_INCREMENT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY (`town_id`)
REFERENCES `towns` (`id`);

INSERT INTO `towns` (`name`) VALUES ('Sofia'), ('Plovdiv'), ('Varna');

INSERT INTO `minions` (`name`, `age`, `town_id`) VALUES ('Kevin', 22, 1), ('Bob', 15, 3);
INSERT INTO `minions` (`name`, `town_id`) VALUES ('Steward', 2);


TRUNCATE `minions`;

DROP TABLE `minions`;
DROP TABLE `towns`;

CREATE TABLE `people` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DECIMAL (3,2),
`weight` DECIMAL (4,2),
`gender` ENUM ('m','f') NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT);

INSERT INTO `people` (`name`, `height`, `weight`, `gender`, `birthdate`, `biography`) VALUES
('Ivan', 1.85, 80.1, m, 1993-01-01, 'Haro Misa Ivan'),
('Petkan', 1.8, 86, m, 1992-01-07, 'Haro Misa petkan'),
('Dragan', 1.7, 71, m, 1994-01-02, 'Haro Misa Dragan'),
('Maria', 1.65, 60, f, 1996-03-01, 'Haro Misa Maria'),
('Ginka', 1.6, 54, f, 1995-07-01, 'Haro Misa Ginka');


CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN);

INSERT INTO `users` (`username`, `password`, `last_login_time`, `is_deleted`) 
VALUES 
('hasan', 'asdf', '2020-11-24 11:10', 0),
('ali', 'hello', '2020-11-23 11:10', 0),
('gosho', 'ardg', '2020-11-22 11:10', 0),
('pesho', 'sxhjs', '2020-11-21 11:10', 1),
('petkan', 'hsshje', '2020-11-25 11:10', 0);

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `username`);

ALTER TABLE `users`
CHANGE COLUMN `last_login_time`
`last_login_time` DATETIME DEFAULT CURRENT_TIMESTAMP;

INSERT INTO `users` (`username`, `password`, `is_deleted`) 
VALUES ('Ivan', 'assgh', 0), ('Dragan', 'shhshs', 1);

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`);

CREATE DATABASE `movies`;
USE `movies`;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` TEXT);

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` TEXT);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` TEXT);

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL UNIQUE,
`director_id` INT NOT NULL,
FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`),
`copyright_year` YEAR NOT NULL,
`length` INT NOT NULL,
`genre_id` INT NOT NULL,
FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`),
`category_id` INT NOT NULL,
FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
`rating` DECIMAL(3,1),
`notes` TEXT);

INSERT INTO `directors` (`director_name`, `notes`) VALUES 
('GOSHO', 'slaba rakiq'), ('PESHO', 'ne e dobre'), ('IVAN', 'staa'), ('ALI', 'losho mi e'), ('GINKA', 'TEC');

INSERT INTO `genres` (`genre_name`, `notes`) VALUES
('Horror', 'tupnq'), ('Komediq', 'qko'), ('Ekshun', 'dobree'), ('Trilur', 'ok'), ('Liyboven', 'skukaa');

INSERT INTO `categories` (`category_name`) VALUES
('kot takoa'), ('nz brat');

INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES
('MATRICATA', 1, 1990, 90, 1, 1, 6.7, 'hello'),
('ZDRA4', 2, 1995, 92, 2, 2, 3.4, 'AAAAAA'),
('ZDRA4 2', 3, 1999, 100, 3, 3, 4.5, 'BBBBBB');


CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(30) NOT NULL,
`daily_rate` DECIMAL(5,2) NOT NULL,
`weekly_rate` DECIMAL(5,2) NOT NULL,
`monthly_rate` DECIMAL(6,2) NOT NULL,
`weekend_rate` DECIMAL (5,2) NOT NULL);

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` CHAR(8) NOT NULL UNIQUE,
`make` VARCHAR(30) NOT NULL,
`model` VARCHAR(30) NOT NULL,
`car_year` YEAR NOT NULL,
`category_id` INT NOT NULL,
FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
`doors` INT NOT NULL,
`picture` BLOB,
`car_condition` VARCHAR(30) NOT NULL,
`available` BOOLEAN);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`title` VARCHAR(30) NOT NULL,
`notes` TEXT);

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` INT NOT NULL,
`full_name` VARCHAR(50) NOT NULL,
`address` VARCHAR(100) NOT NULL,
`city` VARCHAR(30) NOT NULL,
`zip_code` INT NOT NULL,
`notes` TEXT);

CREATE TABLE `rental_orders`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition` VARCHAR(30) NOT NULL UNIQUE,
`tank_level` INT NOT NULL,
`kilometrage_start` INT NOT NULL,
`kilometrage_end` INT NOT NULL,
`total_kilometrage` INT NOT NULL,
`start_date` DATE NOT NULL,
`end_date` DATE NOT NULL,
`total_days` INT NOT NULL,
`rate_applied` DECIMAL(5,2) NOT NULL,
`tax_rate` DECIMAL(5,2) NOT NULL,
`order_status` VARCHAR(30) NOT NULL,
`notes` TEXT);

INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`) VALUES
('bali i maikata', 5.3, 4.4, 3.8, 4.7),
('nomer 2', 14.6, 11.5, 7.9, 9.8),
('a sq de', 7.15, 6.97, 4.57, 5.14);

INSERT INTO `cars` (`plate_number`, `make`, `model`, `car_year`, `category_id`, `doors`, `car_condition`, `available`) VALUES
('CA1234AB', 'BMW', 'M5', 1993, 1, 4, 'good', 1),
('CA3245GH', 'BMW', 'X5', 2004, 2, 4, 'average', 1),
('CB1245BJ', 'BMW', 'X6', 2010, 3, 4, 'bad', 0);

INSERT INTO `employees` (`first_name`, `last_name`, `title`) VALUES
('Pesho', 'Goshov', 'Car'),
('Ivan', 'Petrov', 'Lord'),
('Petkan', 'Draganov', 'Kravar');

INSERT INTO `customers` (`driver_licence_number`, `full_name`, `address`, `city`, `zip_code`) VALUES
(1234, 'Ivan Petkov', 'Centrum', 'Sofia', 1000),
(1234, 'Petko Petkov', 'Pokrainini', 'Sofia', 1234),
(1234, 'Gosho Goshov', 'Selo', 'Tytrakan', 1111);

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`,
`kilometrage_start`, `kilometrage_end`, `total_kilometrage`, `start_date`, `end_date`, `total_days`,
`rate_applied`, `tax_rate`, `order_status`) VALUES
(1, 1, 1, 'good', 50, 100, 120, 20, '2020-01-01', '2020-01-02', 2, 3.54, 7.58, 'completed');

CREATE DATABASE `hotel`;
USE `hotel`;

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`title` VARCHAR(30),
`notes` TEXT);

CREATE TABLE `customers`(
`account_number` INT PRIMARY KEY UNIQUE,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`phone_number` INT NOT NULL UNIQUE,
`emergency_name` VARCHAR(30) NOT NULL,
`emergency_number` INT NOT NULL,
`notes` TEXT);

CREATE TABLE `room_status`(
`room_status` VARCHAR(30) PRIMARY KEY,
`notes` TEXT);

CREATE TABLE `room_types`(
`room_type` VARCHAR(30) PRIMARY KEY,
`notes` TEXT);

CREATE TABLE `bed_types`(
`bed_type` VARCHAR(30) PRIMARY KEY,
`notes` TEXT);

CREATE TABLE `rooms`(
`room_number` INT PRIMARY KEY NOT NULL UNIQUE,
`room_type` VARCHAR(30) NOT NULL,
FOREIGN KEY (`room_type`) REFERENCES `room_types` (`room_type`),
`bed_type` VARCHAR(30) NOT NULL,
FOREIGN KEY (`bed_type`) REFERENCES `bed_types` (`bed_type`),
`rate` INT,
`room_status` VARCHAR(30) NOT NULL,
FOREIGN KEY (`room_status`) REFERENCES `room_status` (`room_status`),
`notes` TEXT);

CREATE TABLE `payments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
`payment_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
`account_number` INT NOT NULL,
FOREIGN KEY (`account_number`) REFERENCES `customers` (`account_number`),
`first_date_occupied` DATE NOT NULL,
`last_date_occupied` DATE NOT NULL,
`total_days` INT NOT NULL,
`amount_charged` DECIMAL(5,2) NOT NULL,
`tax_rate` DECIMAL(5,2) NOT NULL,
`tax_amount` DECIMAL(5,2) NOT NULL,
`payment_total` DECIMAL(5,2) NOT NULL,
`notes` TEXT);

CREATE TABLE `occupancies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
`date_occupied` DATE NOT NULL,
`account_number` INT NOT NULL UNIQUE,
FOREIGN KEY (`account_number`) REFERENCES `customers` (`account_number`),
`room_number` INT NOT NULL UNIQUE,
FOREIGN KEY (`room_number`) REFERENCES `rooms` (`room_number`),
`rate_applied` DECIMAL(5,2) NOT NULL,
`phone_charge` INT,
`notes` TEXT);

INSERT INTO `employees` (`first_name`, `last_name`, `title`) VALUES
('Pesho', 'Goshov', 'chistach'),
('Gosho', 'Ivanov', 'miqch'),
('Ivan', 'Petkov', 'bursach');

INSERT INTO `customers` (`account_number`, `first_name`, `last_name`, `phone_number`, `emergency_name`,
`emergency_number`) VALUES
(1234, 'Dragan', 'Petkov', 088826322, 'Pesho', 084626223),
(1235, 'Chingiz', 'Han', 0826222111, 'Gosho', 084626524),
(1236, 'Hasan', 'Ali', 062477322, 'Ivan', 086612623);

INSERT INTO `room_status`(`room_status`) VALUES
('free'),('occupied'),('maintenance');

INSERT INTO `room_types` (`room_type`) VALUES
('carska'),('normalna'),('evtina');

INSERT INTO `bed_types` (`bed_type`) VALUES
('carsko'),('normalno'),('detsko');

INSERT INTO `rooms` (`room_number`, `room_type`, `bed_type`, `rate`, `room_status`) VALUES
(100, 'carska', 'carsko', '100', 'occupied'),
(101, 'normalna', 'normalno', '50', 'free'),
(102, 'evtina', 'detsko', '20', 'occupied');

INSERT INTO `payments` (`employee_id`, `payment_date`, `account_number`, `first_date_occupied`,
`last_date_occupied`, `total_days`, `amount_charged`, `tax_rate`, `tax_amount`, `payment_total`) VALUES
(1, '2020-11-25', 1234, '2020-11-24', '2020-11-26', 3, 300, 20, 60, 360),
(2, '2020-11-25', 1234, '2020-11-24', '2020-11-26', 3, 150, 20, 30, 180),
(3, '2020-11-25', 1234, '2020-11-24', '2020-11-26', 3, 60, 20, 12, 72);

INSERT INTO `occupancies` (`employee_id`, `date_occupied`, `account_number`, `room_number`, `rate_applied`,
`phone_charge`) VALUES
(1, '2020-11-24', 1234, 100, 100, 50),
(2, '2020-11-24', 1235, 101, 50, 50),
(3, '2020-11-24', 1236, 102, 20, 50);

CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` VARCHAR(50) NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (`town_id`) REFERENCES `towns` (`id`));

CREATE TABLE `departments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`middle_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`job_title` VARCHAR(30) NOT NULL,
`department_id` INT NOT NULL,
CONSTRAINT fk_employees_departments
FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
`hire_date` DATE NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`address_id` INT,
CONSTRAINT fk_employees_addresses
FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`));

INSERT INTO `towns` (`name`) VALUES ('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

INSERT INTO `departments` (`name`) VALUES ('Engineering'), ('Sales'), ('Marketing'), 
('Software Development'), ('Quality Assurance');

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`,
`hire_date`, `salary`) VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);

SELECT `name` FROM `towns`
ORDER BY `name`;
SELECT `name` FROM `departments`
ORDER BY `name`;
SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;

UPDATE `employees`
SET `salary` = `salary` * 1.1;

SELECT `salary` FROM `employees`;

USE `hotel`;
UPDATE `payments`
SET `tax_rate` = `tax_rate` * 0.97;

SELECT `tax_rate` FROM `payments`;

TRUNCATE TABLE `occupancies`;