package	service.interfaces;

import java.util.List;

import model.User;

public interface IUserService {
	User read(long id);
	User read(String username);
	boolean create(User user);
	boolean delete(long id);
	boolean edit(User user);
	User login(String username, String password);

	// Additional		
	List<User> getAll();
	List<User> getAllByGroup(String group);
	List<User> getAllByMajor(String major);
	List<User> getAllbyYear(int year);

	List<String> getGroups();
	List<String> getMajors();
}
