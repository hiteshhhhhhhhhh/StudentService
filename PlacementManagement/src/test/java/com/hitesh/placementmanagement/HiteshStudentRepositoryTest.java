package com.hitesh.placementmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class HiteshStudentRepositoryTest {

    @Autowired
    private HiteshStudentRepositoryTest studentRepository;

    /**
     * Test case for saving a student successfully.
     */
    @Test
    public void testSaveStudent_Success() {
        // Arrange
        HiteshStudent student = new HiteshStudent();
        
        // Act
        HiteshStudent savedStudent = studentRepository.save(student);

        // Assert
        assertNotNull(savedStudent.getId());
        assertEquals(student.getName(), savedStudent.getName());
        assertEquals(student.getRoll_no(), savedStudent.getRoll_no());
        //assertEquals(student.getDepartment(), savedStudent.getDepartment());
    }

    private HiteshStudent save(HiteshStudent student) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Failing test case for retrieving a non-existent student.
     */
    @Test
    public void testFindById_NotFound() {
        // Act
        Optional<HiteshStudent> student = studentRepository.findById(99);

        // Assert
        assertFalse(student.isPresent());
    }

	private Optional<HiteshStudent> findById(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}