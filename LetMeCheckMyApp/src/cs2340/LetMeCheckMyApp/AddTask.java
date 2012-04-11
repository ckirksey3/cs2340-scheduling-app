package cs2340.LetMeCheckMyApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * 
 * Activity class for the AddTask screen
 * 
 * 
 * @author Caleb
 *
 */
public class AddTask extends Activity {
	private final String TASK_FILE = "tasks.dat";
	
	/** Called when the activity is first created. */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addtask);

		final EditText taskNameET = (EditText) findViewById(R.id.TaskNameText);
		final EditText descriptionET = (EditText) findViewById(R.id.TaskDescriptionText);
		final DatePicker dateWidget = (DatePicker) findViewById(R.id.datePicker1);
		final EditText locationET = (EditText) findViewById(R.id.LocationText);

		//Populate Category Spinner
		 final Spinner categorySpinner = (Spinner) findViewById(R.id.TaskCategorySpinner);
		    ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
		            this, R.array.category_array, android.R.layout.simple_spinner_item);
		    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    categorySpinner.setAdapter(spinnerAdapter);
		
		Button addTaskButton = (Button)findViewById(R.id.CompleteAddTaskButton);
		addTaskButton.setOnClickListener(new View.OnClickListener() {
			/** 
			 * When the Add Task button is clicked, this code is executed 
			 */
			public void onClick(View view) {
				/*
				 * Return the added task to the calling activity
				 */
				String taskName = taskNameET.getText().toString();
				String description = descriptionET.getText().toString();
				String category = categorySpinner.getSelectedItem().toString();
				String location = locationET.getText().toString();
				
				Calendar date = Calendar.getInstance();
				date.set(Calendar.YEAR, dateWidget.getYear());
				date.set(Calendar.MONTH, dateWidget.getMonth());
				date.set(Calendar.DAY_OF_MONTH, dateWidget.getDayOfMonth());
				
				/*for database
				Context context = getApplicationContext();
				context.deleteDatabase("DB");
				DatabaseHelper dh = new DatabaseHelper(context);
				int id = dh.nextID();
				Task newtask = new Task(taskName,description, category, date, id, "user");
				dh.insertTask(newtask);
				*/
				
				Task task = new Task(taskName,description, category, date, "user", location); //how to get actual username?
				if(!taskExists(task)){ //check if task already exists
					if(createTask(task))
					{
						setResult(RESULT_OK, new Intent().putExtra("AddTask", task));
						displayMessage("Task added successfully");
						finish();
					}
					else
					{
						displayMessage("Error in task creation");
					}
				}else{
					displayMessage("A task with that name already exists.");
				}
			}
		});

		// adds cancel button functionality
		Button cancelButton = (Button)findViewById(R.id.CancelAddTaskButton);
		cancelButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});


	}
	/**
	 * Adds a task
	 * @param task Task to add
	 * @return true if the task was added successfully, false if a problem occurred
	 */
	boolean createTask(Task task)
	{
		Log.d("AddTask", "Storing "+task.getName()+" in "+TASK_FILE);
		try{
			FileOutputStream fos = openFileOutput(TASK_FILE, Context.MODE_APPEND);
			fos.write(task.toFileFormat().getBytes());
			fos.close();
			return true;
		}catch(IOException e){
			Log.e("AddTask", e.getMessage());
			return false;
		}
		
	}
	
	
	/**
	 * Checks if a task already exists in the database
	 * @param task Task to check
	 * @return	true if the task exists, false otherwise
	 */
	boolean taskExists(Task task){
		Log.d("AddTask", "Checking if \""+task.getName()+"\" already exists.");
		boolean found = false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getFilesDir()+"/"+TASK_FILE))));
			String line;
			while((line = br.readLine()) != null && !found){
				String[] items = line.split("\t");
				if(items[0].equals(task.getName()) && items[5].equals(task.getUser())){
					found = true;
				}
			}
		}catch(IOException e){
			Log.e("RegisterUser", e.getMessage());
		}finally {
			try{
				if(br != null)
					br.close();
			}catch(IOException e){
				Log.e("RegisterUser", e.getMessage());
			}
		}
		return found;
	}
	
	/**
	 * Displays an error message to the user
	 * @param msg	Message to be displayed
	 */
	private void displayMessage(String msg){
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, msg, duration);
		toast.show();
	}
}