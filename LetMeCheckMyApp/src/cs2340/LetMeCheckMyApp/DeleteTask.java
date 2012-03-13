package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
 * 
 * Class in progress..(may not be necessary in the end)
 * 
 * 
 * @author Caleb
 *
 */
public class DeleteTask extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //what to pass for context?
        Intent myIntent = new Intent(null, ManageTaskList.class);
    	startActivityForResult(myIntent, 0);
    }
}