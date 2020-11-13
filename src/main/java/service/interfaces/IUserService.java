package	service.interfaces;

import model.User;

public interface IUserService {
	User read(long id);
	boolean create(User user);
	boolean delete(long id);
	boolean edit(User user);
	User login(String username, String password);
}
