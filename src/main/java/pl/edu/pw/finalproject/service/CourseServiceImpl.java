package pl.edu.pw.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.entities.User;
import pl.edu.pw.finalproject.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return null;
    }

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

    @Override
    public void save(Course theCourse) {
        courseRepository.save(theCourse);
    }

    @Override
    public void deleteById(long theId) {
        courseRepository.deleteById(theId);
    }


}
