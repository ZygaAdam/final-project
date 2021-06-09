package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.Course;

import java.util.List;

/**
 * The interface Course service.
 * @author Matylda Wawrzak-Rajtar
 */
public interface CourseService {

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Course> findAll();

    /**
     * Find by id course.
     *
     * @param theId the the id
     * @return the course
     */
    public Course findById(long theId);

    /**
     * Save course.
     *
     * @param theCourse the the course
     * @return the course
     */
    public Course save(Course theCourse);

    /**
     * Delete by id.
     *
     * @param theId the the id
     */
    public void deleteById(long theId);




}

