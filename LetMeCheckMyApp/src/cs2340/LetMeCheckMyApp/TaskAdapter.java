package cs2340.LetMeCheckMyApp;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * Adapter for displaying a Task object in the Task Listview
 * 
 * 
 * @author Caleb
 *
 */
public class TaskAdapter extends ArrayAdapter<Task> {

	int resource;
	String response;
	Context context;
	//Initialize adapter
	/**
	 * @param items  a list of tasks that will be placed in the View
	 * @param context	the context in which the adapter is being referenced
	 * @param resource	a reference to the xml file that outlines the format for each item in the List View
	 */
	public TaskAdapter(Context context, int resource, List<Task> items) {
		super(context, resource, items);
		this.resource=resource;

	}

	/**
	 * 
	 * Method called by View's getView method to generate the List View for this specific class
	 * 
	 * @return 	a view that includes this TaskAdapter's list of Task items
	 *
	 */
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LinearLayout taskView;
		//Get the current alert object
		Task task = getItem(position);

		//Inflate the view
		if(convertView==null)
		{
			taskView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi;
			vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, taskView, true);
		
		}
		else
		{
			taskView = (LinearLayout) convertView;
		}
		
		

		
		//Get the text boxes from the listitem.xml file
		TextView taskName =(TextView)taskView.findViewById(R.id.txtTaskName);
		TextView taskCategory =(TextView)taskView.findViewById(R.id.txtTaskCategory);
		CheckBox taskBox = (CheckBox)taskView.findViewById(R.id.checkbox);
		TextView taskDate =(TextView)taskView.findViewById(R.id.txtTaskDate);
		
		//Assign the appropriate data from our alert object above
		taskName.setText(task.getName());
		taskCategory.setText(task.getCategory());
		taskDate.setText((task.getCompleteDate().getTime().getMonth() + 1) + "/" + task.getCompleteDate().getTime().getDate());
		taskBox.setOnCheckedChangeListener(new CheckBoxChangedListener(task, taskBox));
		taskBox.setChecked(task.isComplete());

		if (task.isVisible()){
			taskView.setVisibility(View.VISIBLE);
		}
		else if (!task.isVisible()){
			taskView.setVisibility(View.GONE);
		} 
		
		return taskView;
		
	
	}

}