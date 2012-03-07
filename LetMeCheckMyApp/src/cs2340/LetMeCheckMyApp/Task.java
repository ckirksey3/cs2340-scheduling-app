package cs2340.LetMeCheckMyApp;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {

	private static final long serialVersionUID = -8558142619554107137L;
	private String name;
	private String description;
	private String category;
	private Date completeDate;
	
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
	
	public Task(String name, String description, String category, Date completeDate) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.completeDate = completeDate;
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
	public void setCategory(String category){
		this.category = category;
	}
	public String getCategory(){
		return category;
	}
	public void setCompleteDate(Date completeDate){
		this.completeDate = completeDate;
	}
	public Date getCompleteDate(){
		return completeDate;
	}
	
	
	@Override
	public String toString() {
		return name;
	}
}
