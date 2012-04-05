package cs2340.LetMeCheckMyApp;
import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

/**
 * Used to handle events raised by the filter Spinner
 * @author Caleb
 *
 */
public class Filter implements OnItemSelectedListener {
	private ArrayList<Task> list;
	private ArrayList<Task> list2;
	private ArrayAdapter<Task> listAdapter;
	
	public Filter (ManageTaskList x){
		list = x.getList();
		list2 = x.getList2();
		listAdapter = x.getListAdapter();
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
		updateList();
	}

	
	/**
	 * Executes if none of the options are selected by the user
	 */
	public void onNothingSelected(AdapterView<?> parent) {
		/*
		for (int i = 0; i< t.size(); i++){
			t.get(i).setVisible(true);
		}
		*/
	}
	
	/**
	 * sets all tasks to visible again
	 */
	public void repopulate(){
		/*
		for (int i = 0; i< t.size(); i++){
			t.get(i).setVisible(true);
		}
		*/
		listAdapter.clear();
		for (int i = 0; i< list2.size(); i++){
			listAdapter.add(list2.get(i));
		}
	}
	
	/**
	 * filters the list
	 * 
	 * @param parent the Spinner that raised the event
	 * @param s the category chosen from the spinner
	 */
	public void filter(AdapterView<?> parent, String s){
		
		if (checkComplete(s))
			return;
		
		else if (checkIncomplete(s))
			return;
		
		else if (s.equals(parent.getItemAtPosition(0))) // check if empty
			return;
			
		else 
			filterByCat(s);
		
	}
	
	/**
	 * filters the list by completed status, keeping only completed tasks
	 * 
	 * @param s The category the user selected from the spinner
	 * @return if s was "complete"
	 */
	public boolean checkComplete(String s){
		/*
		if (s.equalsIgnoreCase("complete")) {
			for (int i = 0; i< t.size(); i++){
				if (t.get(i).isComplete() == false){ // if not the correct category move the item to the other list for storage
					t.get(i).setVisible(false);
				}
			}
			return true;
		}
		return false;
		*/
		if (s.equalsIgnoreCase("complete")) {
			for (int i=list.size()-1; i>=0; i--){
				if (listAdapter.getItem(i).isComplete() == false){ // if not the correct category move the item to the other list for storage
					listAdapter.remove(listAdapter.getItem(i));
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * filters the list by completed status, keeping only incomplete tasks
	 * 
	 * @param s The category the user selected from the spinner
	 * @return if s was "complete"
	 */
	public boolean checkIncomplete(String s){
		/*if (s.equalsIgnoreCase("incomplete")) {
			for (int i = 0; i< t.size(); i++){
				if (t.get(i).isComplete() == true){ // if not the correct category 
					t.get(i).setVisible(false);
				}
			}
			return true;
		}
		return false;*/
		if (s.equalsIgnoreCase("incomplete")) {
			for (int i=list.size()-1; i>=0; i--){
				if (listAdapter.getItem(i).isComplete() == true){ // if not the correct category
					listAdapter.remove(listAdapter.getItem(i));
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * filters by category selected by spinner
	 * @param s the category chosen
	 */
	public void filterByCat(String s){
		/*
		for (int i = 0; i< t.size(); i++){
			if (!t.get(i).getCategory().equalsIgnoreCase(s)){ // if not the correct category
				t.get(i).setVisible(false);
			}
		}*/
		for (int i=list.size()-1; i>=0; i--){
			if (!listAdapter.getItem(i).getCategory().equalsIgnoreCase(s)){ // if not the correct category
				listAdapter.remove(listAdapter.getItem(i));
			}
		}
	}
	
	public void updateList(){
		listAdapter.notifyDataSetChanged();
	}
}
