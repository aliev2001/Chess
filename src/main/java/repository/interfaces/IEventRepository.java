package repository.interfaces;

import java.util.Queue;

import model.Event;

public interface IEventRepository extends IEntityRepository<Event> {
	Queue<Event> getAll();
}
