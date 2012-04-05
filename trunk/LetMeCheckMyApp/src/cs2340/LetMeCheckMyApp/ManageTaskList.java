package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * 
 * Activity class for the ManageTaskList screen
 * 
 * 
 * @author Caleb
 *
 */
public class ManageTaskList extends Activity {


	private ArrayList<Task> list;
	private ArrayAdapter<Task> listAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tasklist);

		ListView listview = (ListView) findViewById(R.id.TaskList);
		//TODO attempt to load the user's list from storage
		list = new ArrayList<Task>();
		listAdapter = new TaskAdapter(this, R.layout.list_item, list);
		listview.setAdapter(listAdapter);

		final DatePicker datePicker = (DatePicker) findViewById(R.id.datePickerFilter);
		
		//Spinner Stuff
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setOnItemSelectedListener(new SpinnerListener(this));
		ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.filter_array, android.R.layout.simple_spinner_item);
		listAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(spinnerAdapter);
		// end Spinner Stuff 

		//date filter stuff
		
		Button dateButton = (Button)findViewById(R.id.dateButton);
		dateButton.setOnClickListener(new View.OnClickListener()
		{
			/** 
			 * When the add filter by date button is clicked, this code is executed 
			 * */
			public void onClick(View view) {
				for (int i = 0; i< list.size(); i++){
					list.get(i).setVisible(true);
					listAdapter.notifyDataSetChanged();
				}
				
				
				Calendar date = Calendar.getInstance();
				date.set(Calendar.YEAR, datePicker.getYear());
				date.set(Calendar.MONTH, datePicker.getMonth());
				date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

				int i = list.size()-1;				
				while (i >= 0){
					if (list.get(i).getCompleteDate().compareTo(date) < 0){ // if not the correct category move the item to the other list for storage
						list.get(i).setVisible(false);
						listAdapter.notifyDataSetChanged();
					}
					i--;
				}
				
			}
		});
		
		
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
		
		Button deleteTaskButton = (Button)findViewById(R.id.DeleteTaskButton);
		deleteTaskButton.setOnClickListener(new View.OnClickListener()
		{
			/** 
			 * When the add new task button is clicked, this code is executed 
			 * */
			public void onClick(View view) {
				//ListView listV = (ListView)findViewById(R.id.TaskList);
				//Task currentTask = (Task)listV.getSelectedItem();
				//filteredList.add(currentTask);
				//currentTask.remove(list);
			}
		});
		
		Button showMapButton = (Button)findViewById(R.id.ShowMapButton);
		showMapButton.setOnClickListener(new View.OnClickListener()
		{
			/** 
			 * When the add new task button is clicked, this code is executed 
			 * */
			public void onClick(View view) {
				//TODO: show map of tasks
				Intent myIntent = new Intent(view.getContext(), GMapsActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			System.out.println("adding Task");
			list.add((Task)data.getSerializableExtra("AddTask"));
			listAdapter.notifyDataSetChanged();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		//TODO save list to SD
	}

	public ArrayList<Task> getList() {
		return list;
	}

	public void setList(ArrayList<Task> list) {
		this.list = list;
	}

	public ArrayAdapter<Task> getListAdapter() {
		return listAdapter;
	}

	public void setListAdapter(ArrayAdapter<Task> listAdapter) {
		this.listAdapter = listAdapter;
	}


}