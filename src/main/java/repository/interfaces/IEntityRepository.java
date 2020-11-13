package repository.interfaces;

public interface IEntityRepository<T> {
  T read(long id);
  boolean create(T entity);
  boolean delete(long id);
  boolean edit(T entity);
}
