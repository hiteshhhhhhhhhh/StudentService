package com.hitesh.placementmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test") // Uses the application-test.properties for in-memory DB setup
class HiteshIStudentRepositoryTest {

    @Autowired
    private HiteshIStudentRepository repo;

    @Test
    void saveAndRetrieveStudent() {
        HiteshStudent student = new HiteshStudent(1L, null, "Alice", null, 0, null, null);
        repo.save(student);

        Optional<HiteshStudent> retrieved = repo.findById(1L);
        assertTrue(retrieved.isPresent());
        assertEquals("Alice", retrieved.get().getName());
    }

    @Test
    void deleteStudent() {
        HiteshStudent student = new HiteshStudent(2L, null, "Bob", null, 0, null, null);
        repo.save(student);
        repo.deleteById(2L);

        Optional<HiteshStudent> deletedStudent = repo.findById(2L);
        assertTrue(deletedStudent.isEmpty());
    }
}
