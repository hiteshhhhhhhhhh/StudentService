/*
 * package com.hitesh.placementmanagement;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.hitesh.placementmanagement.HiteshStudent; import
 * com.hitesh.placementmanagement.HiteshIStudentRepository;
 * 
 * @Service public abstract class HiteshStudentService implements
 * HiteshIStudentService {
 * 
 * @Autowired HiteshIStudentRepository repo;
 * 
 * @Override public List<HiteshStudent> getAllStudents() { return
 * repo.findAll(); }
 * 
 * @Override public void addStudent(HiteshStudent s) { repo.save(s); }
 * 
 * @Override public HiteshStudent getStudentById(Long id) { return
 * repo.findById(id).get(); }
 * 
 * @Override public void updateStudent(Long id, HiteshStudent s) { if
 * (repo.findById(id).isPresent()) { repo.save(s); } else {
 * System.out.println("Record not found"); } }
 * 
 * @Override public void deleteStudent(Long id) { repo.deleteById(id); } }
 */
package com.hitesh.placementmanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class HiteshStudentService implements HiteshIStudentService {

    @Autowired
    HiteshIStudentRepository repo;

    @Override
    public List<HiteshStudent> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public void addStudent(HiteshStudent s) {
        repo.save(s);
    }

    @Override
    public HiteshStudent getStudentById(Long id) {
        Optional<HiteshStudent> student = repo.findById(id);
        return student.orElse(null); // Returns null if not found, handle this in the controller
    }

    @Override
    public void updateStudent(Long id, HiteshStudent s) {
        if (repo.findById(id).isPresent()) {
            s.setId(id); // Ensures the ID remains the same
            repo.save(s);
        } else {
            System.out.println("Record not found");
        }
    }

    @Override
    public void deleteStudent(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            System.out.println("Record not found");
        }
    }

	@Override
	public HiteshStudent searchStudentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchStudentByHallTicket(long hallTicketNo) {
		// TODO Auto-generated method stub
		
	}
	
}
