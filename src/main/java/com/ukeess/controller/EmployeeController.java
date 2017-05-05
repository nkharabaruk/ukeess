package com.ukeess.controller;

import com.ukeess.domain.Employee;
import com.ukeess.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200", methods = {
        RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Employee> getAllEmployees(@RequestParam(value = "page", required = false) Integer pageNumber,
                                          @RequestParam(value = "size", required = false) Integer pageSize) {
        return employeeService.getEmployees(new PageRequest(pageNumber, pageSize));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Page<Employee> getEmployeesByNameStartsWith(@RequestParam(value = "empName") String empName,
                                                       @RequestParam(value = "page", required = false) Integer pageNumber,
                                                       @RequestParam(value = "size", required = false) Integer pageSize) {
        return employeeService.findByEmpNameStartsWith(empName, new PageRequest(pageNumber, pageSize));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEmployeeById(@PathVariable("id") Integer id) {
        employeeService.deleteEmployeeById(id);
    }
}
