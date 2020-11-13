package repository;

import model.User;
import repository.interfaces.IDBRepository;
import repository.interfaces.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
  private final IDBRepository dbRepository = PostgresRepository.getInstance();

	@Override
	public boolean create(User user){
		String sql = "INSERT INTO users (name, surname, username, password, year, major, \"uGroup\") VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());
			stmt.setInt(5, user.getYear());
			stmt.setString(6, user.getMajor());
			stmt.setString(7, user.getUGroup());
			if(stmt.executeUpdate() > 0) return true;
		} catch(SQLException e){
			System.out.println("Bad request");
		}
		return false;
	}

  @Override
  public User read(long id){
    String sql = "SELECT * FROM users WHERE id = ?";
    try {
      PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
      stmt.setLong(1, id);

      ResultSet rs = stmt.executeQuery();
      if (rs.next()){
        return createUserByResultSet(rs);
      }
    } catch(SQLException e){
      System.out.println("Bad request");
    }
    return null;
  }

  @Override
  public boolean delete(long id){
    String sql = "DELETE FROM users WHERE id = ?";
    try {
      PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
      stmt.setLong(1, id);
      if(stmt.executeUpdate() > 1){
        return true;
      }
    } catch(SQLException e){
      System.out.println("Bad request");
    }
    return false;
  }

	@Override
	public boolean edit(User entity){
		String sql = "UPDATE users SET ";
		if(entity.getName() != null){
			sql += "name=?,";
		}
		if(entity.getSurname() != null){
			sql += "surname=?,";
		}
		if(entity.getUsername() != null){
			sql += "username=?,";
		}
		if(entity.getPassword() != null){
			sql += "password=?,";
		}
		if(entity.getYear() != 0){
			sql += "year=?,";
		}
		if(entity.getMajor() != null){
			sql += "major=?,";
		}
		if(entity.getUGroup() != null){
			sql += "\"uGroup\"=?,";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			int i = 0;
			if(entity.getName() != null){
				stmt.setString(i++, entity.getName());
			}
			if(entity.getSurname() != null){
				stmt.setString(i++, entity.getSurname());
			}
			if(entity.getUsername() != null){
				stmt.setString(i++, entity.getUsername());
			}
			if(entity.getPassword() != null){
				stmt.setString(i++, entity.getPassword());
			}
			if(entity.getYear() != 0){
				stmt.setInt(i++, entity.getYear());
			}
			if(entity.getMajor() != null){
				stmt.setString(i++, entity.getMajor());
			}
			if(entity.getUGroup() != null){
				stmt.setString(i++, entity.getUGroup());
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
	public User getUserByLogin(String username, String password){
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);

      ResultSet rs = stmt.executeQuery();
      if (rs.next()){
        return createUserByResultSet(rs);
      }
    } catch(SQLException e){
      System.out.println("Bad request");
    }
    return null;
  }

  protected User createUserByResultSet(ResultSet rs) throws SQLException {
    return new User.UserBuilder()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"))
            .setSurname(rs.getString("surname"))
            .setUsername(rs.getString("username"))
            .setPassword(rs.getString("password"))
						.setMajor(rs.getString("major"))
						.setYear(rs.getInt("year"))
						.setUGroup(rs.getString("uGroup"))
						.setIsAdmin(rs.getBoolean("isAdmin"))
            .build();
  }
}
