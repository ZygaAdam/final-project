package pl.edu.pw.finalproject.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.finalproject.dto.UserRegistrationDto;
import pl.edu.pw.finalproject.service.UserService;


/**
 * The type User registration controller.
 * @author Matylda Wawrzak-Rajtar
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	/**
	 * Instantiates a new User registration controller.
	 *
	 * @param userService the user service
	 */
	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * User registration dto user registration dto.
	 *
	 * @return the user registration dto
	 */
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	/**
	 * Show registration form string.
	 *
	 * @return the string
	 */
	@GetMapping
	public String showRegistrationForm() {

		return "registration";
	}

	/**
	 * Register user account string.
	 *
	 * @param userDto the user dto
	 * @param result  the result
	 * @return the string
	 */
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userDto, BindingResult result) {

		userService.save(userDto);
		return "redirect:/registration?success";
	}


}