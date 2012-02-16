package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Jeff
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
    
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	 
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */

	 private String calc(String input){
		 int x=0;
		 int len = input.length();
		 char[] ans = new char[input.length()];
		 char[] in = new char[input.length()];
		 for (int j=0; j<len; j++){
		 	  in[j]=input.charAt(j);
		 }
		 for (int i = 0; i<len; i++){
			 x = (int) (Math.floor(Math.random()*(input.length()-i)));
			 ans[i] = in[x];
			 for (int j=x; j<input.length()-i-1; j++){
				 in[j] = in[j+1];
			 }
		 }

		 String result = new String(ans);
		 return result;
	 }
	 
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         objec
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
