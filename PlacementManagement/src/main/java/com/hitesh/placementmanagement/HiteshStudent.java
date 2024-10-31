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
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long student_id;
    private long roll_no;
    private String student_name;
    private String course;
    private int year;
    private String qualification;
    private long hallTicketNo;

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
    public HiteshStudent(long student_id, long roll_no, String student_name, String course, int year, String qualification,
                         long hallTicketNo) {
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

    /**
     * Retrieves the unique ID of the student.
     *
     * @return the student ID
     */
    public long getStudent_id() {
        return student_id;
    }

    /**
     * Sets the unique ID of the student.
     *
     * @param student_id the student ID to set
     */
    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    /**
     * Retrieves the roll number of the student.
     *
     * @return the roll number
     */
    public long getRoll_no() {
        return roll_no;
    }

    /**
     * Sets the roll number of the student.
     *
     * @param roll_no the roll number to set
     */
    public void setRoll_no(long roll_no) {
        this.roll_no = roll_no;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return the student's name
     */
    public String getStudent_name() {
        return student_name;
    }

    /**
     * Sets the name of the student.
     *
     * @param student_name the student's name to set
     */
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    /**
     * Retrieves the course the student is enrolled in.
     *
     * @return the course name
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets the course the student is enrolled in.
     *
     * @param course the course name to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Retrieves the year of the student's course.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the student's course.
     *
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retrieves the qualification of the student.
     *
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Sets the qualification of the student.
     *
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Retrieves the hall ticket number of the student.
     *
     * @return the hall ticket number
     */
    public long getHallTicketNo() {
        return hallTicketNo;
    }

    /**
     * Sets the hall ticket number of the student.
     *
     * @param hallTicketNo the hall ticket number to set
     */
    public void setHallTicketNo(long hallTicketNo) {
        this.hallTicketNo = hallTicketNo;
    }

    /**
     * Retrieves the student ID (alias for getStudent_id).
     *
     * @return the student ID
     */
    public Long getId() {
        return student_id;
    }

    /**
     * Sets the student ID (alias for setStudent_id).
     *
     * @param id the student ID to set
     */
    public void setId(Long id) {
        this.student_id = id;
    }

    // Overridden toString method

    /**
     * Returns a string representation of the student object.
     *
     * @return string representation of the student
     */
    @Override
    public String toString() {
        return "HiteshStudent [student_id=" + student_id + ", roll_no=" + roll_no + ", student_name=" + student_name
                + ", course=" + course + ", year=" + year + ", qualification=" + qualification + ", hallTicketNo="
                + hallTicketNo + "]";
    }

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
