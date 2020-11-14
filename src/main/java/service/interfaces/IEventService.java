package	service.interfaces;

import model.Event;

public interface IEventService {
	Event read(long id);
	boolean create(Event user);
	boolean delete(long id);
	boolean edit(Event user);
}
