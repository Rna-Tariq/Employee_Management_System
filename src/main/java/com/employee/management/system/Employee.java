package com.employee.management.system;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.List;

/**
* The Employee class represents an individual within an employee management system.
* It extends the Person class and implements the ContractDepartment interface.
* It encapsulates attributes such as entry date, contract duration, notice period, and projects.
*/

public class Employee extends Person implements ContractDepartment {
    
    private String entryDate;
    private int contractDuration;
    private int noticePeriod;
    private List<Project> projects;
    
    /**
    * Constructs a new employee with the specified attributes.
    *
    * @param id               The unique identifier for the employee.
    * @param name             The name of the employee.
    * @param age              The age of the employee.
    * @param address          The address of the employee.
    * @param email            The email address of the employee.
    * @param entryDate        The entry date of the employee.
    * @param contractDuration The duration of the employee's contract.
    * @param noticePeriod     The notice period required by the employee.
    */
    
    public Employee(int id, 
                    String name, 
                    int age, 
                    String address, 
                    String email, 
                    String entryDate, 
                    int contractDuration, 
                    int noticePeriod) 
    {
        super(id, name, age, address, email);
        this.entryDate = entryDate;
        this.contractDuration = contractDuration;
        this.noticePeriod = noticePeriod;
        this.projects = new ArrayList<>();
    }
    
    
    //Getters And Setters
    @Override
    public String getEntryDate() {
        return entryDate;
    }
    
    @Override
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
    
    @Override
    public int getContractDuration() {
        return contractDuration;
    }
    
    @Override 
    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }
    
    @Override
    public int getNoticePeriod() {
        return noticePeriod;
    }
    
    @Override
    public void setNoticePeriod(int noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    /**
     * Abstract method to display details of the Employee.
     */
    
    @Override
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + getId());
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee Age " + getAge());
        System.out.println("Employee Address: " + getAddress());
        System.out.println("Employee Email: " + getEmail());
        System.out.println("Entry Data: " + getEntryDate());
        System.out.println("Contract Duration: " + getContractDuration() + " months");
        System.out.println("Notice Period: " + getNoticePeriod() + " days");
        System.out.println("projects: ");
        
        for (Project project : projects) {
            System.out.println("-" + project.getProjectName());
            System.out.println("Number of tasks " + project.getNumberOfTasks());
            System.out.println("Due Date: " + project.getDeadline());
        }
        
        System.out.println("--------------------------");
    }
    
    /**
    * Validates if a given string corresponds to a valid enum value in the EmployeePosition enum.
    *
    * @param enumValue The string to be validated.
    * @return true if the string is a valid enum value, false otherwise.
    */
    
    public static boolean isValidEnum(String enumValue) {
        try {
            EmployeePosition employeePosition = EmployeePosition.valueOf(enumValue.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
        
    }
    
    /**
    * Calculates the net salary of the employee based on the gross salary and tax rate.
    * Prints the result to the console.
    *
    * @param employeePosition The position of the employee.
    * @param grossSalary       The gross salary of the employee.
    * @param tax               The tax rate applied to the gross salary.
    */
    
    public void calculateSalary(EmployeePosition employeePosition, double grossSalary, double tax) {
        double netSalary= grossSalary - (grossSalary * tax);
        
        if (isValidEnum(employeePosition.name())) {
             System.out.println("Net salary for: " + employeePosition + " is: "+ netSalary);
        }
        else {
            System.err.println("Invalid employee position: " + employeePosition);
        }
        
    }
    /**
    * Adds a project to the list of projects the employee is involved in.
    *
    * @param project The project to be added.
    */
    
    public void addProject(Project project) {
        projects.add(project);
    }  
    
    /**
    * Removes a project from the list of projects the employee is involved in.
    * Prints a message to the console if the project is successfully removed.
    *
    * @param project The project to be removed.
    */
    
    public void removeProject(Project project) {
        if (project == NULL) {
            System.err.println("PROJECT YOU ARE TRYING TO REMOVE DOES NOT EXIST ");
        }
        else {
            projects.remove(project);
            System.out.println("Project " + project.getProjectName() + " is removed successfully");
        }
    }
    
}
