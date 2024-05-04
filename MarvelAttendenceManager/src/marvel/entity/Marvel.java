package marvel.entity;

import java.io.Serializable;

public class Marvel implements Serializable {
	private int id;
	private String superheroName;
	private String superPower;
	private String realname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSuperheroName() {
		return superheroName;
	}
	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}
	public String getSuperPower() {
		return superPower;
	}
	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	

}
