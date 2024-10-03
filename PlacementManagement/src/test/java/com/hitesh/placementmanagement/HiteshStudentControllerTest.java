package com.hitesh.placementmanagement;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(HiteshStudentController.class)
class HiteshStudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private HiteshStudentController controller;

    @Mock
    private HiteshStudentService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllStudents() throws Exception {
        HiteshStudent student1 = new HiteshStudent(1L, 12345L, "Hari", "Computer Science", 2022, "BTech", 1001L);
        HiteshStudent student2 = new HiteshStudent(2L, 67890L, "Raju", "Electrical Engineering", 2023, "MTech", 1002L);

        when(service.getAllStudents()).thenReturn(Arrays.asList(student1, student2));

        mockMvc.perform(get("/hitesh_student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].student_name").value("Hari"))
                .andExpect(jsonPath("$[1].student_name").value("Raju"));
    }

    @Test
    void testAddStudent() throws Exception {
        HiteshStudent student = new HiteshStudent(3L, 34567L, "Ram", "Mechanical Engineering", 2024, "PhD", 1003L);

        mockMvc.perform(post("/hitesh_student")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"student_id\":3,\"roll_no\":34567,\"student_name\":\"Ram\",\"course\":\"Mechanical Engineering\",\"year\":2024,\"qualification\":\"PhD\",\"hallTicketNo\":1003}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Student added successfully!"));
    }

    @Test
    void testGetStudentById_Found() throws Exception {
        HiteshStudent student = new HiteshStudent(1L, 12345L, "Hari", "Computer Science", 2022, "BTech", 1001L);

        when(service.getStudentById(1L)).thenReturn(student);

        mockMvc.perform(get("/hitesh_student/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.student_name").value("Hari"));
    }

    @Test
    void testGetStudentById_NotFound() throws Exception {
        when(service.getStudentById(99L)).thenReturn(null);

        mockMvc.perform(get("/hitesh_student/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteStudent_Found() throws Exception {
        HiteshStudent student = new HiteshStudent(1L, 12345L, "Hari", "Computer Science", 2022, "BTech", 1001L);

        when(service.getStudentById(1L)).thenReturn(student);

        mockMvc.perform(delete("/hitesh_student/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Student deleted successfully!"));
    }

    @Test
    void testDeleteStudent_NotFound() throws Exception {
        when(service.getStudentById(99L)).thenReturn(null);

        mockMvc.perform(delete("/hitesh_student/99"))
                .andExpect(status().isNotFound());
    }
}
