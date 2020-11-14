package	service.interfaces;

import model.News;

public interface INewsService {
	News read(long id);
	boolean create(News user);
	boolean delete(long id);
	boolean edit(News user);
}
