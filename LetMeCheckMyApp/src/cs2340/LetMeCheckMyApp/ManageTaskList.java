package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageTaskList extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);
        
        Button addTaskButton = (Button)findViewById(R.id.AddTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener()
        {
        	/** 
        	 * When the add new task button is clicked, this code is executed 
        	 * */
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), AddTask.class);
				startActivityForResult(myIntent, 0);
			}
		});
    }
}