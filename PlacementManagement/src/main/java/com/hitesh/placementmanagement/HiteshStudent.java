package com.hitesh.placementmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing a student in the placement management system.
 */
@Entity
@Table(name = "hitesh_student")
public class HiteshStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Changed to IDENTITY for auto-generated IDs
    private Long student_id; // Use Long to allow null values
    private Long roll_no; // Use Long to allow null values
    private String student_name;
    private String course;
    private int year;
    private String qualification;
    private Long hallTicketNo; // Use Long to allow null values

    // Constructors

    /**
     * Default constructor for HiteshStudent.
     */
    public HiteshStudent() {
        super();
    }

    /**
     * Parameterized constructor for HiteshStudent.
     *
     * @param student_id the unique ID of the student
     * @param roll_no the roll number of the student
     * @param student_name the name of the student
     * @param course the course the student is enrolled in
     * @param year the year of the student's course
     * @param qualification the student's qualification
     * @param hallTicketNo the hall ticket number of the student
     */
    public HiteshStudent(Long student_id, Long roll_no, String student_name, String course, int year, String qualification, Long hallTicketNo) {
        super();
        this.student_id = student_id;
        this.roll_no = roll_no;
        this.student_name = student_name;
        this.course = course;
        this.year = year;
        this.qualification = qualification;
        this.hallTicketNo = hallTicketNo;
    }

    // Getters and Setters

    public Long getId() {
        return student_id;
    }

    public void setId(Long student_id) {
        this.student_id = student_id;
    }

    public Long getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(Long roll_no) {
        this.roll_no = roll_no;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Long getHallTicketNo() {
        return hallTicketNo;
    }

    public void setHallTicketNo(Long hallTicketNo) {
        this.hallTicketNo = hallTicketNo;
    }

    // Overridden toString method

    @Override
    public String toString() {
        return new StringBuilder("HiteshStudent [")
                .append("student_id=").append(student_id)
                .append(", roll_no=").append(roll_no)
                .append(", student_name=").append(student_name)
                .append(", course=").append(course)
                .append(", year=").append(year)
                .append(", qualification=").append(qualification)
                .append(", hallTicketNo=").append(hallTicketNo)
                .append("]")
                .toString();
    }

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
