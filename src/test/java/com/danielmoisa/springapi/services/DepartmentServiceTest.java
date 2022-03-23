package com.danielmoisa.springapi.services;

import com.danielmoisa.springapi.entities.Department;
import com.danielmoisa.springapi.errors.NotFoundException;
import com.danielmoisa.springapi.repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().name("Test1").address("Lorem address").code("IT-CTC").id(1L).build();

        Mockito.when(departmentRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Find and get single department by id")
    public void fetchDepartmentById() throws NotFoundException {
        Long departmentId = 1L;
        Department found = departmentService.fetchSingleDepartment(departmentId);
        assertEquals(departmentId, found.getId());
    }
}