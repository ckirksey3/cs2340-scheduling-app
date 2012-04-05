package cs2340.LetMeCheckMyApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.view.View;
import android.widget.CheckBox;

/**
 * 
 * Information holder for a task
 * 
 * 
 * @author Caleb
 *
 */
public class Task implements Serializable {
	
	//private static final long serialVersionUID = -5016996327245317143L;
	private boolean visible = true;
	private boolean isComplete = false;
	private String name;
	private String description;
	private String category;
	private Calendar completeDate;
	private CheckBox checkBox;
	private Date date;
	
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
	public Task(String name, String description, String category, Calendar completeDate, Date date) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.completeDate = completeDate;
		this.date = date;
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
	
	@Override
	public String toString() {
		return name;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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
		return this.completeDate.MONTH + "/" + this.completeDate.DAY_OF_MONTH + "/" + this.completeDate.YEAR;
	}
	
}
