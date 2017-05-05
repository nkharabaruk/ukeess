package com.ukeess.repository;

import com.ukeess.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    Page<Employee> findByEmpNameStartsWith(String empName, Pageable pageRequest);

}
