package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.User;
import pl.edu.pw.finalproject.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(long theId) {
        userRepository.deleteById(theId);
    }
}
