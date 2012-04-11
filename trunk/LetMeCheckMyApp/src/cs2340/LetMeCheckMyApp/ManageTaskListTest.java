package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;

public class ManageTaskListTest extends ActivityInstrumentationTestCase2<ManageTaskList> {

	public ManageTaskListTest() {
		super(ManageTaskList.class);
	}
	
	public void testGetAllTasks(){
		ManageTaskList activity = this.getActivity();
		ArrayList<Task> tasks = activity.getAllTasks("fakeuser");
		
		assertEquals(0, tasks.size());
	}
	
	public void testDeleteTasks(){
		ManageTaskList activity = this.getActivity();
		boolean success = activity.deleteTask(new Task());
		
		assertEquals(true, success);
	}
}
