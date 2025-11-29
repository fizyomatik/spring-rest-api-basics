package com.ebay.repository;

import com.ebay.entity.Employee;
import com.ebay.entity.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        for(Employee employee : getAllEmployees()){
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employeeWithParams.add(employee);
            } else if (firstName == null && lastName.equals(employee.getLastName())) {
                employeeWithParams.add(employee);
            } else if (lastName == null && firstName.equals(employee.getFirstName()) ) {
                employeeWithParams.add(employee);
            }
        }
        return employeeWithParams;
    }

    public List<Employee> addEmployee(Employee employee) {
        for (Employee employee1 : employeeList) {
            if (employee.getFirstName().equals(employee1.getFirstName()) && employee.getLastName().equals(employee1.getLastName())) {
                return employeeList;
            }else {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public boolean deleteEmployeeById(String id) {
        Employee deleteEmployee = null;
        for (Employee employee: employeeList) {
            if (employee.getId().equals(id)) {
                deleteEmployee = employee;
                break;
            }
        }
        if (deleteEmployee != null) {
            employeeList.remove(deleteEmployee);
        }
        return false;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployeeRequest) {
        Employee wantedEmployee = findEmployeeById(id);
        if (wantedEmployee != null) {
            deleteEmployeeById(id);

            Employee updatedEmployee = new  Employee();
            updatedEmployee.setId(id);
            updatedEmployee.setFirstName(updateEmployeeRequest.getFirstName());
            updatedEmployee.setLastName(updateEmployeeRequest.getLastName());

            employeeList.add(updatedEmployee);
            return updatedEmployee;
        }
        return null;
    }

    /**
     * helper method
     * @param id is the id of employee who will be updated.
     * @return updated employee
     */
    private Employee findEmployeeById(String id) {
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
}












