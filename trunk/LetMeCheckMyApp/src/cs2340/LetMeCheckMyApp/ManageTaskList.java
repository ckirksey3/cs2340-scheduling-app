package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ManageTaskList extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);
        
        String[] currentTaskList = new String[]{"Buy groceries", "Take out trash", "Take over the world"};
        
        ListView listview = (ListView) findViewById(R.id.TaskList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, currentTaskList);
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
}