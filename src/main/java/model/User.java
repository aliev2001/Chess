package model;

public class User {
  private long id;
  private String name;
  private String surname;
  private String username;
  private String password;

	private int year;
	private String major;
	private String uGroup;

	private boolean isAdmin;

  private User(UserBuilder builder){
    this.id = builder.id;
    this.name = builder.name;
    this.surname = builder.surname;
    this.username = builder.username;
    this.password = builder.password;
		this.year = builder.year;
		this.major = builder.major;
		this.uGroup = builder.uGroup;
		this.isAdmin = builder.isAdmin;
  }

  public static class UserBuilder {
    private long id;
    private String name;
    private String surname;
    private String username;
    private String password;

		private int year;
		private String major;
		private String uGroup;

		private boolean isAdmin = false;

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

		public UserBuilder setYear(int year){
			this.year = year;
			return this;
		}

		public UserBuilder setMajor(String major){
			this.major = major;
			return this;
		}

		public UserBuilder setUGroup(String uGroup){
			this.uGroup = uGroup;
			return this;
		}

		public UserBuilder setIsAdmin(boolean isAdmin){
			this.isAdmin = isAdmin;
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

	public int getYear(){
		return year;
	}

	public String getMajor(){
		return major;
	}

	public String getUGroup(){
		return uGroup;
	}

	public boolean getIsAdmin(){
		return isAdmin;
	}
}
