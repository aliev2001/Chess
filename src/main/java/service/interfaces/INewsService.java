package	service.interfaces;

import java.util.List;

import model.News;

public interface INewsService {
	News read(long id);
	boolean create(News user);
	boolean delete(long id);
	boolean edit(News user);

	List<News> getAll();
}
