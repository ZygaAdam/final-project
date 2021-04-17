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

@SpringBootApplication
@EnableAutoConfiguration
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}



@Bean
CommandLineRunner runner(CourseRepository coursceService, UserRepository userService){
	return args ->{
		Course course1 = new Course("dupa", "dupa");
		User user1 = new User("Andrzej", "Kowalski");
		coursceService.save(course1);

		coursceService.save(new Course("dupa", "dupa2"));
		coursceService.save(new Course("dupa", "dupa3"));
		userService.save((new User("Andrzej", "Kowalski")));
	};
}
}