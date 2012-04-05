package cs2340.LetMeCheckMyApp;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

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
		repopulate();
		String category = (String) parent.getSelectedItem(); 
		filter(parent, category);

	}

	
	/**
	 * Executes if none of the options are selected by the user
	 */
	public void onNothingSelected(AdapterView<?> parent) {
		for (int i = 0; i< t.getList().size(); i++){
			t.getList().get(i).setVisible(true);
		}
	}
	
	public void repopulate(){
		for (int i = 0; i< t.getList().size(); i++){
			t.getList().get(i).setVisible(true);
			t.getListAdapter().notifyDataSetChanged();
		}
	}
	
	public void filter(AdapterView<?> parent, String s){
		
		if (s.equalsIgnoreCase("complete")) {
			for (int i = 0; i< t.getList().size(); i++){
				if (t.getList().get(i).isComplete() == false){ // if not the correct category move the item to the other list for storage
					t.getList().get(i).setVisible(false);
					t.getListAdapter().notifyDataSetChanged();
				}
			}
			return;
		}
		
		if( s.equalsIgnoreCase("incomplete")){
			for (int i = 0; i< t.getList().size(); i++){
				if (t.getList().get(i).isComplete() == true){ // if not the correct category move the item to the other list for storage
					t.getList().get(i).setVisible(false);
					t.getListAdapter().notifyDataSetChanged();
				}
			}
			return;
		}
		
		if (s.equals(parent.getItemAtPosition(0)))
			return;
			
		
		for (int i = 0; i< t.getList().size(); i++){
			if (!t.getList().get(i).getCategory().equalsIgnoreCase(s)){ // if not the correct category move the item to the other list for storage
				t.getList().get(i).setVisible(false);
				t.getListAdapter().notifyDataSetChanged();
			}
		}
	}
	
}
