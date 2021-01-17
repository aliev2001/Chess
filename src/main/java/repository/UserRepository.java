package repository;

import model.User;
import repository.interfaces.IDBRepository;
import repository.interfaces.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
  private final IDBRepository dbRepository = PostgresRepository.getInstance();

	@Override
	public boolean create(User user){
		String sql = "INSERT INTO users (name, surname, username, password) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());
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
      if (rs.next()) return createUserByResultSet(rs);
    } catch(SQLException e){ System.out.println("Bad request"); }
    return null;
  }

  @Override
  public boolean delete(long id){
    String sql = "DELETE FROM users WHERE id = ?";
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
		sql = sql.substring(0, sql.length() - 1);
		sql += " WHERE id = ?";
		try {
			PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
			int i = 1;
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

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";
		try {
			Statement stmt = dbRepository.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				users.add(createUserByResultSet(rs));
			}
		} catch(SQLException e){
			System.out.println(e);
		}
		return users;
	}


  protected User createUserByResultSet(ResultSet rs) throws SQLException {
    return new User.UserBuilder()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"))
            .setSurname(rs.getString("surname"))
            .setUsername(rs.getString("username"))
            .setPassword(rs.getString("password"))
						.build();
	}

	@Override
	public User getUserByUsername(String username) {
    String sql = "SELECT * FROM users WHERE username = ?";
    try {
      PreparedStatement stmt = dbRepository.getConnection().prepareStatement(sql);
      stmt.setString(1, username);

      ResultSet rs = stmt.executeQuery();
      if (rs.next()) return createUserByResultSet(rs);
    } catch(SQLException e){ System.out.println("Bad request"); }
    return null;
	}
}
