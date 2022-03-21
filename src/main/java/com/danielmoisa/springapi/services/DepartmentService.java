package com.danielmoisa.springapi.services;

import com.danielmoisa.springapi.entities.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchSingleDepartment(Long departmentId);

    public void deleteDepartmentById(Long departmentId);
}
