package com.ukeess.service;

import com.ukeess.domain.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface DepartmentService {
    Collection<Department> findAll();
}
