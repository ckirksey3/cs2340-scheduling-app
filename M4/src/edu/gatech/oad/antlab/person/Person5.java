package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 5
 *  returns their name and a
 *  modified string 
 *  
 *  @author Bob
 *  @version 1.1
 */
public class Person5 {
  /** Holds the persons real name */
  private String name;
  	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
  public Person5(String pname) {
    name = pname;
  }
  	/**
	 * This method should take the string
	 * input and return its characters rotated
	 * 4 positions.
	 * given "gtg123b" it should return
	 * "23bgtg1".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  //Person 5 put your implementation here
    	char[] outputChars = new char[input.length()];
    	int newIndex = 0;
    	for(int i = 0; i<input.length(); i++)
    	{
    		newIndex = i - 4;
    		if(newIndex < 0)
    		{
    			newIndex = input.length()- 4 + i;
    		}
    		outputChars[newIndex]= input.charAt(i);
    	}
    	String result = new String(outputChars);
      return result;
	}
	
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}

}
