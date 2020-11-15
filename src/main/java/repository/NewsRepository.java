package repository;

import model.News;
import repository.interfaces.IDBRepository;
import repository.interfaces.INewsRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository implements INewsRepository {

	private final IDBRepository dbRepository = PostgresRepository.getInstance();

	@Override
	public News read(long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return new News(rs.getLong("id"), rs.getString("title"),
					rs.getString("text"),rs.getDate("date"));
		} catch(SQLException e){ System.out.println("Bad request"); }

		return null;
	}

	@Override
	public boolean create(News entity) {
		String sql = "INSERT INTO news (title, \"text\") VALUES (?, ?)";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setString(1, entity.getTitle());
			stmt.setString(2, entity.getText());
			// stmt.setDate(3, entity.getDate());

			if(stmt.executeUpdate() > 0) return true;
		} catch(SQLException e){
			System.out.println("Bad request");
		}
		return false;
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);
			if(stmt.executeUpdate() > 0){
				return true;
			}
		} catch(SQLException e){
			System.out.println("Bad request");
		}
		return false;
	}

	@Override
	public boolean edit(News entity) {
		String sql = "UPDATE news SET ";
		if(entity.getTitle() != null){
			sql += "title=?,";
		}
		if(entity.getText() != null){
			sql += "text=?,";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			int i = 1;
			if(entity.getTitle() != null){
				stmt.setString(i++, entity.getTitle());
			}
			if(entity.getText() != null){
				stmt.setString(i++, entity.getText());
			}
			stmt.setLong(i++, entity.getId());
			if(stmt.executeUpdate() > 0) return true;
		} catch(SQLException e){
			System.out.println("Bad request");
		}
		sql = sql.substring(0, sql.length() - 1);
		return false;
	}

	@Override
	public List<News> getAll() {
		String sql = "SELECT * FROM news";
		List<News> news = new ArrayList<>();
		try {
			Statement stmt = dbRepository.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				news.add(new News(
					rs.getLong("id"),
					rs.getString("title"),
					rs.getString("text"),
					rs.getDate("date")
				));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return news;
	}
}
