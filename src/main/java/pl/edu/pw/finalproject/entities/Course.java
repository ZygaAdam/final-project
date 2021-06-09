package pl.edu.pw.finalproject.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class creates a new course.
 * Many students can be enrolled to a course.
 *
 * @author Matylda Wawrzak-Rajtar
 * @version 1.5 z dnia 8.06
 */
@Entity
public class Course {
    /**
     * Id - course number in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * the name of a course
     */
    private String name;

    /**
     * the description of a course
     */
    private String description;

    //  @DateTimeFormat(pattern = "dd/MM/yyyy h:mm")
    /**
     * the start date of a course
     */
    private Date date;


    /**
     * @return the list of students enrolled in the course
     */
    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.REFRESH} )
    @JoinTable(
            name="course_student",
            joinColumns =@JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students;

    /**
     * Instantiates a new Course.
     */
    public Course(){}

    /**
     * Instantiates a new Course.
     *
     * @param name        the name
     * @param description the description
     * @param date        the date
     */
    public Course( String name, String description, Date date) {

        this.name = name;
        this.description = description;
        this.date = date;
    }


    /**
     * Gets id of a course
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id of a course
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name of a course.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of a course.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description of a course.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description of a course.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets students list enrolled of a course.
     *
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets students.
     *
     * @param students the students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Gets start date of a course.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets start date of the course.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * To string method.
     *
     * @return the string with all information about a course
     */
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", students=" + students +
                '}';
    }
}
