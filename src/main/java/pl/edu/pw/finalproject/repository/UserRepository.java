package pl.edu.pw.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pw.finalproject.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllByOrderById();
}
