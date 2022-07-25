package zw.co.msu.eSadza.controller;

import zw.co.msu.eSadza.service.UserService;
import zw.co.msu.eSadza.service.UserServiceImpl;
import zw.co.msu.eSadza.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class RegistrationController {
	private final UserService userService;

	@Autowired
	public RegistrationController(UserService userService) {

		this.userService = userService;
	}

	@RequestMapping("/register")
	public User showRegister() {

		return new User();
	}

	@PostMapping("/register")
	public User addUser(@RequestBody User user, Model model) {

		System.out.println(user.toString());
		userService.register(user);
		return user;
	}

	@PostMapping("/checkUserName")
	public boolean checkAvailability(@RequestBody String username, Model model) {

		return userService.usernameExists(username);
	}
}
