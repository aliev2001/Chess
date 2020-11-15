package repository;

import model.Club;
import repository.interfaces.IClubRepository;
import repository.interfaces.IDBRepository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClubRepository implements IClubRepository {

	private final IDBRepository dbRepository = PostgresRepository.getInstance();

	@Override
	public Club read(long id) {
		String sql = "SELECT * FROM club WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) return new Club(rs.getLong("id"),
					rs.getString("title"),rs.getString("description"));
		} catch(SQLException e){ System.out.println("Bad request"); }
		return null;
	}

	@Override
	public boolean create(Club entity) {
		String sql = "INSERT INTO club (tite, description) VALUES (?, ?)";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setString(1, entity.getTitle());
			stmt.setString(2, entity.getDescription());

			if(stmt.executeUpdate() > 0) return true;
		} catch(SQLException e){
			System.out.println("Bad request");
		}
		return false;
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM club WHERE id = ?";
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
	public boolean edit(Club entity) {
		String sql = "UPDATE clubs SET ";
		if(entity.getTitle() != null){
			sql += "title=?,";
		}
		if(entity.getDescription() != null){
			sql += "description=?,";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			int i = 0;
			if(entity.getTitle() != null){
				stmt.setString(i++, entity.getTitle());
			}
			if(entity.getDescription() != null){
				stmt.setString(i++, entity.getDescription());
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
	public Set<Club> getAll() {
		String sql = "SELECT * FROM news";
		Set<Club> clubs = new HashSet<>();
		try {
			Statement stmt = dbRepository.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				clubs.add(
					new Club(rs.getLong("id"),
						rs.getString("title"),
						rs.getString("description")
					));
			}
		} catch(SQLException e){
			System.out.println("Something went wrong");
		}
		return clubs;
	}
}
