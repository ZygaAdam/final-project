package pl.edu.pw.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

/**
 * The type Course service.
 * @author Matylda Wawrzak-Rajtar
 */
@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    /**
     * Find by id course.
     *
     * @param theId the the id
     * @return the course
     */
    @Override
    public Course findById(long theId) {

        Optional<Course> result = courseRepository.findById(theId);
        Course theCourse = null;

        if(result.isPresent()){
            theCourse = result.get();
        }else {

            throw new RuntimeException("Did not find course id - " + theId);
        }

        return theCourse;
    }

    /**
     * Save course.
     *
     * @param theCourse the the course
     * @return the course
     */
    @Override
    public Course save(Course theCourse) {
        courseRepository.save(theCourse);
        return theCourse;
    }

    /**
     * Delete by id.
     *
     * @param theId the the id
     */
    @Override
    public void deleteById(long theId) {
        courseRepository.deleteById(theId);
    }


}
