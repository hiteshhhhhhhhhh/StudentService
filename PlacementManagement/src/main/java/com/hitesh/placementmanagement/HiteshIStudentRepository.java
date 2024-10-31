package com.hitesh.placementmanagement;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for HiteshStudent entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface HiteshIStudentRepository extends JpaRepository<HiteshStudent, Long> {

    /**
     * Finds a student by their hall ticket number.
     *
     * @param hallTicketNo the hall ticket number of the student
     * @return an Optional containing the found student, or empty if not found
     */
    Optional<HiteshStudent> findByHallTicketNo(long hallTicketNo);
}
