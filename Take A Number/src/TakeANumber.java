/* Anthony Maocheia-Ricci
 * ECOO 2013 Round 1 Question 1 (done for practice)
 * Sent by Mr. Conlon for coding club
 */

// we only need Scanner, File and the Exception
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TakeANumber {
	public static void main(String[] args) throws FileNotFoundException {
		// initializing scanner and variables
		Scanner input = new Scanner(new File("DATA12.txt"));
		int n = input.nextInt();
		int taken = 0, served = 0, total = n;
		
		// looping while the file has inputs left
		attendance :while(input.hasNext()) {
			// switch/case instead of else if
			switch(input.next()) {
			case "TAKE" : // when TAKE appears, add to counter
				taken++;
				break;
			case "SERVE" : // when SERVE appears, add to counter
				served++;
				break;
			case "CLOSE" : // main logic, CLOSE
				total += taken; // add people seen to total
				if(total >= 999) {
					while(total >= 999) { // number cannot be >= 999, lower amount until number is under
						total -= 999;
					}
				}
				int rem = taken - served; // find amount of people not served
				System.out.println(taken + " " + rem + " " + total); // print statement
				taken = 0; // reset variables back to 0 for next day
				served = 0;
				break;
			case "EOF" :
				break attendance; // when EOF appears, end loop
			} // close switch/case
		} // close while "attendance"
	} // close main
} // close class
