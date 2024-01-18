package com.employee.management.system;

/**
 * The EmployeeManagementSystem class demonstrates the functionality of the employee management system.
 * It creates employees, projects, assigns projects to employees, and showcases various operations within the system.
 */

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        Employee employee1 = new Employee(1, 
                                          "Jane Doe", 
                                          23, 
                                          "50 Garden st",
                                          "jane.doe@example.com", 
                                          "27-04-2016", 
                                          12, 
                                          14);

        Employee employee2 = new Employee(2, 
                                          "John Doe", 
                                          22, 
                                          "50 Nile st", 
                                          "john.doe@example.com", 
                                          "29-07-2011",
                                          12, 
                                          14);

        Project project1 = new Project(1, 
                                       "Employment Management System", 
                                       5, 
                                       "18-01-2024");

        Project project2 = new Project(2, 
                                       "Bookstore Management System", 
                                       22, 
                                       "01-01-2021");

        Project project3 = new Project(3, 
                                       "Pharmacy Management System", 
                                       32, 
                                       "11-12-2020");

        Project project4 = new Project(4, 
                                       "Factory Management System", 
                                       30, 
                                       "10-8-2022");

        // Assign projects to employees
        employee1.addProject(project1);
        employee1.addProject(project4);
        employee1.addProject(project3);
        employee2.addProject(project2);
        employee2.addProject(project3);
        employee2.addProject(project4);

        // Display employee details
        employee1.displayDetails();
        employee2.displayDetails();

        // Calculate and display salaries
        employee1.calculateSalary(EmployeePosition.JUNIOR, 10000, 0.10);
        employee1.calculateSalary(EmployeePosition.QUALITYASSURANCE, 20000, 0.14);

        // Remove a project
        employee2.removeProject(project1);


    }

}
