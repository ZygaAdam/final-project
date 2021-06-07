package pl.edu.pw.finalproject.entities;
/**
 * Represents the student.
 * A student can be enrolled in many courses.
 */


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    /**
     * Id number that the student has in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * First name of the student
     */
    private String firstName;
    /**
     * Last name of the student
     */
    private String lastName;
    /**
     * Student's email adress
     */
    private String email;

    /**
     * @return list of courses on which student is enrolled
     */
    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.REFRESH} )
    @JoinTable(
            name="course_student",
            joinColumns =@JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses;

    /**
     * Creates student object without any data
     */
    public Student(){}

    /**
     * Creates the student with specified first name, last name and email
     * @param firstName the student's first name
     * @param lastName the students last name
     * @param email the student's email
     */
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the student’s id in the database.
     * @return A long value representing the student’s id in the database
     */
    public Long getId() {
        return id;
    }
    /**
     * Sets the student’s id.
     * @param id A Long containing the student’s id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Gets the student’s first name.
     * @return A string representing the student’s first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the student’s first name.
     * @param firstName A String containing the student’s first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student’s last name.
     * @return A string representing the student’s last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the student’s last name.
     * @param lastName A String containing the student’s last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Gets the student’s list of enrolled courses.
     * @return A List of courses on which student is enrolled
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the student’s list of courses.
     * @param courses A String containing the student’s last name
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Gets the student’s email.
     * @return A String representing student's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student’s email.
     * @param email A String containing the student’s email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
