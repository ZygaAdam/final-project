package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.Student;
import pl.edu.pw.finalproject.repository.StudentRepository;

/**
 * The type Student service.
 *  @author Adam Zyga
 */
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    /**
     * Save.
     *
     * @param theStudent the the student
     */
    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    /**
     * Delete by id.
     *
     * @param theId the the id
     */
    @Override
    public void deleteById(long theId) {
        studentRepository.deleteById(theId);
    }
}
