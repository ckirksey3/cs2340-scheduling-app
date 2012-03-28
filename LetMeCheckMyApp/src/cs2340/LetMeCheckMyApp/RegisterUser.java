package cs2340.LetMeCheckMyApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
 * the new user registration screen
 * 
 * 
 * @author Jeff
 *
 */
public class RegisterUser extends Activity {
	private final String USER_FILE = "users.dat";

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		final EditText userNameET = (EditText) findViewById(R.id.newUserNameText);
		final EditText passwordET = (EditText) findViewById(R.id.newUserPasswordText);
		final EditText emailET = (EditText) findViewById(R.id.newUserEmailText);

		Button next = (Button) findViewById(R.id.button1);
		next.setOnClickListener(new View.OnClickListener() {
			/** When the registration button is clicked, this code is executed */
			public void onClick(View view) {
				String username = userNameET.getText().toString();
				String password = passwordET.getText().toString();
				String email = emailET.getText().toString();
				if(username.equals("") || password.equals("") || email.equals("")){ //check that fields are filled in
					displayMessage("All fields must be filled to continue");
				}else if(!userExists(username, email)){ //check if user already exists
					Log.d("RegisterUser", "Storing "+username+" in "+USER_FILE);
					//store user in database
					try{
						FileOutputStream fos = openFileOutput(USER_FILE, Context.MODE_APPEND);
						fos.write((username+"\t"+password+"\t"+email+"\n").getBytes());
						fos.close();
					}catch(IOException e){
						Log.e("RegisterUser", e.getMessage());
					}
					//start task lists
					displayMessage("Registration Succesful!");
					Intent myIntent = new Intent(view.getContext(), ManageTaskList.class);
					startActivity(myIntent);
				}else{
					displayMessage("Username or email is already registered.");
				}
			}
		});
		Button cancel = (Button) findViewById(R.id.button2);
		cancel.setOnClickListener(new View.OnClickListener() {
			/** When the cancel button is clicked, this code is executed */
			public void onClick(View view) {
				finish();
			}
		});
	}

	/**
	 * Checks if a user already exists in the database
	 * @param username	Username input from user
	 * @param email
	 * @return	true if the user exists, false otherwise
	 */
	private boolean userExists(String username, String email){
		Log.d("RegisterUser", "Checking if username:\""+username+"\" or email:\""+email+"\" already exists.");
		boolean found = false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getFilesDir()+"/"+USER_FILE))));
			String line;
			while((line = br.readLine()) != null && !found){
				String[] items = line.split("\t");
				if(items[0].equals(username) || items[2].equals(email)){
					found = true;
				}
				//Log.d("tbd", "Line="+line+", username="+items[0]+", password="+items[1]+", email="+items[2]+", found="+found);
			}
		}catch(IOException e){
			Log.e("RegisterUser", e.getMessage());
		}finally {
			try{
				if(br != null)
					br.close();
			}catch(IOException e){
				Log.e("RegisterUser", e.getMessage());
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
