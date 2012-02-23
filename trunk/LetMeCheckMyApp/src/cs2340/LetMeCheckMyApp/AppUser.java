package cs2340.LetMeCheckMyApp;

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
