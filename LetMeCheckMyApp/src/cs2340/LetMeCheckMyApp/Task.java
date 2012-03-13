package cs2340.LetMeCheckMyApp;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 
 * Information holder for a task
 * 
 * 
 * @author Caleb
 *
 */
public class Task implements Serializable {

	private static final long serialVersionUID = -8558142619554107137L;
	private String name;
	private String description;
	private String category;
	private Calendar completeDate;
	
	public Task() {
		this("defaultName","");
	}
	
	/**
	 * 
	 * @param name	basic title of the task
	 */
	public Task(String name) {
		this(name,"");
	}
	
	/**
	 * 
	 * @param name			basic title of the task
	 * @param description	more detailed description of the task
	 */
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	/**
	 * 
	 * @param name	basic title of the task
	 * @param description	more detailed description of the task 
	 * @param category	the area of life that the task is associated with (school, work, etc)
	 * @param completeDate	the date that the users plans to have the task completed
	 */
	public Task(String name, String description, String category, Calendar completeDate) {
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
	public void setCompleteDate(Calendar completeDate){
		this.completeDate = completeDate;
	}
	public Calendar getCompleteDate(){
		return completeDate;
	}
	
	
	@Override
	public String toString() {
		return name;
	}
}
