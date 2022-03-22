package com.danielmoisa.springapi.services;

import com.danielmoisa.springapi.entities.Department;
import com.danielmoisa.springapi.errors.NotFoundException;

import java.io.NotActiveException;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchSingleDepartment(Long departmentId) throws NotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Department department, Long departmentId);

}
