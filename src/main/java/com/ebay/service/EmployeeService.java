package com.ebay.service;

import com.ebay.entity.Employee;
import com.ebay.entity.UpdateEmployeeRequest;
import com.ebay.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository  employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public List<Employee> addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public boolean deleteEmployeeById(String id) {
        return employeeRepository.deleteEmployeeById(id);
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeRepository.updateEmployee(id, updateEmployeeRequest);
    }
}
