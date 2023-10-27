package com.springboot.employeemanagementsystem.service;

import com.springboot.employeemanagementsystem.Pojo.AddEmployeeRequest;
import com.springboot.employeemanagementsystem.Pojo.EmployeeResponse;
import com.springboot.employeemanagementsystem.Pojo.FetchAllEmployeeResponse;

public interface EmployeeService {
    public FetchAllEmployeeResponse fetchAllEmployee();

    EmployeeResponse createEmployee(AddEmployeeRequest addEmployeeRequest);

    FetchAllEmployeeResponse fetchEmployeeById(long id);
}
