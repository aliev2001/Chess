package repository.interfaces;

import java.util.List;

import model.User;

public interface IUserRepository extends IEntityRepository<User> {
  User getUserByLogin(String username, String password);

	List<User> getAll();
	List<User> getAllByGroup(String group);
	List<User> getAllByMajor(String major);
	List<User> getAllbyYear(int year);

	List<String> getGroups();
	List<String> getMajors();
}
