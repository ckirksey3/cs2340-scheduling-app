package cs2340.LetMeCheckMyApp;

import java.util.Calendar;
import android.test.ActivityInstrumentationTestCase2;

public class TaskTest extends ActivityInstrumentationTestCase2<LetMeCheckMyAppActivity> {

	 private LetMeCheckMyAppActivity mActivity;
	 private Task testT;
	 public TaskTest() {
		super(LetMeCheckMyAppActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
		testT = new Task();
        mActivity.getString(R.string.hello);
    }
	
	public void testPreconditions() {
	      assertNotNull(testT);
    }

	public void testTask() {
		testT.setName("myTest");
		testT.setDescription("this is a test task object");
		assertEquals("myTest", testT.getName());
		assertEquals("this is a test task object", testT.getDescription());
	}
	
	public void testTaskDate()
	{
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2013);
		date.set(Calendar.MONTH, 12);
		date.set(Calendar.DAY_OF_MONTH, 1);
		
		testT.setCompleteDate(date);
		assertEquals(date, testT.getCompleteDate());
	}
	
	
}
