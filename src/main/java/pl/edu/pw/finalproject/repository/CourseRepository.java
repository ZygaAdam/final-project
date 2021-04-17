package pl.edu.pw.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.finalproject.entities.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    public List<Course> findAllByOrderById();
}
