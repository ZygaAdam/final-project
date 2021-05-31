package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.Student;

public interface StudentService {

    public void save(Student theStudent);

    public void deleteById(long theId);
}
