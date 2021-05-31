package pl.edu.pw.finalproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.repository.CourseRepository;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;


@SpringBootTest
public class CourseServiceTest {


    @Autowired
    private CourseService courseService;


    @MockBean
    private CourseRepository courseRepository;

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {

        Course course = new Course("Cobol course","course about cobol programming language",new Date(2020,11, 11, 11, 12));
        doReturn(Optional.of(course)).when(courseRepository).findById(1l);

        // Execute the service call
        Optional<Course> returnedCourse = Optional.ofNullable(courseService.findById(1l));

        // Assert the response
        Assertions.assertTrue(returnedCourse.isPresent(), "Course was not found");
        Assertions.assertSame(returnedCourse.get(), course, "The course returned was not the same as the mock");
    }


    @Test
    @DisplayName("Test findById Not Found throws exception")
    void testFindByIdNotFound() {


        assertThrows(RuntimeException.class, () -> courseService.findById(1l));
    }

    @Test
    @DisplayName("Test findAll returns correct size")
    void testFindAll() {
        // Setup our mock repository
        Course course = new Course("Cobol course","course about cobol programming language",new Date(2020,11, 11, 11, 12));
        Course course2 = new Course("Java course","course about java programming language",new Date(2021,12, 12, 11, 12));
        doReturn(Arrays.asList(course, course2)).when(courseRepository).findAll();

        // Execute the service call
        List<Course> courses = courseService.findAll();

        // Assert the response
        Assertions.assertEquals(2, courses.size(), "findAll should return 2 courses");
    }

    @Test
    @DisplayName("Test save course not null")
    void testSave() {

        Course course = new Course("Cobol course","course about cobol programming language",new Date(2020,11, 11, 11, 12));
        doReturn(course).when(courseRepository).save(any());

        Course returnedCourse = courseService.save(course);

        Assertions.assertNotNull(returnedCourse, "The saved course should not be null");


    }

    @Test
    @DisplayName("Test saved course has correct name")
    void testSaveReturnsCorrectName() {

        Course course = new Course("Cobol course","course about cobol programming language",new Date(2020,11, 11, 11, 12));

        Course returnedCourse = courseService.save(course);

        Assertions.assertSame(returnedCourse.getName(),course.getName(),"Saved course has correct name");
    }

    @Test
    @DisplayName("Test delete by id deletes the object")
    void testDeleteById(){
        Course course = new Course("Cobol course","course about cobol programming language",new Date(2020,11, 11, 11, 12));

        System.out.println(doReturn(Optional.of(course)).when(courseRepository).findById(1l));
    }
    }



