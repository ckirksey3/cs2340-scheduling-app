package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class FilterTest extends ActivityInstrumentationTestCase2<LetMeCheckMyAppActivity> {

	private LetMeCheckMyAppActivity mActivity;
	private TextView mView;
	private String resourceString;


	public FilterTest() {
		super(LetMeCheckMyAppActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		//mView = (TextView) mActivity.findViewById(R.id.);
		resourceString = mActivity.getString(R.string.hello);
	}

	public void testCheckComplete() {
		ArrayList<Task> list = new ArrayList<Task>();
		Task t1 = new Task();
		Task t2 = new Task();
		t1.setComplete(true);
		t2.setComplete(false);
		list.add(t1);
		list.add(t2);
		assertEquals(t1.isVisible(), true);
		assertEquals(t2.isVisible(), false);
		
	}

	public void testCheckIncomplete() {
		ArrayList<Task> list = new ArrayList<Task>();
		Task t1 = new Task();
		Task t2 = new Task();
		t1.setComplete(true);
		t2.setComplete(false);
		list.add(t1);
		list.add(t2);
		assertEquals(t1.isVisible(), false);
		assertEquals(t2.isVisible(), true);
	}

	public void testFilterByCat() {
		ArrayList<Task> list = new ArrayList<Task>();
		Task t1 = new Task();
		Task t2 = new Task();
		t1.setCategory("Work");
		t2.setCategory("School");
		list.add(t1);
		list.add(t2);
		assertEquals(t1.isVisible(), false);
		assertEquals(t2.isVisible(), true);
	}

	public void testRepopulate() {
		ArrayList<Task> list = new ArrayList<Task>();
		Task t1 = new Task();
		Task t2 = new Task();
		t1.setCategory("Work");
		t2.setCategory("School");
		list.add(t1);
		list.add(t2);
	}
	
}