package model;

public class Club {
	private long id;
	private String title;
	private String image;
	private String description;

	public Club(){}

	public Club(long id, String title, String image, String description) {
		this.id = id;
		this.title = title;
		this.image = image;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
