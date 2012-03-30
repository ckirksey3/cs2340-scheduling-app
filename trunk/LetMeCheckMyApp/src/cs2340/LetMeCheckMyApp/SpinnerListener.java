package cs2340.LetMeCheckMyApp;
import java.util.ArrayList;
import java.util.Calendar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

/**
 * Used to handle events raised by the filter Spinner
 * @author Caleb
 *
 */
public class SpinnerListener implements OnItemSelectedListener {
	private ManageTaskList t;
	
	public SpinnerListener (ManageTaskList x){
		t=x;
	}
	
	/**
	 * Method executed when the user selects an option from the filter Spinner
	 * @param parent	the Spinner that raised the event
	 * @param view	the view that contains the spinner
	 * @param pos the index of the selected item in the Spinner's list of items
	 * @id the id of the selected item
	 */
	public void onItemSelected(AdapterView<?> parent,View view, int pos, long id) {
		//repopulate the list
		for (int i = t.getFilteredList().size()-1; i>=0; i--){
			t.getList().add(t.getFilteredList().remove(i));
			t.getListAdapter().notifyDataSetChanged();
		}
		
		//filter the list
		String s = (String) parent.getSelectedItem(); 
		int i = t.getList().size()-1;
		
		
		if (s.equalsIgnoreCase("complete")) {
			while (i >= 0){
				if (t.getList().get(i).isComplete() == false){ // if not the correct category move the item to the other list for storage
					t.getFilteredList().add(t.getList().remove(i));
					t.getListAdapter().notifyDataSetChanged();
				}
				i--;
			}
			return;
		}
		if( s.equalsIgnoreCase("incomplete")){
			while (i >= 0){
				if (t.getList().get(i).isComplete() == true){ // if not the correct category move the item to the other list for storage
					t.getFilteredList().add(t.getList().remove(i));
					t.getListAdapter().notifyDataSetChanged();
				}
				i--;
			}
			return;
		}
		
		if (s.equals(parent.getItemAtPosition(0)))
			return;
			
		
		while (i >= 0){
			if (!t.getList().get(i).getCategory().equalsIgnoreCase(s)){ // if not the correct category move the item to the other list for storage
				t.getFilteredList().add(t.getList().remove(i));
				t.getListAdapter().notifyDataSetChanged();
			}
			i--;
		}
	}

	
	
	
	
	/**
	 * Executes if none of the options are selected by the user
	 */
	public void onNothingSelected(AdapterView<?> parent) {
		for (int i = t.getFilteredList().size()-1; i>=0; i--){
			t.getList().add(t.getFilteredList().remove(i));
			t.getListAdapter().notifyDataSetChanged();
		}
	}
	
	
	
	
}
