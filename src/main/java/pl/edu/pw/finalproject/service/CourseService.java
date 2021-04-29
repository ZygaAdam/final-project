package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.entities.User;

import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    public Course findById(long theId);

    public void save(Course theCourse);

    public void deleteById(long theId);




}
