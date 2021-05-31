package pl.edu.pw.finalproject.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pw.finalproject.dto.UserRegistrationDto;
import pl.edu.pw.finalproject.service.UserService;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
    
    @GetMapping
    public String showRegistrationForm() {
       
    	return "registration";
    }

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userDto, BindingResult result) {

		userService.save(userDto);
		return "redirect:/registration?success";
	}


}
