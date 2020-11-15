package repository.interfaces;

import model.News;

import java.util.List;

public interface INewsRepository extends IEntityRepository<News> {
    List<News> getAllNews();
}
