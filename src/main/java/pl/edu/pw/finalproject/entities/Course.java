package pl.edu.pw.finalproject.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(fetch=FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
                        CascadeType.REFRESH} )
    @JoinTable(
            name="course_student",
            joinColumns =@JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<User> users;

    public Course(){}

    public Course( String name, String description) {

        this.name = name;
        this.description = description;
    }

    public void addUser(User theUser){
        if(users == null){
            users = new ArrayList<>();
        }
        users.add(theUser);
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
