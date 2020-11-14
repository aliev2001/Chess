package service;

import model.Event;
import repository.EventRepository;
import repository.interfaces.IEventRepository;
import service.interfaces.IEventService;

public class EventService implements IEventService {

	private final IEventRepository eventRepository = new EventRepository();

	@Override
	public Event read(long id) {
		return eventRepository.read(id);
	}

	@Override
	public boolean create(Event user) {
		return eventRepository.create(user);
	}

	@Override
	public boolean delete(long id) {
		return eventRepository.delete(id);
	}

	@Override
	public boolean edit(Event user) {
		return eventRepository.edit(user);
	}
}
