package pl.edu.pw.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.pw.finalproject.repository.CourseRepository;
import pl.edu.pw.finalproject.repository.StudentRepository;


/**
 * The type Main controller.
 * @author Adam Zyga
 */
@Controller
public class MainController {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    /**
     * Instantiates a new Main controller.
     *
     * @param theCourseRepository  the the course repository
     * @param theStudentRepository the the student repository
     */
    public MainController(CourseRepository theCourseRepository,
                          StudentRepository theStudentRepository) {
        courseRepository = theCourseRepository;
        studentRepository = theStudentRepository;
    }

    /**
     * Start string.
     *
     * @return the string
     */
    @GetMapping("/")
    public String start() {


        return "index";
    }

    /**
     * Login string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * Profile string.
     *
     * @return the string
     */
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }





}
