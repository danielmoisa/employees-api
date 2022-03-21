package com.danielmoisa.springapi.controllers;

import com.danielmoisa.springapi.entities.Department;
import com.danielmoisa.springapi.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/")
    public List<Department> listDepartments() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/{id}")
    public Department singleDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.fetchSingleDepartment(departmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department with id " + departmentId + " was deleted!";
    }
}
