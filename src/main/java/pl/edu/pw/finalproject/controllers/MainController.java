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


    @GetMapping("/courseList")
    public String showCourseList(Model theModel) {

        List<Course> theCourses = courseRepository.findAll();
        theModel.addAttribute("courses", theCourses);

        return "course-list";
    }

    @GetMapping("/userList")
    public String showUsersList(Model theModel) {

        List<User> theUsers = userRepository.findAll();
        theModel.addAttribute("users", theUsers);

        return "user-list";
    }



    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {

        courseRepository.save(theCourse);

        return "redirect:/courseList";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") long theId) {

        courseRepository.deleteById(theId);

        return "redirect:/courseList";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser) {

        userRepository.save(theUser);

        return "redirect:/userList";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long theId) {

        userRepository.deleteById(theId);

        return "redirect:/userList";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Course theCourse = new Course();

        theModel.addAttribute("course", theCourse);

        return "add-course-form";
    }


    @GetMapping("/showFormForUserAdd")
    public String showFormForUserAdd(Model theModel) {

        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "add-user-form";
    }



}
