package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterUser extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.registration);

	    Button next = (Button) findViewById(R.id.button1);
	    next.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	            Intent intent = new Intent();
	            setResult(RESULT_OK, intent);
	            finish();
	        }

	    });}
}
