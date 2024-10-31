package com.hitesh.placementmanagement;

import com.hitesh.placement.exceptions.StudentNotFoundException;
import com.hitesh.placement.exceptions.StudentServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class HiteshStudentControllerTest {

    @InjectMocks
    private HiteshStudentController controller;

    @Mock
    private HiteshIStudentService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllStudents_Success() {
        List<HiteshStudent> students = Arrays.asList(new HiteshStudent(1L, null, "Alice", null, 0, null, null), new HiteshStudent(2L, null, "Bob", null, 0, null, null));
        when(service.getAllStudents()).thenReturn(students);

        ResponseEntity<List<HiteshStudent>> response = (ResponseEntity<List<HiteshStudent>>) controller.getAllStudents();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(students, response.getBody());
    }

    @Test
    void getAllStudents_ServiceException() {
        when(service.getAllStudents()).thenThrow(new StudentServiceException("Failed to retrieve students"));

        ResponseEntity<?> response = controller.getAllStudents();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Failed to retrieve students", response.getBody());
    }

    @Test
    void getStudentById_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        when(service.getStudentById(1L)).thenReturn(student);

        ResponseEntity<HiteshStudent> response = (ResponseEntity<HiteshStudent>) controller.getStudentById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    void getStudentById_NotFound() {
        when(service.getStudentById(1L)).thenThrow(new StudentNotFoundException("Student not found"));

        ResponseEntity<?> response = controller.getStudentById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Student not found", response.getBody());
    }

    @Test
    void addStudent_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        ResponseEntity<String> response = controller.addStudent(student);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Student added successfully!", response.getBody());
    }

    @Test
    void updateStudent_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "John", null, 0, null, null);
        when(service.getStudentById(1L)).thenReturn(student);

        ResponseEntity<String> response = controller.updateStudent(1L, student);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student updated successfully!", response.getBody());
    }

    @Test
    void deleteStudent_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        when(service.getStudentById(1L)).thenReturn(student);

        ResponseEntity<String> response = controller.deleteStudent(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student deleted successfully!", response.getBody());
    }
}
