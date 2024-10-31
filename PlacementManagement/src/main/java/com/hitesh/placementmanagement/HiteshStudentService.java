package com.hitesh.placementmanagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.placement.exceptions.StudentNotFoundException;
import com.hitesh.placement.exceptions.StudentServiceException;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HiteshStudentService implements HiteshIStudentService {

    @Autowired
    private HiteshIStudentRepository repo;

    @Override
    public List<HiteshStudent> getAllStudents() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new StudentServiceException("Failed to retrieve students");
        }
    }

    @Override
    public HiteshStudent getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> 
            new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!repo.existsById(id)) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new StudentServiceException("Failed to delete student");
        }
    }

	@Override
	public void addStudent(HiteshStudent student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HiteshStudent searchStudentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HiteshStudent searchStudentByHallTicket(long hallTicketNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(Long id, HiteshStudent student) {
		// TODO Auto-generated method stub
		
	}

	
	public HiteshStudent get(int i) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public HiteshStudent save(HiteshStudent student) {
		// TODO Auto-generated method stub
		return null;
	}

    // Other methods here...
}
