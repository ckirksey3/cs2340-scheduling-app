package cs2340.LetMeCheckMyApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * The activity class for 
 * the login screen
 * 
 * 
 * @author Jeff
 *
 */
public class LetMeCheckMyAppActivity extends Activity {
	private final String USER_FILE = "users.dat";

	/** 
	 * Called when the activity is first created. 
	 * */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final EditText userNameET = (EditText) findViewById(R.id.userNameText);
		final EditText passwordET = (EditText) findViewById(R.id.passwordText);

		Button registerNewUserButton = (Button)findViewById(R.id.registerNewButton);
		registerNewUserButton.setOnClickListener(new View.OnClickListener()
		{
			/** 
			 * When the register new user button is clicked, this code is executed 
			 * */
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), RegisterUser.class);
				startActivityForResult(myIntent, 0);
			}
		});
		Button signInButton = (Button)findViewById(R.id.signInButton);
		signInButton.setOnClickListener(new View.OnClickListener() {
			/** 
			 * When the sign in button is clicked, this code is executed 
			 * */
			public void onClick(View view) {
				String username = userNameET.getText().toString();
				String password = passwordET.getText().toString();
				if(username.equals("") || password.equals("")){
					displayMessage("Enter both a username and password");
				}else if(verifyUser(username,password)){
					Log.d("SignIn", "Signing in as \""+username+"\"");
					displayMessage("SignIn Succesful!");

					Intent myIntent = new Intent(view.getContext(), ManageTaskList.class);
					startActivityForResult(myIntent, 0);
				}else{
					displayMessage("Username or password is incorrect");
				}
			}
		});
	}

	/**
	 * Verify that the user info matches an existing user.
	 * @param username	Username entered by user
	 * @param password	Password entered by user
	 * @return	true if info matches, false otherwise
	 */
	private boolean verifyUser(String username, String password){
		Log.d("SignIn", "Verfying user credentials for \""+username+"\"");
		boolean found = false;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getFilesDir()+"/"+USER_FILE))));
			String line;
			while((line = br.readLine()) != null && !found){
				String[] items = line.split("\t");
				if(items[0].equals(username) && items[1].equals(password)){
					found = true;
				}
				//Log.d("tbd", "Line="+line+", username="+items[0]+", password="+items[1]+", email="+items[2]+", found="+found);
			}
		}catch(IOException e){
			Log.e("SignIn", e.getMessage());
		}finally {
			try{
				if(br != null)
					br.close();
			}catch(IOException e){
				Log.e("SignIn", e.getMessage());
			}
		}
		return found;
	}

	/**
	 * Displays an error message to the user
	 * @param msg	Message to be displayed
	 */
	private void displayMessage(String msg){
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, msg, duration);
		toast.show();
	}
}