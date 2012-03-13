package cs2340.LetMeCheckMyApp;

/**
 * 
 * Information holder for a user
 * 
 * 
 * @author Caleb
 *
 */
public class AppUser {
	private String name;
	private String email;
	private String password;
	public AppUser(String name, String email, String password)
	{
		this.name = name;
		this.email = email;
		this.password = password;
	}
    /**
     * Verify that the user info matches an existing user.
     * @param username	Username entered by user
     * @param password	Password entered by user
     * @return	true if the typed name and password matches this user object
     */
	public boolean isMatch(String inputName, String inputPassword)
	{
		if(inputName == name && inputPassword==password)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String getEmail()
	{
		return email;
	}
	public String getName()
	{
		return name;
	}
}
