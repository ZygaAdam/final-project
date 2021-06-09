package pl.edu.pw.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.entities.Student;
import pl.edu.pw.finalproject.repository.CourseRepository;
import pl.edu.pw.finalproject.repository.StudentRepository;
import pl.edu.pw.finalproject.service.CourseService;
import pl.edu.pw.finalproject.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * The type Course controller.
 * @author Matylda Wawrzak-Rajtar
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private CourseService courseService;
    private StudentService studentService;

    /**
     * Instantiates a new Course controller.
     *
     * @param theCourseRepository  the the course repository
     * @param theStudentRepository the the student repository
     * @param theCourseService     the the course service
     */
    public CourseController(CourseRepository theCourseRepository,
                            StudentRepository theStudentRepository, CourseService theCourseService
    ) {
        courseRepository = theCourseRepository;
        studentRepository = theStudentRepository;
        courseService = theCourseService;

    }

    /**
     * Show course list string.
     *
     * @param theModel the the model
     * @return the string
     */
    @GetMapping("/courseList")
    public String showCourseList(Model theModel) {


        List<Course> theCourses = courseRepository.findAll();
        theModel.addAttribute("courses", theCourses);


        return "course-list";
    }


    /**
     * Delete course string.
     *
     * @param theId the the id
     * @return the string
     */
    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") long theId) {

        courseRepository.deleteById(theId);

        return "redirect:/course/courseList";
    }


    /**
     * Show form for add string.
     *
     * @param theModel the the model
     * @return the string
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Course theCourse = new Course();
        List<Student> listStudents = studentRepository.findAll();
        theModel.addAttribute("course", theCourse);
        theModel.addAttribute("students", listStudents);
        return "add-course-form";
    }

    /**
     * Save user to course string.
     *
     * @param theCourse the the course
     * @return the string
     */
    @PostMapping("/saveUserToCourse")
    public String saveUserToCourse(@ModelAttribute("course") Course theCourse) {

        courseRepository.save(theCourse);

        return "redirect:/course/courseList";
    }


    /**
     * Show form for update string.
     *
     * @param theId    the the id
     * @param theModel the the model
     * @return the string
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") long theId,
                                    Model theModel) {

        Course theCourse = courseService.findById(theId);
        List<Student> listStudents = studentRepository.findAll();
        theModel.addAttribute("course", theCourse);
        theModel.addAttribute("students", listStudents);
        return "add-course-form";
    }


    /**
     * Show enrolled users string.
     *
     * @param theId    the the id
     * @param theModel the the model
     * @return the string
     */
    @GetMapping("/enrolledUsers/{courseId}")
    public String showEnrolledUsers(@PathVariable("courseId") long theId,
                                    Model theModel) {
        Course theCourse = courseService.findById(theId);
        List<Student> courseStudents = theCourse.getStudents();
        List<Student> allStudents =
                (studentRepository.findAll())
                        .stream()
                        .filter(user ->!theCourse.getStudents().contains(user))
                        .collect(Collectors.toList());

        theModel.addAttribute("course", theCourse);
        theModel.addAttribute("courseUsers", courseStudents);
        theModel.addAttribute("allUsers", allStudents);

        return "show-enrolled-users";}


    /**
     * Delete user from the course string.
     *
     * @param courseId the course id
     * @param userId   the user id
     * @param model    the model
     * @return the string
     */
    @GetMapping("/enrolledUsers/{courseId}/users/{userId}/delete")
    public String deleteUserFromTheCourse(@PathVariable("courseId") Long courseId,
                                          @PathVariable("userId") Long userId, Model model){

        Course theCourse = courseService.findById(courseId);
        //   Student UserToDelete =  theCourse.getUsers().get(userId.intValue() - 1);
        //   System.out.println("id to " + UserToDelete.getId() + " nazwisko to " + UserToDelete.getLastName());
        //   theCourse.getUsers().remove(UserToDelete);
        Optional<Student> routeToDeleteOptional =  theCourse.getStudents().stream().filter(user -> user.getId().equals(userId)).findFirst();
        if(routeToDeleteOptional.isPresent()){
            theCourse.getStudents().remove(routeToDeleteOptional.get());
            courseRepository.save(theCourse);
        }


        return "redirect:/course/enrolledUsers/" + theCourse.getId();
    }

    /**
     * Process form string.
     *
     * @param theCourse the the course
     * @return the string
     */
    @PostMapping("/processAddUserToCourse")
    public String processForm(@ModelAttribute("course")Course theCourse)
    {

        Optional<Course> course = courseRepository.findById(theCourse.getId());
        List<Long> userIds = theCourse.getStudents().stream().map(user -> user.getId()).collect(Collectors.toList());
        List<Student> studentList = userIds.stream().map(aLong -> studentRepository.getOne(aLong)).collect(Collectors.toList());
        System.out.println(course.get());
        course.get().getStudents().addAll(studentList);
        System.out.println(course.get());

        courseRepository.save(course.get());

        return "redirect:/course/enrolledUsers/" + theCourse.getId();
    }

    /**
     * Save course string.
     *
     * @param theCourse the the course
     * @return the string
     */
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {

        courseRepository.save(theCourse);

        return "redirect:/course/courseList";
    }




}
