package com.employee.management.system;

/**
* The Person class is an abstract class representing common properties of individuals,
* such as their identity, name, age, address, and email.
*/

public abstract class Person {
    
    private int id;
    private String name;
    private int age;
    private String address;
    private String email;
    
    /**
    * Constructs a new person with the specified attributes.
    *
    * @param id      The unique identifier for the person.
    * @param name    The name of the person.
    * @param age     The age of the person.
    * @param address The address of the person.
    * @param email   The email address of the person.
    */
    
    public Person(int id, String name, int age, String address, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }
    
    //Getters And Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract void displayDetails();
}

