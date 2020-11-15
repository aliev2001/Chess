package	service.interfaces;

import java.util.Set;
import java.util.Stack;

import model.Club;

public interface IClubService {
	Club read(long id);
	boolean create(Club user);
	boolean delete(long id);
	boolean edit(Club user);

	Set<Club> getAll();
	Stack<Club> getUserClubs(long userId);
}
