package pl.edu.pw.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.finalproject.entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findAllByOrderById();
}
