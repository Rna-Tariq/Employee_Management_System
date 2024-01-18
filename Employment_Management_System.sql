CREATE TABLE Positions (
	PositionID INT PRIMARY KEY AUTO_INCREMENT,
    PositionName VARCHAR(100),
    Salary DECIMAL(10, 2)
);

CREATE TABLE Employees (
	EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    EmployeeName VARCHAR(100),
    Age INT,
    Address VARCHAR(200),
    Email VARCHAR(255),
    EntryDate DATE,
    ContractDuration INT,
    NoticePeriod INT,
    PositionID INT,
	FOREIGN KEY (PositionID) REFERENCES Positions(PositionID) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE Projects (
	ProjectID INT PRIMARY KEY AUTO_INCREMENT,
    ProjectName VARCHAR(255),
    NumberOfTasks INT,
    Deadline DATE
    );

CREATE TABLE SalaryGrades (
	GradeID INT PRIMARY KEY AUTO_INCREMENT,
    PositionID INT,
    MinSalary DECIMAL(10, 2),
    MaxSalary DECIMAL(10, 2),
    FOREIGN KEY (PositionID) REFERENCES Positions(PositionID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE EmployeeProjects (
	EmployeeID INT,
    ProjectID INT,
    PRIMARY KEY(EmployeeID, ProjectID),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Positions (PositionName, Salary)
VALUES ("Manager", 80000);
INSERT INTO Positions (PositionName, Salary)
VALUES ("Junior", 10000);
INSERT INTO Positions (PositionName, Salary)
VALUES ("Senior", 20000);
INSERT INTO Positions (PositionName, Salary)
VALUES ("HR", 8000);
INSERT INTO Positions (PositionName, Salary)
VALUES ( "Quality Assurance", 10000);

INSERT INTO Employees (EmployeeName, Age, Address, Email, EntryDate, ContractDuration, NoticePeriod, PositionID)
VALUES ("John Doe", 41, "31 Garden St", "john.doe@example.com", '2022-01-01', 12, 14, 4);
INSERT INTO Employees (EmployeeName, Age, Address, Email, EntryDate, ContractDuration, NoticePeriod, PositionID)
VALUES ("Jane Doe", 44, "50 Main St", "jane.doe@example.com", '2024-02-01', 24, 30, 1);
INSERT INTO Employees (EmployeeName, Age, Address, Email, EntryDate, ContractDuration, NoticePeriod, PositionID)
VALUES ("Josh Doe", 33, "90 Mall St", "josh.doe@example.com", '2022-12-01', 6, 21, 3);
INSERT INTO Employees (EmployeeName, Age, Address, Email, EntryDate, ContractDuration, NoticePeriod, PositionID)
VALUES ("Amy Doe", 23, "251 Degla", "amy.doe@example.com", '2020-03-27', 18, 7, 2);
INSERT INTO Employees (EmployeeName, Age, Address, Email, EntryDate, ContractDuration, NoticePeriod, PositionID)
VALUES ("Jenny Doe", 28, "15 Sheraton", "jenny.doe@example.com", '2021-02-04', 12, 14, 5);

INSERT INTO Projects (ProjectName, NumberOfTasks, Deadline) VALUES
("Employment Management System", 4, '2024-01-18');
INSERT INTO Projects (ProjectName, NumberOfTasks, Deadline) VALUES
("Bookstore Management System", 10, '2021-01-01');
INSERT INTO Projects (ProjectName, NumberOfTasks, Deadline) VALUES
("Pharmacy Management System", 7, '2020-11-12');
INSERT INTO Projects (ProjectName, NumberOfTasks, Deadline) VALUES
("Factory Management System", 20, '2022-10-8');


INSERT INTO SalaryGrades (PositionID, MinSalary, MaxSalary) VALUES
(1, 100000, 50000);
INSERT INTO SalaryGrades (PositionID, MinSalary, MaxSalary) VALUES
(2, 10000, 20000);
INSERT INTO SalaryGrades (PositionID, MinSalary, MaxSalary) VALUES
(3, 20000, 40000);
INSERT INTO SalaryGrades (PositionID, MinSalary, MaxSalary) VALUES
(4, 6000, 10000);
INSERT INTO SalaryGrades (PositionID, MinSalary, MaxSalary) VALUES
(5, 20000, 30000);

INSERT INTO EmployeeProjects (EmployeeID, ProjectID) VALUES
(3, 4);
INSERT INTO EmployeeProjects (EmployeeID, ProjectID) VALUES
(4, 2);
INSERT INTO EmployeeProjects (EmployeeID, ProjectID) VALUES
(5, 3);
INSERT INTO EmployeeProjects (EmployeeID, ProjectID) VALUES
(4, 1);
INSERT INTO EmployeeProjects (EmployeeID, ProjectID) VALUES
(3, 3);
INSERT INTO EmployeeProjects (EmployeeID, ProjectID) VALUES
(4, 3);

-- Display employees involved in at least two projects and show the project names alongside employee data.
SELECT
    e.EmployeeID,
    e.EmployeeName,
    p.PositionName,
    ep.ProjectID,
    pr.ProjectName
FROM
    Employees e
JOIN
    EmployeeProjects ep ON e.EmployeeID = ep.EmployeeID
JOIN
    Projects pr ON ep.ProjectID = pr.ProjectID
JOIN
    Positions p ON e.PositionID = p.PositionID
WHERE
    e.EmployeeID IN (
        SELECT
            EmployeeID
        FROM
            EmployeeProjects
        GROUP BY
            EmployeeID
        HAVING
            COUNT(ProjectID) >= 2
    )
ORDER BY
    e.EmployeeID, pr.ProjectID;

-- Calculate the average salary rate per posi?on and display it in ascending order. 
SELECT PositionName, AVG(Salary) AS AverageSalary FROM Positions
GROUP BY PositionName ORDER BY AverageSalary ASC;

-- Added column Budget to update the salary of all employees by 10% if they are 
-- involved in a project with a budget exceeding 100,000 euros.
ALTER TABLE Projects
ADD COLUMN Budget INT;

UPDATE Projects
SET Budget = 150000
WHERE ProjectName = "Employment Management System";

UPDATE Projects
SET Budget = 200000
WHERE ProjectName = "Bookstore Management System";

UPDATE Projects
SET Budget = 90000
WHERE ProjectName = "Pharmacy Management System";

UPDATE Projects
SET Budget = 50000
WHERE ProjectName = "Factory Management Systemm";

BEGIN;
CREATE TEMPORARY TABLE temp_positions As
	SELECT DISTINCT p.PositionID
    FROM Positions p
    JOIN Employees e ON p.PositionID = e.PositionID
    JOIN EmployeeProjects ep ON e.EmployeeID = ep.EmployeeID
    JOIN Projects pr ON ep.ProjectID = pr.ProjectID
	WHERE pr.Budget > 100000;
    
UPDATE Positions
SET Salary = Salary * 1.1
WHERE PositionID IN (SELECT * FROM temp_positions);

DROP TEMPORARY TABLE IF EXISTS temp_positions;
COMMIT;

-- Delete all employees older than 40 years who are not involved in any projects.
DELETE FROM Employees
WHERE Age > 40 AND EmployeeID NOT IN (
	SELECT DISTINCT ep.EmployeeID
    FROM EmployeeProjects ep
    );
