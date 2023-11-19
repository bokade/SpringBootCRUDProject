package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;

public interface EmployeeService
{
    Employee updateEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(String id);
}
