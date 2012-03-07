package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTask extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        
        final EditText taskNameET = (EditText) findViewById(R.id.TaskNameText);
        
        Button addTaskButton = (Button)findViewById(R.id.CompleteAddTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
        	/** 
        	 * When the sign in button is clicked, this code is executed 
        	 */
			public void onClick(View view) {
				
				/*
				 * Return the added task to the calling activity
				 */
				String taskName = taskNameET.getText().toString();
				if (taskName != "") {
	            	setResult(RESULT_OK, new Intent().putExtra("AddTask", taskName));
	            	finish();
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
}