package com.ukeess.service.impl;

import com.ukeess.domain.Department;
import com.ukeess.repository.DepartmentReposiroty;
import com.ukeess.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentReposiroty departmentReposiroty;

    @Autowired
    public DepartmentServiceImpl(DepartmentReposiroty departmentReposiroty) {
        this.departmentReposiroty = departmentReposiroty;
    }

    @Override
    public Collection<Department> findAll() {
        return (Collection<Department>) departmentReposiroty.findAll();
    }
}
