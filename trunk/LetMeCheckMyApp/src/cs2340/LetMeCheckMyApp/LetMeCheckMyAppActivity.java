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
        Button registerNewUser = (Button)findViewById(R.id.registerNewButton);
        registerNewUser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(view.getContext(), RegisterUser.class);
				startActivityForResult(myIntent, 0);
			}
		});
        Button signInButton = (Button)findViewById(R.id.signInButton);
        registerNewUser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				//setContentView(R.layout.taskList);
			}
		});
    }
}