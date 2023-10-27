package com.springboot.employeemanagementsystem.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String emailAddress;
    private Long phoneNumber;
    private String address;
    private String department;
    private String jobTitle;
    private double salary;
    private Date dateOfHire;
    private String supervisor;
    private String employmentStatus;
    private String employeeType;
    private String emergencyContact;
    private String workLocation;
    private String skillsAndQualifications;
}
