package repository;

import model.News;
import repository.interfaces.INewsRepository;

public class NewsRepository implements INewsRepository {

	@Override
	public News read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(News entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(News entity) {
		// TODO Auto-generated method stub
		return false;
	}
}
