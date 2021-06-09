package pl.edu.pw.finalproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.finalproject.entities.User;

/**
 * The interface User repository.
 *  @author Adam Zyga
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    public User findByEmail(String email);
}