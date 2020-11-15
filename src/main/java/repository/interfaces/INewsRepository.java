package repository.interfaces;

import java.util.List;

import model.News;

public interface INewsRepository extends IEntityRepository<News> {
	List<News> getAll();
}
