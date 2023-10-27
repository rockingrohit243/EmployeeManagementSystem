package com.springboot.employeemanagementsystem.ServiceImpl;

import com.springboot.employeemanagementsystem.Entity.Employee;
import com.springboot.employeemanagementsystem.Pojo.AddEmployeeRequest;
import com.springboot.employeemanagementsystem.Pojo.EmployeeResponse;
import com.springboot.employeemanagementsystem.Pojo.FetchAllEmployeeResponse;
import com.springboot.employeemanagementsystem.Pojo.FetchEmployeeWrapperResponse;
import com.springboot.employeemanagementsystem.Repository.EmployeeRepository;
import com.springboot.employeemanagementsystem.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final
    EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public FetchAllEmployeeResponse fetchAllEmployee() {
        FetchAllEmployeeResponse fetchAllEmployeeResponse = new FetchAllEmployeeResponse();
        List<Employee> listOfFetchEmployee;
        try {
            listOfFetchEmployee = employeeRepository.findAll();
        } catch (Exception exception)
        {
            fetchAllEmployeeResponse.setStatus(-1);
            fetchAllEmployeeResponse.setStatusDesc("Unable to fetch  any Employees");
            return fetchAllEmployeeResponse;
        }
        if (listOfFetchEmployee.isEmpty())
        {
            fetchAllEmployeeResponse.setStatus(-1);
            fetchAllEmployeeResponse.setStatusDesc("No Employees present!!!");
        }
        else {
            fetchAllEmployeeResponse.setStatus(0);
            fetchAllEmployeeResponse.setStatusDesc("Employees fetched successfully.");
//            fetchAllEmployeeResponse.setData(listOfFetchEmployee);
        }
        return fetchAllEmployeeResponse;
    }

    @Override
    public EmployeeResponse createEmployee(AddEmployeeRequest addEmployeeRequest) {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        Employee employee = modelMapper.map(addEmployeeRequest, Employee.class);
        try{
            employeeRepository.save(employee);
        }
        catch (Exception exception)
        {
            employeeResponse.setStatus(-1);
            employeeResponse.setStatusDesc("Unable to add employee.");
            return employeeResponse;
        }
        employeeResponse.setStatus(0);
        employeeResponse.setStatusDesc("Employee successfully Added. ");
        return employeeResponse;
    }

    @Override
    public FetchAllEmployeeResponse fetchEmployeeById(long id) {
        FetchAllEmployeeResponse fetchEmployeeByIdResponse = new FetchAllEmployeeResponse();
        Optional<Employee> employeeEntity;
        try {
            employeeEntity = employeeRepository.findById(id);
        } catch (Exception exception) {
            fetchEmployeeByIdResponse.setStatus(-1);
            fetchEmployeeByIdResponse.setStatusDesc("Unable to fetch by requested ID.");
            return fetchEmployeeByIdResponse;
        }
        FetchEmployeeWrapperResponse fetchEmployeeWrapperResponse = modelMapper.map(employeeEntity,FetchEmployeeWrapperResponse.class);
        fetchEmployeeByIdResponse.setFetchEmployeeByIdResponse(fetchEmployeeWrapperResponse);
        fetchEmployeeByIdResponse.setStatus(0);
        fetchEmployeeByIdResponse.setStatusDesc("Employee fetched successfully.");
        return fetchEmployeeByIdResponse;
    }
}
