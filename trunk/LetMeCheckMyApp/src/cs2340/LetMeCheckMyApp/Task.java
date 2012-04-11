package cs2340.LetMeCheckMyApp;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.widget.CheckBox;

/**
 * 
 * Information holder for a task
 * 
 * 
 * @author Caleb
 *
 */

@SuppressWarnings("serial")
public class Task implements Serializable {
	
	//private static final long serialVersionUID = -5016996327245317143L;
	private boolean isComplete = false;
	private String name;
	private String description;
	private String category;
	private Calendar completeDate;
	private CheckBox checkBox;
	private Date date;
	private String user;
	private String location;
	
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

	public Task(String name, String description, String category, Calendar completeDate, String user, String location) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.completeDate = completeDate;
		this.user = user;
		this.setLocation(location);
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
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public String getUser(){
		return this.user;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public CheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public String completionDateToString()
	{
		return (this.completeDate.getTime().getMonth()+1) + "/" + this.completeDate.getTime().getDate() + "/" + this.completeDate.getTime().getYear();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String toFileFormat(){
		return (name+"\t"+
				isComplete+"\t"+
				description+"\t"+
				category+"\t"+
				completeDate.getTimeInMillis()+"\t"+
				user+"\t"+
				location+"\n");
	}
}
