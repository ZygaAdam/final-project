package pl.edu.pw.finalproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pw.finalproject.entities.Course;
import pl.edu.pw.finalproject.entities.User;
import pl.edu.pw.finalproject.repository.CourseRepository;
import pl.edu.pw.finalproject.repository.UserRepository;
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
		Course course1 = new Course("xxx", "cxxaaaxal");
		User user1 = new User("Adam", "Zyga");
		User user2 = new User("Adam2", "Zyga2");
		User user3 = new User("Adam3", "Zyga3");
		course1.addUser(user1);
		course1.addUser(user2);
		course1.addUser(user3);

		courseService.save(course1);


	};
}
}