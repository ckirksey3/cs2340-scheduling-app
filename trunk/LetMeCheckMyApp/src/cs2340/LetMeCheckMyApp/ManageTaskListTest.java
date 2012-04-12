package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;

import junit.framework.Assert;

//import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;



public class ManageTaskListTest extends ActivityInstrumentationTestCase2<ManageTaskList> {

	private ManageTaskList mtl;
	//private Solo solo;
	public ManageTaskListTest() {
		super(ManageTaskList.class);
	}
	
	public void setUp() throws Exception {
		mtl = new ManageTaskList();
        //solo = new Solo(getInstrumentation(), getActivity());
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
	
	 public void testAddTask() throws Exception {
		 
		 AddTask at = new AddTask();
		 
		 ArrayList<Task> taskList = mtl.getAllTasks("user");
		 Task testTask = new Task();
		 testTask.setName("Test Task");
		 at.createTask(testTask);
		 
		 ArrayList<Task> newTaskList = mtl.getAllTasks("user");
		 
		 assertEquals(false, newTaskList.equals(taskList));
		 assertEquals(false, taskList.contains(testTask));
		 assertEquals(true, newTaskList.contains(testTask));
		 
		 
		 //solo.clickOnText("Add Task");
		 //assertTrue(solo.searchText("Description"));
		 
         /*solo.sendKey(Solo.MENU);
         solo.clickOnText("More");
         solo.clickOnText("Preferences");
         solo.clickOnText("Edit File Extensions");
         Assert.assertTrue(solo.searchText("rtf"));
         
         solo.clickOnText("txt");
         solo.clearEditText(2);
         solo.enterText(2, "robotium");
         solo.clickOnButton("Save");
         solo.goBack();
         solo.clickOnText("Edit File Extensions");
         Assert.assertTrue(solo.searchText("application/robotium"));*/
         
}
	public void testRemoveTask() throws Exception {
			 
			 AddTask at = new AddTask();
			
			 Task testTask = new Task();
			 testTask.setName("Test Task");
			 at.createTask(testTask);
			 ArrayList<Task> newTaskList = mtl.getAllTasks("user");

			 assertEquals(true, newTaskList.contains(testTask));
			 
			 mtl.removeTask(testTask);
			 
			 newTaskList = mtl.getAllTasks("user");
			 
			 assertEquals(false, newTaskList.contains(testTask));
			 
	         
	}
}
