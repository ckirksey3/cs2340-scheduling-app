package cs2340.LetMeCheckMyApp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * Handles events raised by the delete button next to each item in the task list
 * @author Caleb
 *
 */
public class DeleteTaskListener implements OnClickListener{
	Task task;
	CheckBox box;
	
	public DeleteTaskListener(Task task, CheckBox box){
		this.task = task;
		this.box = box;
	}
	
	/**
	 * 
	 */
	public void onClick(View view) {
		//task.remove();
	}

}
