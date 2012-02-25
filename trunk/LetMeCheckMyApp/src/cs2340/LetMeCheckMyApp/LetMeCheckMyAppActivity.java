package cs2340.LetMeCheckMyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LetMeCheckMyAppActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button registerNewUserButton = (Button)findViewById(R.id.registerNewButton);
        registerNewUserButton.setOnClickListener(new View.OnClickListener()
        
        {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(view.getContext(), RegisterUser.class);
				startActivityForResult(myIntent, 0);
			}
		});
        Button signInButton = (Button)findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
			
			/**
			 * 
			 */
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(view.getContext(), ManageTaskList.class);
				startActivityForResult(myIntent, 0);
			}
		});
    }
}