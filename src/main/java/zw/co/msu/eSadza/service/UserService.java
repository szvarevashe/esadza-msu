package zw.co.msu.eSadza.service;

import zw.co.msu.eSadza.model.Login;
import zw.co.msu.eSadza.model.User;

public interface UserService {
	public void register(User user);
	public User validateUser(Login login);

	public Boolean usernameExists(String username);

}
