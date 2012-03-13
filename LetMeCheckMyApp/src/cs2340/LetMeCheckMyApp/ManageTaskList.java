package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * 
 * Activity class for the ManageTaskList screen
 * 
 * 
 * @author Caleb
 *
 */
public class ManageTaskList extends Activity {
	
	ArrayList<Task> list;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tasklist);

		ListView listview = (ListView) findViewById(R.id.TaskList);
		//TODO attempt to load the user's list from storage
		list = new ArrayList<Task>();
		final ArrayAdapter<Task> adapter;
		adapter = new TaskAdapter(this, R.layout.list_item, list);
		listview.setAdapter(adapter);

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
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			list.add((Task)data.getSerializableExtra("AddTask"));
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		//TODO save list to SD
	}
}