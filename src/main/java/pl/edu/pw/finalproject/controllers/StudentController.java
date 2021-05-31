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

@Controller
public class StudentController {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public StudentController(CourseRepository theCourseRepository,
                             StudentRepository theStudentRepository) {
        courseRepository = theCourseRepository;
        studentRepository = theStudentRepository;
    }

    @GetMapping("/userList")
    public String showUsersList(Model theModel) {

        List<Student> theStudents = studentRepository.findAll();
        theModel.addAttribute("users", theStudents);

        return "user-list";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") Student theStudent) {

        studentRepository.save(theStudent);

        return "redirect:/userList";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long theId) {

        studentRepository.deleteById(theId);

        return "redirect:/userList";
    }

    @GetMapping("/showFormForUserAdd")
    public String showFormForUserAdd(Model theModel) {

        Student theStudent = new Student();

        theModel.addAttribute("user", theStudent);

        return "add-user-form";
    }




}
