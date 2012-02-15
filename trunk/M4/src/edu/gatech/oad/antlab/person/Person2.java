package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Bob
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
	private String calc(String input) {
	  int i=0;
	  int x;
	  int len = input.length();
	  String s = "";
	  while (i<len){
			x = int(floor(Math.random()*input.length()));
			s[i] = input.charAt(x);
			for (int j=x; j<input.length()-1; j++){
				input.charAt(j) = input.charAt(j+1);
			}
			input.charAt(input.length()) = null;
	  }
	  return s;
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
