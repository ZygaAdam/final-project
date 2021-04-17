package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.repository.CourseRepository;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(int theId) {
        return null;
    }

    @Override
    public void save(Course theCourse) {
        courseRepository.save(theCourse);
    }

    @Override
    public void deleteById(long theId) {
        courseRepository.deleteById(theId);
    }
}
