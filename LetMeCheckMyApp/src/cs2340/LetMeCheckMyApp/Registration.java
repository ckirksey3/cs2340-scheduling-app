package cs2340.LetMeCheckMyApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Context;
import android.util.Log;

public class Registration {
	private final String USER_FILE = "users.dat";

	/**
	 * Adds a user
	 * @return true if the user was added successfully, false if a problem occurred
	 */
	/**
	private boolean createUser(String username, String email, String password)
	{
		Log.d("RegisterUser", "Storing "+username+" in "+USER_FILE);
		//store user in database
		try{
			FileOutputStream fos = openFileOutput(USER_FILE, Context.MODE_APPEND);
			fos.write((username+"\t"+password+"\t"+email+"\n").getBytes());
			fos.close();
			return true;
		}catch(IOException e){
			Log.e("RegisterUser", e.getMessage());
			return false;
		}
		
	}

	
	 * Checks if a user already exists in the database
	 * @param username	Username input from user
	 * @param email
	 * @return	true if the user exists, false otherwise
	 *
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
	*/
}

