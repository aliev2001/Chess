package model;

public class User {
  private long id;
  private String name;
  private String surname;
  private String username;
  private String password;

  private User(UserBuilder builder){
    this.id = builder.id;
    this.name = builder.name;
    this.surname = builder.surname;
    this.username = builder.username;
    this.password = builder.password;
		}

  public static class UserBuilder {
    private long id;
    private String name;
    private String surname;
    private String username;
    private String password;


    public UserBuilder setId(long id){
      this.id = id;
      return this;
    }

    public UserBuilder setName(String name){
      this.name = name;
      return this;
    }

    public UserBuilder setSurname(String surname){
      this.surname = surname;
      return this;
    }

    public UserBuilder setUsername(String username){
      this.username = username;
      return this;
    }

    public UserBuilder setPassword(String password) {
      this.password = password;
      return this;
    }

    public User build(){
      return new User(this);
    }
  }

  public long getId(){
    return id;
  }

  public String getName(){
    return name;
  }

  public String getSurname(){
    return surname;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

}
