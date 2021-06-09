package pl.edu.pw.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.finalproject.entities.Course;

import java.util.List;

/**
 * The interface Course repository.
 * @author Matylda Wawrzak-Rajtar
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * Find all by order by id list.
     *
     * @return the list
     */
    public List<Course> findAllByOrderById();
}
