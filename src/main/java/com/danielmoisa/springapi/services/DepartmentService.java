package com.danielmoisa.springapi.services;

import com.danielmoisa.springapi.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchSingleDepartment(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Department department, Long departmentId);

}
