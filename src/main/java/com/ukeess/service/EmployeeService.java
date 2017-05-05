package com.ukeess.service;

import com.ukeess.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    Page<Employee> getEmployees(Pageable pageable);

    Employee getEmployeeById(Integer id);

    Page<Employee> findByEmpNameStartsWith(String empName, Pageable pageable);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
