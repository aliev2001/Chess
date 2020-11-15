package repository;

import model.Event;
import repository.interfaces.IDBRepository;
import repository.interfaces.IEventRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

public class EventRepository implements IEventRepository {

	private final IDBRepository dbRepository = PostgresRepository.getInstance();


	@Override
	public Event read(long id) {
		String sql = "SELECT * FROM event WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return new Event(rs.getLong("id"), rs.getString("title"),
					rs.getString("text"),rs.getDate("date"));
		} catch(SQLException e){ System.out.println("Bad request"); }

		return null;
	}

	@Override
	public boolean create(Event entity) {
		String sql = "INSERT INTO event (title, \"text\", \"date\") VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setString(1, entity.getTitle());
			stmt.setString(2, entity.getText());
			stmt.setDate(3, entity.getDate());

			if(stmt.executeUpdate() > 0) return true;
		} catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM event WHERE id = ?";
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
	public boolean edit(Event entity) {
		String sql = "UPDATE event SET ";
		if(entity.getTitle() != null){
			sql += "title=?,";
		}
		if(entity.getText() != null){
			sql += "text=?,";
		}
		if(entity.getDate() != null){
			sql += "date=?,";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			int i = 0;
			if(entity.getTitle() != null){
				stmt.setString(i++, entity.getTitle());
			}
			if(entity.getText() != null){
				stmt.setString(i++, entity.getText());
			}
			if(entity.getDate() != null){
				stmt.setDate(i++, entity.getDate());
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
	public Queue<Event> getAll() {
		String sql = "SELECT * FROM event";
		Queue<Event> events = new LinkedList<>();
		try {
			Statement stmt = dbRepository.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				events.add(new Event(
							rs.getLong("id"),
							rs.getString("title"),
							rs.getString("text"),
							rs.getDate("date")
						));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return events;
	}
}
