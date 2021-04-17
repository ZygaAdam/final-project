package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.User;

public interface UserService {

    public void save(User theUser);

    public void deleteById(long theId);
}
