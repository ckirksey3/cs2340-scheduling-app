package cs2340.LetMeCheckMyApp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class RegisterUserTest extends ActivityInstrumentationTestCase2<RegisterUser> {

	public RegisterUserTest() {
		super(RegisterUser.class);
	}

	public void testCreateUser(){
		RegisterUser activity = this.getActivity();
		boolean success = activity.createUser("newuser", "email", "password");
		
		assertEquals("newuser",activity.username);
		assertEquals("email",activity.email);
		assertEquals("password",activity.password);
		assertEquals(true, success);
	}
	
	public void testUserExists(){
		RegisterUser activity = this.getActivity();
		boolean exists = activity.userExists("fakeuser", "fakeemail");
		assertEquals(false, exists);
	}
}
