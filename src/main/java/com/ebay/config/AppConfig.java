package com.ebay.config;

import com.ebay.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1","Jack", "Bauer"));
        employees.add(new Employee("2","John", "Doe"));
        employees.add(new Employee("3","Jane", "Doe"));
        employees.add(new Employee("4","John", "Bauer"));
        employees.add(new Employee("5","Jane", "Bauer"));
        employees.add(new Employee("6","Emru", "Baykara"));
        employees.add(new Employee("7", "Emrullah", "Baykara"));
        employees.add(new Employee("8","Diana", "Baykara"));
        employees.add(new Employee("9","Diana", "Taranovich"));
        return employees;
    }
}
