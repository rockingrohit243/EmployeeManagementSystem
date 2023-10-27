package com.springboot.employeemanagementsystem.Controller;

import com.springboot.employeemanagementsystem.Pojo.AddEmployeeRequest;
import com.springboot.employeemanagementsystem.Pojo.EmployeeResponse;
import com.springboot.employeemanagementsystem.Pojo.FetchAllEmployeeResponse;
import com.springboot.employeemanagementsystem.Pojo.FetchEmployeeWrapperResponse;
import com.springboot.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/fetchAllEmployees")
    FetchAllEmployeeResponse fetchAllEmployee()
    {
        return employeeService.fetchAllEmployee();
    }
    @PostMapping("/createEmployee")
    EmployeeResponse addEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest){
        return employeeService.createEmployee(addEmployeeRequest);
    }
    @GetMapping("fetchEmployeeById/{id}")
    FetchEmployeeWrapperResponse fetchEmployeeById(@PathVariable long id)
    {
        return employeeService.fetchEmployeeById(id);
    }
}
