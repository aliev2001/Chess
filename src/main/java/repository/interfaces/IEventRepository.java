package repository.interfaces;

import model.Event;

import java.util.List;

public interface IEventRepository extends IEntityRepository<Event> {
    List<Event> getAllEvent();
}
