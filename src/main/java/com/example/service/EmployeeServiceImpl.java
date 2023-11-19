package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;
import com.example.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        Employee employee = getEmployeeById(employeeDto.getId());
        BeanUtils.copyProperties(employeeDto,employee);
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id)
    {
        return employeeRepo.findById(id).get();
    }
}
