package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class FilterTest extends ActivityInstrumentationTestCase2<LetMeCheckMyAppActivity> {

	private LetMeCheckMyAppActivity mActivity;
	private TextView mView;
	private String resourceString;
	private SpinnerListener sl;
	private ArrayList<Task> list;

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
		ManageTaskList mtl = new ManageTaskList();
		list = new ArrayList<Task>();
		Task t0 = new Task();
		Task t1 = new Task();
		t0.setComplete(true);
		t1.setComplete(false);
		t0.setCategory("Work");
		t1.setCategory("School");
		list.add(t0);
		list.add(t1);
		mtl.setList(list);
		sl = new SpinnerListener(mtl);

	}

	public void testCheckComplete() {

		sl.checkComplete("complete");
		assertEquals(list.get(0).isVisible(), true);
		assertEquals(list.get(1).isVisible(), false);
		
	}

	public void testCheckIncomplete() {
		sl.checkIncomplete("incomplete");
		assertEquals(list.get(0).isVisible(), false);
		assertEquals(list.get(1).isVisible(), true);
	}

	public void testFilterByCat() {
		sl.filterByCat("Work");
		assertEquals(list.get(0).isVisible(), true);
		assertEquals(list.get(1).isVisible(), false);
	}

	public void testRepopulate() {
		list.get(0).setVisible(false);
		list.get(1).setVisible(true);
		sl.repopulate();
		assertEquals(list.get(0).isVisible(), true);
		assertEquals(list.get(1).isVisible(), true);
	}
	
}