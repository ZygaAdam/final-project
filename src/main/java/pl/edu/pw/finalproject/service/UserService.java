package pl.edu.pw.finalproject.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import pl.edu.pw.finalproject.dto.UserRegistrationDto;
import pl.edu.pw.finalproject.entities.User;

import java.util.List;

/**
 * The interface User service.
 *  @author Adam Zyga
 */
public interface UserService extends UserDetailsService {
    /**
     * Save user.
     *
     * @param registrationDto the registration dto
     * @return the user
     */
    User save(UserRegistrationDto registrationDto);

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<User> findAll();

}
