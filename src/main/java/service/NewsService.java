package service;

import model.News;
import repository.NewsRepository;
import repository.interfaces.INewsRepository;
import service.interfaces.INewsService;

public class NewsService implements INewsService {

	private final INewsRepository newsRepository = new NewsRepository();

	@Override
	public News read(long id) {
		return newsRepository.read(id);
	}

	@Override
	public boolean create(News user) {
		return newsRepository.create(user);
	}

	@Override
	public boolean delete(long id) {
		return newsRepository.delete(id);
	}

	@Override
	public boolean edit(News user) {
		return newsRepository.edit(user);
	}
}
