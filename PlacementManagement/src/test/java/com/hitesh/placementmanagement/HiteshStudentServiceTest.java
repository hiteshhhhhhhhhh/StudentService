package com.hitesh.placementmanagement;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HiteshStudentServiceTest {

    @InjectMocks
    private HiteshStudentService studentService;

    @Mock
    private HiteshIStudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for retrieving a student successfully.
     */
    @Test
    public void testGetStudent_Success() {
        // Arrange
        HiteshStudent student = new HiteshStudent();
        when(studentRepository.findById((long) 1)).thenReturn(java.util.Optional.of(student));

        // Act
        HiteshStudent result = studentService.get(1);

        // Assert
        assertEquals(student, result);
    }

    /**
     * Failing test case for retrieving a student that does not exist.
     */
    @Test
    public void testGetStudent_NotFound() {
        // Arrange
        when(studentRepository.findById((long) 1)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            studentService.get(1);
        });
        assertEquals("Student not found with ID: 1", exception.getMessage());
    }

    /**
     * Test case for saving a student successfully.
     */
    @Test
    public void testSaveStudent_Success() {
        // Arrange
    	HiteshStudent student = new HiteshStudent();
        when(studentRepository.save(student)).thenReturn(student);

        // Act
        HiteshStudent result = studentService.save(student);

        // Assert
        assertEquals(student, result);
        verify(studentRepository).save(student);
    }
}
