package com.ebay.controller;

import com.ebay.entity.Employee;
import com.ebay.entity.UpdateEmployeeRequest;
import com.ebay.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService  employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") String id) {
        return employeeService.getEmployeeById(id);
    }


    @GetMapping( "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
                                                @RequestParam(name = "lastName", required = false) String lastName) {
        System.out.println(firstName + " " +  lastName);
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping("save-employee")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployeeById(@PathVariable(name = "id") String id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name = "id") String id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeService.updateEmployee(id, updateEmployeeRequest);
    }














}
