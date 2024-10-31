package com.hitesh.placementmanagement;

import com.hitesh.placement.exceptions.StudentNotFoundException;
import com.hitesh.placement.exceptions.StudentServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class HiteshStudentServiceTest {

    @InjectMocks
    private HiteshStudentService service;

    @Mock
    private HiteshIStudentRepository repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllStudents_Success() {
        service.getAllStudents();
        verify(repo, times(1)).findAll();
    }

    @Test
    void getStudentById_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        when(repo.findById(1L)).thenReturn(Optional.of(student));

        HiteshStudent foundStudent = service.getStudentById(1L);
        assertEquals("Alice", foundStudent.getName());
    }

    @Test
    void getStudentById_NotFound() {
        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> {
            service.getStudentById(1L);
        });
    }

    @Test
    void addStudent_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        service.addStudent(student);
        verify(repo, times(1)).save(student);
    }

    @Test
    void updateStudent_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        when(repo.findById(1L)).thenReturn(Optional.of(student));

        service.updateStudent(1L, student);
        verify(repo, times(1)).save(student);
    }

    @Test
    void deleteStudent_Success() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        when(repo.findById(1L)).thenReturn(Optional.of(student));

        service.deleteStudent(1L);
        verify(repo, times(1)).deleteById(1L);
    }
}
