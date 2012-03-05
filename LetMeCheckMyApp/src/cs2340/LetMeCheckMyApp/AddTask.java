package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AddTask extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        
        Button addTaskButton = (Button)findViewById(R.id.CompleteAddTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
        	/** 
        	 * When the sign in button is clicked, this code is executed 
        	 * */
			public void onClick(View view) {
				
				/*
				 * Add the task to the user's task list
				 *  */
				
				Intent myIntent = new Intent(view.getContext(), ManageTaskList.class);
            	startActivityForResult(myIntent, 0);
			}
		});
    }
}