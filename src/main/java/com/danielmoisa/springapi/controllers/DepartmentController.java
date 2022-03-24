package com.danielmoisa.springapi.controllers;

import com.danielmoisa.springapi.entities.Department;
import com.danielmoisa.springapi.errors.NotFoundException;
import com.danielmoisa.springapi.services.DepartmentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("New department was created!");
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(
            @RequestBody Department department,
            @PathVariable("id") Long departmentId
    ) {
        return departmentService.updateDepartment(department, departmentId);
    }

    @GetMapping("")
    public List<Department> listDepartments() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/{id}")
    public Department singleDepartment(@PathVariable("id") Long departmentId) throws NotFoundException {
        return departmentService.fetchSingleDepartment(departmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department with id " + departmentId + " was deleted!";
    }
}
