package pl.edu.pw.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.pw.finalproject.repository.CourseRepository;
import pl.edu.pw.finalproject.repository.StudentRepository;


@Controller
public class MainController {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public MainController(CourseRepository theCourseRepository,
                          StudentRepository theStudentRepository) {
        courseRepository = theCourseRepository;
        studentRepository = theStudentRepository;
    }

    @GetMapping("/")
    public String start() {


        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }





}
