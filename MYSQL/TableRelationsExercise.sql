CREATE DATABASE table_relations;
USE table_relations;

CREATE TABLE people(
person_id INT,
first_name VARCHAR(30),
salary DOUBLE,
passport_id INT);

CREATE TABLE passports(
passport_id INT,
passport_number VARCHAR(30));

INSERT INTO people VALUES (1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103), (3, 'Yana', 60200.00, 101);

INSERT INTO passports VALUES (101, 'N34FG21B'), (102, 'K65LO4R7'), (103, 'ZE657QP2');

ALTER TABLE passports
MODIFY COLUMN passport_id INT PRIMARY KEY,
MODIFY COLUMN passport_number VARCHAR(30) UNIQUE;

ALTER TABLE people
MODIFY COLUMN person_id INT PRIMARY KEY,
MODIFY COLUMN passport_id INT UNIQUE,
ADD CONSTRAINT fk_people_passports FOREIGN KEY (passport_id) REFERENCES passports(passport_id);

DROP TABLE people, passports;

CREATE TABLE passports(
passport_id INT PRIMARY KEY AUTO_INCREMENT,
passport_number VARCHAR(30) UNIQUE);

CREATE TABLE people(
person_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
salary DOUBLE,
passport_id INT UNIQUE,
CONSTRAINT fk_people_passports FOREIGN KEY (passport_id) REFERENCES passports(passport_id));

INSERT INTO passports VALUES (101, 'N34FG21B'), (102, 'K65LO4R7'), (103,'ZE657QP2');

INSERT INTO people (first_name, salary, passport_id) VALUES ('Roberto', 43300, 102),
('Tom', 56100, 103), ('Yana', 60200, 101);

CREATE TABLE manufacturers(
manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
established_on DATE);

CREATE TABLE models(
model_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
manufacturer_id INT NOT NULL,
CONSTRAINT fk_models_manufacturers FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(manufacturer_id));

INSERT INTO manufacturers (name, established_on) VALUES ('BMW', 19160301), ('Tesla', 20030101),
 ('Lada', 19660501);
 
 INSERT INTO models VALUES (101, 'X1', 1);
 INSERT INTO models (name, manufacturer_id) VALUES ('i6', 1), ('Model S', 2), ('Model X', 2), 
 ('Model 3', 2), ('Niva', 3);
 
 
 CREATE TABLE students(
 student_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(30) NOT NULL);
 
 CREATE TABLE exams(
 exam_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(30) NOT NULL);
 
 CREATE TABLE students_exams(
 student_id INT NOT NULL,
 exam_id INT NOT NULL,
 CONSTRAINT pk_students_exams PRIMARY KEY (student_id, exam_id),
 CONSTRAINT fk_students_exams_students FOREIGN KEY(student_id) REFERENCES students(student_id),
 CONSTRAINT fk_students_exams_exams FOREIGN KEY(exam_id) REFERENCES exams(exam_id));

 INSERT INTO students (name) VALUES ('Mila'), ('Toni'), ('Ron');
 
 INSERT INTO exams VALUES (101, 'Spring MVC'), (102, 'Neo4j'), (103, 'Oracle 11g');
 
 INSERT INTO students_exams VALUES (1, 101), (1, 102), (2, 101), (3, 103), (2, 102), (2, 103);

CREATE TABLE teachers(
teacher_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
manager_id INT);

INSERT INTO teachers (teacher_id, name) VALUES (101, 'John');

INSERT INTO teachers (name, manager_id) VALUES ('Maya', 106), ('Silva', 106), ('Ted', 105),
('Mark', 101), ('Grea', 101);

#INSERT INTO teachers VALUES (101, 'John', NULL), (102, 'Maya', 106), (103, 'Silva', 106),
#(104, 'Ted', 105),(105, 'Mark', 101), (106, 'Grea', 101);

ALTER TABLE teachers
ADD CONSTRAINT fk_teachers_teachers FOREIGN KEY (manager_id) REFERENCES teachers(teacher_id);


CREATE TABLE item_types(
item_type_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50));

CREATE TABLE items(
item_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
item_type_id INT,
CONSTRAINT fk_items_item_types FOREIGN KEY (item_type_id) REFERENCES item_types(item_type_id));

CREATE TABLE cities(
city_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50));

CREATE TABLE customers(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
birthday DATE,
city_id INT,
CONSTRAINT fk_customers_cities FOREIGN KEY (city_id) REFERENCES cities(city_id));

CREATE TABLE orders(
order_id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id) REFERENCES customers(customer_id));

CREATE TABLE order_items(
order_id INT,
item_id INT,
CONSTRAINT pk_order_items_orders_items PRIMARY KEY (order_id, item_id),
CONSTRAINT fk_order_items_orders FOREIGN KEY (order_id) REFERENCES orders(order_id),
CONSTRAINT fk_order_items_items FOREIGN KEY (item_id) REFERENCES items(item_id));


CREATE TABLE subjects(
subject_id INT PRIMARY KEY AUTO_INCREMENT,
subject_name VARCHAR(50));

CREATE TABLE majors(
major_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50));

CREATE TABLE payments(
payment_id INT PRIMARY KEY AUTO_INCREMENT,
payment_date DATE,
payment_amount DECIMAL(8,2),
student_id INT);

CREATE TABLE students(
student_id INT PRIMARY KEY AUTO_INCREMENT,
student_number VARCHAR(12),
student_name VARCHAR(50),
major_id INT);

CREATE TABLE agenda(
student_id INT,
subject_id INT);

ALTER TABLE agenda
ADD CONSTRAINT pk_agenda_subjects_students PRIMARY KEY (student_id, subject_id),
ADD CONSTRAINT fk_agenda_subjects FOREIGN KEY (subject_id) REFERENCES subjects(subject_id),
ADD CONSTRAINT fk_agenda_students FOREIGN KEY (student_id) REFERENCES students(student_id);

ALTER TABLE students
ADD CONSTRAINT fk_students_majors FOREIGN KEY (major_id) REFERENCES majors(major_id);

ALTER TABLE payments
ADD CONSTRAINT fk_payments_students FOREIGN KEY(student_id) REFERENCES students(student_id);


SELECT m.mountain_range, p.peak_name, p.elevation peak_elevation FROM mountains m JOIN peaks p 
ON m.id = p.mountain_id
WHERE mountain_range = 'Rila'
ORDER BY peak_elevation DESC;
