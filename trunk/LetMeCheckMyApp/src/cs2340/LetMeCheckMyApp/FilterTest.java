package cs2340.LetMeCheckMyApp;

import java.util.ArrayList;
import android.test.ActivityInstrumentationTestCase2;

public class FilterTest extends ActivityInstrumentationTestCase2<LetMeCheckMyAppActivity> {

	private Filter sl;
	private ArrayList<Task> list;
	private ArrayList<Task> list2;
	
	public FilterTest() {
		super(LetMeCheckMyAppActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ManageTaskList mtl = new ManageTaskList();
		list = new ArrayList<Task>();
		list2 = new ArrayList<Task>();
		Task t0 = new Task();
		Task t1 = new Task();
		t0.setComplete(true);
		t1.setComplete(false);
		t0.setCategory("Work");
		t1.setCategory("School");
		list.add(t0);
		list.add(t1);
		list2.add(t0);
		list2.add(t1);
		mtl.setList(list);
		mtl.setList2(list2);
		sl = new Filter(mtl);

	}

	public void testCheckComplete() {
		sl.checkComplete("complete");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), list2.get(0));		
	}

	public void testEmptyRepopulate(){
		list.clear();
		list2.clear();
		sl.repopulate();
		assertEquals(list.size(), 0);
	
	}
	
	public void testEmptyComplete(){
		list.clear();
		list2.clear();
		sl.checkComplete("complete");
		assertEquals(list.size(), 0);
	}
	
	public void testEmptyInomplete(){
		list.clear();
		list2.clear();
		sl.checkIncomplete("incomplete");
		assertEquals(list.size(), 0);
	}
	
	public void testEmptyFilter(){
		list.clear();
		list2.clear();
		sl.filterByCat("Work");
		assertEquals(list.size(), 0);
	}
	
	public void testCheckIncomplete() {
		sl.checkIncomplete("incomplete");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), list2.get(1));
	}

	public void testFilterByCat() {
		sl.filterByCat("Work");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), list2.get(0));
	}

	public void testRepopulate() {
		list.clear();
		sl.repopulate();
		assertEquals(list.get(0), list2.get(0));
		assertEquals(list.get(1), list2.get(1));
	}
	
}