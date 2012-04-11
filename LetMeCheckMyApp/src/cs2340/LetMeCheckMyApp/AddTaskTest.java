package cs2340.LetMeCheckMyApp;

import java.util.Calendar;

import android.test.ActivityInstrumentationTestCase2;

public class AddTaskTest extends ActivityInstrumentationTestCase2<AddTask> {
	public AddTaskTest() {
		super(AddTask.class);
	}

	public void testCreateTask(){
		AddTask activity = this.getActivity();
		boolean success = activity.createTask(new Task("name", "description", "category", Calendar.getInstance(), "user", "location"));
		
		assertEquals(true, success);
	}
	
	public void testUserExists(){
		AddTask activity = this.getActivity();
		boolean exists = activity.taskExists(new Task("fakename"));
		assertEquals(false, exists);
	}
}
