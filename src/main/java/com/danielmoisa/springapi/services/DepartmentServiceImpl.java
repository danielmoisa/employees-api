package com.danielmoisa.springapi.services;

import com.danielmoisa.springapi.entities.Department;
import com.danielmoisa.springapi.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchSingleDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department newDepartment = departmentRepository.findById(departmentId).get();

        // Null and blank checks
        if(Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
            newDepartment.setName(department.getName());
        }

        if(Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
            newDepartment.setAddress(department.getAddress());
        }

        if(Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(department.getCode())) {
            newDepartment.setCode(department.getCode());
        }

        return departmentRepository.save((newDepartment));
    }
}
