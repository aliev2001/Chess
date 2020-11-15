package	service.interfaces;

import java.util.Queue;

import model.Event;

public interface IEventService {
	Event read(long id);
	boolean create(Event user);
	boolean delete(long id);
	boolean edit(Event user);

	Queue<Event> getAll();
}
