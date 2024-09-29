package com.hitesh.placementmanagement;

	import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

	public interface HiteshIStudentRepository extends JpaRepository<HiteshStudent, Long> {

		Optional<HiteshStudent> findByHallTicketNo(long hallTicketNo);


}
