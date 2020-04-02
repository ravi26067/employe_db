package com.eployees.data.employe_db.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeDetails {
    //ID, NAME, AGE, ADDRESS, SALARY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE", nullable = false)
    private int age;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "SALARY", nullable = false)
    private double salary;

    public EmployeeDetails() {
    }

    public EmployeeDetails(String name,int age,String address,double salary) {
         this.name = name;
         this.age = age;
         this.address = address;
         this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
