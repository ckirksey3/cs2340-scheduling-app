package cs2340.LetMeCheckMyApp;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addtask);

		final EditText taskNameET = (EditText) findViewById(R.id.TaskNameText);
		final EditText descriptionET = (EditText) findViewById(R.id.TaskDescriptionText);
		final EditText categoryET = (EditText) findViewById(R.id.TaskCategoryText);
		final DatePicker dateWidget = (DatePicker) findViewById(R.id.datePicker1);

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
				String category = categoryET.getText().toString();
				
				Calendar date = Calendar.getInstance();
				date.set(Calendar.YEAR, dateWidget.getYear());
				date.set(Calendar.MONTH, dateWidget.getMonth());
				date.set(Calendar.DAY_OF_MONTH, dateWidget.getDayOfMonth());
				
				setResult(RESULT_OK, new Intent().putExtra("AddTask", new Task(taskName,description, category, date)));
				finish();

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