package com.danielmoisa.springapi.services;

import com.danielmoisa.springapi.entities.Department;
import com.danielmoisa.springapi.errors.NotFoundException;
import com.danielmoisa.springapi.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    public Department fetchSingleDepartment(Long departmentId) throws NotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {
            throw new NotFoundException(("Department not found!"));
        }

        return department.get();
    }

    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

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
