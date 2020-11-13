package repository;

import repository.interfaces.IDBRepository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgresRepository implements IDBRepository {
  private static PostgresRepository instance;
  private static Connection connection;

  private PostgresRepository() throws ServletException {
    try {
      Context context = new InitialContext();
      DataSource ds =  (DataSource) context.lookup("java:comp/env/jdbc/j2a");
      connection = ds.getConnection();
    } catch(SQLException | NamingException e){
      throw new ServletException("Couldn't connect to DB.");
    }
  }

  @Override
  public Connection getConnection() {
    return connection;
  }

  public static PostgresRepository getInstance() {
    try {
      if (instance == null || connection == null || connection.isClosed()){
        instance = new PostgresRepository();
      }
    } catch(SQLException | ServletException e){
      System.out.println("Something went wrong with DB");
    }
    return instance;
  }
}
