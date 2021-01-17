package repository.interfaces;

import java.util.List;

import model.User;

public interface IUserRepository extends IEntityRepository<User> {
  User getUserByLogin(String username, String password);
	User getUserByUsername(String username);

	List<User> getAll();
}
