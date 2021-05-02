package pl.edu.pw.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.entities.User;
import pl.edu.pw.finalproject.repository.CourseRepository;
import pl.edu.pw.finalproject.repository.UserRepository;
import pl.edu.pw.finalproject.service.CourseService;
import pl.edu.pw.finalproject.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private CourseService courseService;
    private UserService userService;

    public CourseController(CourseRepository theCourseRepository,
                          UserRepository theUserRepository, CourseService theCourseService
                            ) {
        courseRepository = theCourseRepository;
        userRepository = theUserRepository;
        courseService = theCourseService;

    }

    @GetMapping("/courseList")
    public String showCourseList(Model theModel) {


        List<Course> theCourses = courseRepository.findAll();
        theModel.addAttribute("courses", theCourses);


        return "course-list";
    }


    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") long theId) {

        courseRepository.deleteById(theId);

        return "redirect:/course/courseList";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Course theCourse = new Course();
        List<User> listUsers = userRepository.findAll();
        theModel.addAttribute("course", theCourse);
        theModel.addAttribute("users", listUsers);
        return "add-course-form";
    }

    @PostMapping("/saveUserToCourse")
    public String saveUserToCourse(@ModelAttribute("course") Course theCourse) {

        courseRepository.save(theCourse);

        return "redirect:/course/courseList";
    }



    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") long theId,
                                    Model theModel) {

        Course theCourse = courseService.findById(theId);
        List<User> listUsers = userRepository.findAll();
        theModel.addAttribute("course", theCourse);
        theModel.addAttribute("users", listUsers);
        return "add-course-form";
    }




    @GetMapping("/enrolledUsers/{courseId}")
    public String showEnrolledUsers(@PathVariable("courseId") long theId,
                                    Model theModel) {
        Course theCourse = courseService.findById(theId);
        List<User> courseUsers = theCourse.getUsers();
        List<User> allUsers =
                (userRepository.findAll())
                        .stream()
                        .filter(user ->!theCourse.getUsers().contains(user))
                        .collect(Collectors.toList());

        theModel.addAttribute("course", theCourse);
        theModel.addAttribute("courseUsers", courseUsers);
        theModel.addAttribute("allUsers", allUsers);

        return "show-enrolled-users";}



    @GetMapping("/enrolledUsers/{courseId}/users/{userId}/delete")
    public String deleteUserFromTheCourse(@PathVariable("courseId") Long courseId,
                                          @PathVariable("userId") Long userId, Model model){

        Course theCourse = courseService.findById(courseId);
     //   User UserToDelete =  theCourse.getUsers().get(userId.intValue() - 1);
     //   System.out.println("id to " + UserToDelete.getId() + " nazwisko to " + UserToDelete.getLastName());
     //   theCourse.getUsers().remove(UserToDelete);
        Optional<User> routeToDeleteOptional =  theCourse.getUsers().stream().filter(user -> user.getId().equals(userId)).findFirst();
        if(routeToDeleteOptional.isPresent()){
            theCourse.getUsers().remove(routeToDeleteOptional.get());
            courseRepository.save(theCourse);
        }


        return "redirect:/course/enrolledUsers/" + theCourse.getId();
    }

    @PostMapping("/processAddUserToCourse")
    public String processForm(@ModelAttribute("course")Course theCourse)
    {

        Optional<Course> course = courseRepository.findById(theCourse.getId());
        List<Long> userIds = theCourse.getUsers().stream().map(user -> user.getId()).collect(Collectors.toList());
        List<User> userList = userIds.stream().map(aLong -> userRepository.getOne(aLong)).collect(Collectors.toList());
        System.out.println(course.get());
        course.get().getUsers().addAll(userList);
        System.out.println(course.get());

        courseRepository.save(course.get());

        return "redirect:/course/enrolledUsers/" + theCourse.getId();
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {

        courseRepository.save(theCourse);

        return "redirect:/course/courseList";
    }




}
