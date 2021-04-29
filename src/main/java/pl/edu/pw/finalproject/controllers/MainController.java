package pl.edu.pw.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.entities.User;
import pl.edu.pw.finalproject.repository.CourseRepository;
import pl.edu.pw.finalproject.repository.UserRepository;

import java.util.List;


@Controller
public class MainController {

    private CourseRepository courseRepository;
    private UserRepository userRepository;

    public MainController(CourseRepository theCourseRepository,
                          UserRepository theUserRepository) {
        courseRepository = theCourseRepository;
        userRepository = theUserRepository;
    }

    @GetMapping("/")
    public String start() {


        return "index";
    }





}
