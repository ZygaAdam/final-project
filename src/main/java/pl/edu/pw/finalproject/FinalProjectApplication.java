package pl.edu.pw.finalproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.service.CourseService;

@SpringBootApplication
@EnableAutoConfiguration
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}



@Bean
CommandLineRunner runner(CourseService courseService){
	return args ->{

//		Course course1 = new Course("xxx", "cxxaaaxal", new Date(2020,11, 11, 11, 12));
//		Student user1 = new Student("Adam", "Zyga", "xxx@o2.pl");
//		Student user2 = new Student("Adam2", "Zyga2", "xxx2@o2.pl");
//		Student user3 = new Student("Adam3", "Zyga3", "xxx3@o2.pl");
//		course1.addUser(user1);
//		course1.addUser(user2);
//		course1.addUser(user3);
//
//		courseService.save(course1);


	};
}
}