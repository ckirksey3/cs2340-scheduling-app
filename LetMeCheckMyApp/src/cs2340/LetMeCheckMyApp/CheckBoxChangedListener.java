package cs2340.LetMeCheckMyApp;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * Handles events raised by the checkboxes next to each item in the task list
 * @author Caleb
 *
 */
public class CheckBoxChangedListener implements OnCheckedChangeListener{
	Task task;
	CheckBox box;
	
	public CheckBoxChangedListener(Task task, CheckBox box){
		this.task = task;
		this.box = box;
	}
	
	/**
	 * Executes when a box is checked, sets the isComplete attribute of the
	 * task object associated with that CheckBox to false
	 * @param arg0 not used
	 * @param arg1 not used
	 */
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

		if (box.isChecked()){
			task.setComplete(true);
			return;
		}	
		task.setComplete(false);
		
	}

}
