package cs2340.LetMeCheckMyApp;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckBoxChangedListener implements OnCheckedChangeListener{
	Task task;
	CheckBox box;
	
	public CheckBoxChangedListener(Task task, CheckBox box){
		this.task = task;
		this.box = box;
	}
	
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		//task.setComplete(false);
		if (box.isChecked() ){
			task.setComplete(true);
		}	
		
	}

}
