package cs2340.LetMeCheckMyApp;

import java.io.Serializable;

public class Task implements Serializable {

	private static final long serialVersionUID = -8558142619554107137L;
	private String name;
	private String description;
	//private Location location;
	//etc...
	
	public Task() {
		this("defaultName","");
	}
	
	public Task(String name) {
		this(name,"");
	}
	
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
