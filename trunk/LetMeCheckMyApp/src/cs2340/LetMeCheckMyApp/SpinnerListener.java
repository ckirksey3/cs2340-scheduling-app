package cs2340.LetMeCheckMyApp;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerListener implements OnItemSelectedListener {
	private ManageTaskList t;
	
	public SpinnerListener (ManageTaskList x){
		t=x;
	}
	
	public void onItemSelected(AdapterView<?> parent,View view, int pos, long id) {
		//repopulate the list
		for (int i = t.getFilteredList().size()-1; i>=0; i--){
			t.getList().add(t.getFilteredList().remove(i));
			t.getListAdapter().notifyDataSetChanged();
		}
		
		//filter the list
		String s = (String) parent.getSelectedItem(); // Is cast to string correct?
		if (s.equals(parent.getItemAtPosition(0)))
			return;
			
		int i = t.getList().size()-1;
		while (i >= 0){
			if (!t.getList().get(i).getCategory().equalsIgnoreCase(s)){ // if not the correct category move the item to the other list for storage
				t.getFilteredList().add(t.getList().remove(i));
				t.getListAdapter().notifyDataSetChanged();
			}
			i--;
		}
	}

	public void onNothingSelected(AdapterView<?> parent) {
		for (int i = t.getFilteredList().size()-1; i>=0; i--){
			t.getList().add(t.getFilteredList().remove(i));
			t.getListAdapter().notifyDataSetChanged();
		}
	}
}
