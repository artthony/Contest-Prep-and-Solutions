import java.io.File;
import java.util.Scanner;

public class SplitWordCipher {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("DATA40.txt")); // initializing file
		
		// looping 5 times (one for each line)
		for(int i = 0; i < 5; i++) {
			String word = input.nextLine(); // taking whole line in as string
			char[] cArr = word.toCharArray(); // split it into a character array for manipulation
			String solved = ""; 
			word.concat(" "); // adding on extra blank character for substring usage
			
			for(int j = 0; j < cArr.length; j++) { // looping for length of character array (not including extra chatacter
				char shifter = cArr[j];
				int shift = (int)(shifter) - 64; // finding shift character (how far needed to shift)
				String sub = word.substring(j+1, j+1+shift); // taking substring from next letter to end of word
				solved += solve(sub, shift) + " "; // method call to add to string
				j += shift;
			} // close for loop
			System.out.println(solved); // print out deciphered string
		} // close for loop
		
	} // close main
	
	// deciphering method, takes in substring and shift
	public static String solve(String s, int n) {
		// initializing variables
		String word = s;
		String solvedWord = "";
		char[] wArr = word.toCharArray(); // another character array for maniupation
		int shift = n;
		
		for(char c : wArr) { // running for every character, enhanced for loop for ease of use (any length)
			char letter = c;
			int nLetter = (int)(c) - shift; // finding new deciphered letter
			if(nLetter < 64) { // looping around the alphabet if letter ends up being less than A
				int diff = 64 - nLetter;
				int nDiff = 90 - diff;
				nLetter = (char)nDiff;
				solvedWord += (char)nLetter; // char is now a capital letter, add to deciphered word
			}
			else { // letter is a proper letter, add to deciphered word
				solvedWord += (char)nLetter;
			}
		} // close for loop
		return solvedWord; //  return the deciphered word
	} // close solve method
} // close class
