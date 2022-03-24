package com.danielmoisa.springapi.controllers;

import com.danielmoisa.springapi.entities.Department;
import com.danielmoisa.springapi.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = department.builder().name("test3").address("lorem address").code("IT").id(1L).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = department.builder().name("Test 1").address("Lorem address").code("IT").build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"name\": \"test3\",\n" +
                "    \"address\": \"lorem address\",\n" +
                "    \"code\": \"IT\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void singleDepartment() throws Exception {
        Mockito.when(departmentService.fetchSingleDepartment(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(department.getName()));
    }
}