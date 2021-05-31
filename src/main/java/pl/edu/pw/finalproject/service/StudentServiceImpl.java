package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.Student;
import pl.edu.pw.finalproject.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(long theId) {
        studentRepository.deleteById(theId);
    }
}
