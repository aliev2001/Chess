package service;

import model.User;
import repository.UserRepository;
import repository.interfaces.IUserRepository;
import service.interfaces.IUserService;

public class UserService implements IUserService {
  private final IUserRepository userRepository = new UserRepository();

	@Override
  public User read(long id){
    return userRepository.read(id);
  }

	@Override
  public boolean create(User user){
    return userRepository.create(user);
  }

	@Override
	public boolean delete(long id) {
    return userRepository.delete(id);
	}

	@Override
	public boolean edit(User user) {
		return userRepository.edit(user);
	}

	@Override
  public User login(String username, String password){
    return userRepository.getUserByLogin(username, password);
  }
}
