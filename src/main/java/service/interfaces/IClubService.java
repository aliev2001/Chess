package	service.interfaces;

import model.Club;

public interface IClubService {
	Club read(long id);
	boolean create(Club user);
	boolean delete(long id);
	boolean edit(Club user);
}
