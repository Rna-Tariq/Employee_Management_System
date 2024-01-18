package com.employee.management.system;


/**
* The Project class represents an ongoing project within an employee management system.
* It encapsulates attributes such as project name, number of tasks, and deadline.
*/

public class Project {
    
    private int id;
    private String projectName;
    private int numberOfTasks;
    private String deadline;

    /**
    * Constructs a new project with the specified attributes.
    *
    * @param id            The unique identifier for the project.
    * @param projectName   The name of the project.
    * @param numberOfTasks The number of tasks associated with the project.
    * @param deadline      The deadline for the project.
    */
    
    public Project(int id, String projectName, int numberOfTasks, String deadline) {
        this.id = id;
        this.projectName = projectName;
        this.numberOfTasks = numberOfTasks;
        this.deadline = deadline;
    }
    
    //Getters And Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectnName(String projectName) {
        this.projectName = projectName;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(int tasks) {
        this.numberOfTasks = tasks;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
}
