package pl.edu.pw.finalproject.service;

import pl.edu.pw.finalproject.entities.Student;

/**
 * The interface Student service.
 *  @author Adam Zyga
 */
public interface StudentService {

    /**
     * Save.
     *
     * @param theStudent the the student
     */
    public void save(Student theStudent);

    /**
     * Delete by id.
     *
     * @param theId the the id
     */
    public void deleteById(long theId);
}
