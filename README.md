Employee Management System in Java

This Java project is an advanced Employee Management System designed to meet specific requirements. The system is built with a modular structure, allowing for the representation of individuals, contract management, salary calculation, and project tracking.

Java Components

1. Person Class
The Person class serves as an abstract representation of common properties for employees and other individuals. It provides methods for accessing and updating the name, age,... of individuals.

2. ContractDepartment Interface
The ContractDepartment interface prescribes methods for managing contract details, including entry date, contract duration, and notice period. This interface is implemented in the Employee class.

3. Employee Class
The Employee class extends the Person class and implements the ContractDepartment interface. It introduces a mechanism for salary calculation, allowing for different salary formulas based on the employee's position. Additionally, it includes functionality for managing multiple projects.

4. Project Class
The Project class stores information about ongoing projects. Each employee can be involved in multiple projects. The Employee class maintains a list of projects, and methods are implemented for adding and removing projects.

5. Test Class
A test class is provided to demonstrate the functionalities of the Employee Management System. It creates several employees with different positions, assigns them to projects, and displays relevant employee information.

SQL Query Tasks

The project also includes SQL query tasks for a complex Employee Management System database. The tasks involve retrieving employee data, calculating average salary rates per position, updating employee salaries based on project budgets, and deleting specific employee records.

Notes:

The SQL queries consider foreign key relationships between tables.
JOINs, aggregate functions, and transactions are utilized to accomplish the tasks.
Feel free to explore and extend this Employee Management System for your specific needs. The modular design allows for easy customization and integration with existing systems.

Getting Started

Clone the repository to your local machine.
Open the Java project in your preferred IDE.
Run the test class to see the Employee Management System in action.
Database Setup (SQL)

Execute the SQL queries provided in the respective database management system.
Enjoy managing your employees with this comprehensive Employee Management System!

