package zw.co.msu.eSadza.service;

import zw.co.msu.eSadza.model.Login;
import zw.co.msu.eSadza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.msu.eSadza.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public void register(User user) {

		userRepository.save(user);
	}

	public User validateUser(Login login) {

		User user = null;
		if (userRepository.findById(login.getUsername()).isPresent()) {
			user = userRepository.findById(login.getUsername()).get();
			if (!user.getPassword().equals(login.getPassword())) {
				user = null;
			}
		}
		return user;
	}

	public Boolean usernameExists(String username) {

		return userRepository.findById(username).isPresent();
	}

}
