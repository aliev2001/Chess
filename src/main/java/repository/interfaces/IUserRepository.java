package repository.interfaces;

import model.User;

public interface IUserRepository extends IEntityRepository<User> {
  User getUserByLogin(String username, String password);
}
