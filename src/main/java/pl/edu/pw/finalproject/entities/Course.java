package pl.edu.pw.finalproject.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

  //  @DateTimeFormat(pattern = "dd/MM/yyyy h:mm")
    private Date date;

    @ManyToMany(fetch=FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
                        CascadeType.REFRESH} )
    @JoinTable(
            name="course_student",
            joinColumns =@JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students;

    public Course(){}

    public Course( String name, String description, Date date) {

        this.name = name;
        this.description = description;
        this.date = date;
    }
// poniej wyjebac te metode, potrzebna tylko do testow
    public void addUser(Student theStudent){
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(theStudent);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
