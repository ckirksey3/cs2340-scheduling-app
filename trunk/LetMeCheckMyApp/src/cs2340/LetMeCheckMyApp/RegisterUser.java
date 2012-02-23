package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 
 * The activity class for 
 * the new user registration screen
 * 
 * 
 * @author Jeff
 *
 */
public class RegisterUser extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.registration);

	    Button next = (Button) findViewById(R.id.button1);
	    next.setOnClickListener(new View.OnClickListener() {
	    	/**
	    	 * when the registration button is clicked, this is executed
	    	 * and the screen will change.
	    	 */
	        public void onClick(View view) {
	            Intent intent = new Intent();
	            setResult(RESULT_OK, intent);
	            finish();
	        }
	    });
	}
}
