package com.hitesh.placementmanagement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HiteshStudentServiceTest {

    @InjectMocks
    private HiteshStudentService service;

    @Mock
    private HiteshIStudentRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudents() {
        HiteshStudent student1 = new HiteshStudent(5, 12345L, "Hari", "Computer Science", 2022, "BTech", 1001L);
        HiteshStudent student2 = new HiteshStudent(2L, 67890L, "Ram", "Electrical Engineering", 2023, "MTech", 1002L);

        when(repository.findAll()).thenReturn(Arrays.asList(student1, student2));

        var result = service.getAllStudents();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testAddStudent() {
        HiteshStudent student = new HiteshStudent(3L, 34567L, "Raju", "Mechanical Engineering", 2024, "PhD", 1003L);

        service.addStudent(student);

        verify(repository, times(1)).save(student);
    }

    @Test
    void testGetStudentById_ExistingStudent() {
        HiteshStudent student = new HiteshStudent(1L, 12345L, "Hari", "Computer Science", 2022, "BTech", 1001L);

        when(repository.findById(1L)).thenReturn(Optional.of(student));

        var result = service.getStudentById(1L);

        assertNotNull(result);
        assertEquals("Hari", result.getStudent_name());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetStudentById_NonExistingStudent() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        var result = service.getStudentById(99L);

        assertNull(result);
        verify(repository, times(1)).findById(99L);
    }

    @Test
    void testDeleteStudent_ExistingStudent() {
        HiteshStudent student = new HiteshStudent(1L, 12345L, "Hari", "Computer Science", 2022, "BTech", 1001L);

        when(repository.findById(1L)).thenReturn(Optional.of(student));

        service.deleteStudent(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteStudent_NonExistingStudent() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        service.deleteStudent(99L);

        verify(repository, times(0)).deleteById(99L); // Ensure no deletion occurs
    }

    @Test
    void testSearchStudentByHallTicket_ExistingStudent() {
        HiteshStudent student = new HiteshStudent(1L, 12345L, "Hari", "Computer Science", 2022, "BTech", 1001L);

        when(repository.findByHallTicketNo(1001L)).thenReturn(Optional.of(student));

        var result = service.searchStudentByHallTicket(1001L);

        assertNotNull(result);
        assertEquals("Alice", result.getStudent_name());
        verify(repository, times(1)).findByHallTicketNo(1001L);
    }

    @Test
    void testSearchStudentByHallTicket_NonExistingStudent() {
        when(repository.findByHallTicketNo(9999L)).thenReturn(Optional.empty());

        var result = service.searchStudentByHallTicket(9999L);

        assertNull(result);
        verify(repository, times(1)).findByHallTicketNo(9999L);
    }
}
