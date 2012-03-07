package cs2340.LetMeCheckMyApp;
import java.util.List;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
 
public class TaskAdapter extends ArrayAdapter<Task> {
 
    int resource;
    String response;
    Context context;
    //Initialize adapter
    public TaskAdapter(Context context, int resource, List<Task> items) {
        super(context, resource, items);
        this.resource=resource;
 
    }
 
    @Override
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
        TextView taskDescription =(TextView)taskView.findViewById(R.id.txtTaskDescription);
 
        //Assign the appropriate data from our alert object above
        taskName.setText(task.getName());
        taskDescription.setText(task.getDescription());
 
        return taskView;
    }
 
}