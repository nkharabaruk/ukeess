package com.ukeess.service.impl;

import com.ukeess.domain.Employee;
import com.ukeess.repository.EmployeeRepository;
import com.ukeess.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Page<Employee> findByEmpNameStartsWith(String empName, Pageable pageable) {
        return employeeRepository.findByEmpNameStartsWith(empName, pageable);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.delete(id);
    }
}
