package com.springboot.employeemanagementsystem.Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class FetchEmployeeWrapperResponse {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String emailAddress;
    private Long phoneNumber;
    private String address;
    private String department;
    private String jobTitle;
    private String salary;
    private String dateOfHire;
    private String supervisor;
    private String employmentStatus;
    private String employeeType;
    private String emergencyContact;
    private String workLocation;
    private String skillsAndQualifications;


}
