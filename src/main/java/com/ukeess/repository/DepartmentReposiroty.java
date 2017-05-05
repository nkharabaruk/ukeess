package com.ukeess.repository;

import com.ukeess.domain.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentReposiroty extends PagingAndSortingRepository <Department, Integer> {
}
