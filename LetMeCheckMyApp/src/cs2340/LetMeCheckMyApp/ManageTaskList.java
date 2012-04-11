package cs2340.LetMeCheckMyApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	private final String TASK_FILE = "tasks.dat";
	

	private ArrayList<Task> list;
	private ArrayList<Task> list2;
	private ArrayAdapter<Task> listAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tasklist);

		ListView listview = (ListView) findViewById(R.id.TaskList);
		//TODO attempt to load the user's list from storage
		list = new ArrayList<Task>();
		list2 = getAllTasks("user"); //DAN: how to get current user?
		listAdapter = new TaskAdapter(this, R.layout.list_item, list, this);
		listview.setAdapter(listAdapter);

		final DatePicker datePicker = (DatePicker) findViewById(R.id.datePickerFilter);
		
		//Spinner Stuff
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setOnItemSelectedListener(new Filter(this));
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
				//repopulate
				list.clear();
				for (int i = 0; i< list2.size(); i++){
					list.add(list2.get(i));
				}
				listAdapter.notifyDataSetChanged();
				
				
				Calendar date = Calendar.getInstance();
				date.set(Calendar.YEAR, datePicker.getYear());
				date.set(Calendar.MONTH, datePicker.getMonth());
				date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

				int i = list.size()-1;				
				while (i >= 0){
					if (list.get(i).getCompleteDate().compareTo(date) < 0){ // if not the correct category move the item to the other list for storage
						list.remove(list.get(i));
						
					}
					i--;
				}
				listAdapter.notifyDataSetChanged();
				
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
			 * When the delete task button is clicked, this code is executed 
			 * */
			public void onClick(View view) {
				ListView listV = (ListView)findViewById(R.id.TaskList);
				Task currentTask = (Task)listV.getSelectedItem();
				removeTask(currentTask);
			}
		});
		
		Button showMapButton = (Button)findViewById(R.id.ShowMapButton);
		showMapButton.setOnClickListener(new View.OnClickListener()
		{
			/** 
			 * When the add new task button is clicked, this code is executed 
			 * */
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), GMapsActivity.class);
				myIntent.putExtra("list", list);
				startActivityForResult(myIntent, 0);
			}
		});
	}
	
	/*
	 * Removes a task from both the screen and the permanent list
	 */
	public void removeTask(Task task)
	{
		list.remove(task);
		list2.remove(task);
		deleteTask(task);
		listAdapter.notifyDataSetChanged();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			System.out.println("adding Task");
			list.add((Task)data.getSerializableExtra("AddTask"));
			list2.add((Task)data.getSerializableExtra("AddTask"));
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
	
	public ArrayList<Task> getList2() {
		return list2;
	}

	public void setList2(ArrayList<Task> list) {
		this.list2 = list;
	}
	
	/**
	 * Gets all the tasks for the specified user
	 * @param user The user's tasks to get
	 * @return
	 */
	public ArrayList<Task> getAllTasks(String user){
		ArrayList<Task> list = new ArrayList<Task>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getFilesDir()+"/"+TASK_FILE))));
			String line;
			while((line = br.readLine()) != null){
				String[] items = line.split("\t");
				if(items[5].equals(user)){
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date(Long.parseLong(items[4])));
					list.add(new Task(items[0], items[2], items[3], cal, items[5], items[6]));
				}
			}
		}catch(IOException e){
			//Log.e("ManageTaskList", e.getMessage());
		}finally {
			try{
				if(br != null)
					br.close();
			}catch(IOException e){
				//Log.e("ManageTaskList", e.getMessage());
			}
		}
		return list;
	}
	
	/**
	 * Deletes a task
	 * @param task Task to be deleted
	 * @return True if success, false otherwise
	 */
	boolean deleteTask(Task task)
	{
		Log.d("ManageTaskList", "Deleting "+task.getName());
		//record all but the one being deleted to write them back
		String str = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getFilesDir()+"/"+TASK_FILE))));
			String line;
			while((line = br.readLine()) != null){
				String[] items = line.split("\t");
				if(items[0].equals(task.getName()) && items[5].equals(task.getUser())){
					//do nothing
				}else{
					str+=line+"\n";
				}
			}
		}catch(IOException e){
			//Log.e("AddTask", e.getMessage());
		}finally {
			try{
				if(br != null)
					br.close();
			}catch(IOException e){
				//Log.e("AddTask", e.getMessage());
			}
		}
		
		//write string from above back into the file
		try{
			FileOutputStream fos = openFileOutput(TASK_FILE,Context.MODE_PRIVATE);
			fos.write(str.getBytes());
			fos.close();
			return true;
		}catch(IOException e){
			Log.e("AddTask", e.getMessage());
			return false;
		}
		
	}


}