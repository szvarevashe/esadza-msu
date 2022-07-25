package zw.co.msu.eSadza.controller;

import zw.co.msu.eSadza.service.UserService;
import zw.co.msu.eSadza.service.UserServiceImpl;
import zw.co.msu.eSadza.model.Login;
import zw.co.msu.eSadza.model.User;
import zw.co.msu.eSadza.utils.StrongAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {
	private final UserService userService;

	@Autowired
	public LoginController(UserService userService) {

		this.userService = userService;
	}


	@RequestMapping("/login")
	public Login showLogin() {

		return new Login();
	}

	@PostMapping("/login")
	public User loginProcess(@RequestBody Login login, Model model) {

		User user = null;
		user = userService.validateUser(login);
		if (user != null) {
			user.setPassword(null);
		}
		return user;
	}

	@RequestMapping("/xx")
	private String xx() {

		return new StrongAES().encrypt("");
	}

}
