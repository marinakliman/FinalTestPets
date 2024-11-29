CREATE DATABASE Human_Friends;

USE Human_Friends;

CREATE TABLE Pets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

CREATE TABLE PackAnimals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

INSERT INTO Pets (name, command, birth_date) VALUES
('Buddy', 'Sit', '2020-05-01'),
('Mittens', 'Lie Down', '2019-03-15'),
('Hammy', 'Spin', '2021-07-10');

INSERT INTO PackAnimals (name, command, birth_date) VALUES
('Flash', 'Pull', '2018-06-20'),
('Camel', 'Carry', '2017-11-05'),
('Daisy', 'Kick', '2019-02-11');

DELETE FROM PackAnimals WHERE name = 'Camel' LIMIT 1;


CREATE TABLE Combined_Animals AS
SELECT * FROM PackAnimals WHERE name IN ('Flash', 'Daisy');

CREATE TABLE Young_Animals AS
SELECT *,
       TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age
FROM Pets
WHERE YEAR(CURDATE()) - YEAR(birth_date) < 3
  AND YEAR(CURDATE()) - YEAR(birth_date) > 1;
  
CREATE TABLE All_Animals AS
SELECT 'Pets' AS type, id, name, command, birth_date FROM Pets
UNION ALL
SELECT 'PackAnimals' AS type, id, name, command, birth_date FROM PackAnimals;


SELECT * FROM All_Animals;
