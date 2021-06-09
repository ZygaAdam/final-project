package pl.edu.pw.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.finalproject.entities.Student;

import java.util.List;

/**
 * The interface Student repository.
 *  @author Adam Zyga
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Find all by order by id list.
     *
     * @return the list
     */
    public List<Student> findAllByOrderById();
}
