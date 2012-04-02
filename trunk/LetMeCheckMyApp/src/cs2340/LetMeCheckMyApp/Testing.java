package cs2340.LetMeCheckMyApp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class Testing extends ActivityInstrumentationTestCase2<LetMeCheckMyAppActivity> {

	 private LetMeCheckMyAppActivity mActivity;
	 private TextView mView;
	 private String resourceString;
	public Testing() {
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
	
	public void testPreconditions() {
	      assertNotNull(mView);
    }
	
	public void testText() {
	      assertEquals(resourceString,(String)mView.getText());
    }
	
	public void testTask() {
		Task testT = new Task();
		testT.setName("myTest");
		assertEquals("myTest", testT.getName());
	}
}
