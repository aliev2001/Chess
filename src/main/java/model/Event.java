package model;

import java.sql.Date;

public class Event {
	private long id;
	private String title;
	private String text;
	private Date date;

	public Event(){}

	public Event(long id, String title, String text, Date date) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = date;
	}

	public Event(String title, String text, Date date) {
		this.title = title;
		this.text = text;
		this.date = date;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
