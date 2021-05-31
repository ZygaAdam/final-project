package pl.edu.pw.finalproject.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import pl.edu.pw.finalproject.dto.UserRegistrationDto;
import pl.edu.pw.finalproject.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    public List<User> findAll();

}
