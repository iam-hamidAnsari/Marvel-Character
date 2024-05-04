package marvel.entity;

import java.io.Serializable;
import java.util.Date;

public class Attendence implements Serializable{
	private String superheroName;
	private int id;
	private Date date;
	private boolean isPresent;
	public boolean isPresent() {
		return isPresent;
	}
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}
	private String Discription;
	public String getSuperheroName() {
		return superheroName;
	}
	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	

}
