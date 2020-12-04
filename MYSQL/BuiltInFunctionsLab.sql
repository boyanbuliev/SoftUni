SELECT  title FROM books
WHERE substr(title, 1, 3) = 'The';

SELECT id, title, cost, substr(title, 1, 10) AS `Title Summary` FROM books;

SELECT REPLACE(title, 'The', '***') AS Title FROM books
WHERE substr(title, 1, 3) = 'The';

SELECT INSERT(title, locate('The', title), 3, '***') AS Title FROM books
WHERE substr(title, 1, 3) = 'The';

SELECT title, locate('The', title COLLATE utf8mb4_0900_as_cs) AS 'Index of The' FROM books;

SELECT round(sum(cost), 2) AS total FROM books;

SELECT concat(first_name, ' ', last_name) AS `Full Name`, 
timestampdiff(day, born, died) AS `Days Lived` FROM authors;

SELECT concat(first_name, ' ', last_name) AS `Full Name`, DATE_FORMAT(born, '%D %b %Y') AS Born,
DATE_FORMAT(died, '%D %b %Y') Died,
timestampdiff(year, born, IFNULL(died, NOW())) AS `Days Lived` FROM authors;

SELECT title FROM books
WHERE title LIKE '%Harry Potter%';

SELECT TITLE FROM books
WHERE title REGEXP '(?i)^.*\\s*the\\s.*$';

SELECT LTRIM(REGEXP_REPLACE(title, '\\s[Tt]he|[Tt]he\\s', ' *** ')) Title FROM books
WHERE title REGEXP '(?i)^.*the.*$'; 
