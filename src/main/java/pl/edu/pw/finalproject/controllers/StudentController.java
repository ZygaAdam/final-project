package pl.edu.pw.finalproject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pw.finalproject.entities.Student;
import pl.edu.pw.finalproject.repository.CourseRepository;
import pl.edu.pw.finalproject.repository.StudentRepository;

import java.util.List;

/**
 * @author Adam Zyga
 * The type Student controller.
 */
@Controller
public class StudentController {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    /**
     * Instantiates a new Student controller.
     *
     * @param theCourseRepository  the the course repository
     * @param theStudentRepository the the student repository
     */
    public StudentController(CourseRepository theCourseRepository,
                             StudentRepository theStudentRepository) {
        courseRepository = theCourseRepository;
        studentRepository = theStudentRepository;
    }

    /**
     * Show users list string.
     * @param theModel the the model
     * @return the string
     */
    @GetMapping("/userList")
    public String showUsersList(Model theModel) {

        List<Student> theStudents = studentRepository.findAll();
        theModel.addAttribute("users", theStudents);

        return "user-list";
    }

    /**
     * Save user string.
     *
     * @param theStudent the the student
     * @return the string
     */
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") Student theStudent) {

        studentRepository.save(theStudent);

        return "redirect:/userList";
    }

    /**
     * Delete user string.
     *
     * @param theId the the id
     * @return the string
     */
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long theId) {

        studentRepository.deleteById(theId);

        return "redirect:/userList";
    }

    /**
     * Show form for user add string.
     *
     * @param theModel the the model
     * @return the string
     */
    @GetMapping("/showFormForUserAdd")
    public String showFormForUserAdd(Model theModel) {

        Student theStudent = new Student();

        theModel.addAttribute("user", theStudent);

        return "add-user-form";
    }

}
