package service;

import java.util.List;

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

	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public List<User> getAllByGroup(String group) {
		return userRepository.getAllByGroup(group);
	}

	@Override
	public List<User> getAllByMajor(String major) {
		return userRepository.getAllByMajor(major);
	}

	@Override
	public List<User> getAllbyYear(int year) {
		return userRepository.getAllbyYear(year);
	}

	@Override
	public List<String> getGroups() {
		return userRepository.getGroups();
	}

	@Override
	public List<String> getMajors() {
		return userRepository.getMajors();
	}
}
