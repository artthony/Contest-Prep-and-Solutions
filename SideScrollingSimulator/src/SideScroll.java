/* Anthony Maocheia-Ricci
 * November 1st, 2019
 * ECOO 2019 Round 1 - Question 3:
 * "Side Scrolling Simulator"
 */

import java.io.File;
import java.util.Scanner;

public class SideScroll {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("DATASide2.txt"));
		
		// main for loop, running 10 times (10 datasets)
		main1: for(int i = 0; i < 10; i++) {
			// initializing variables, arrays
			int jump = input.nextInt();
			int w = input.nextInt();
			int h = input.nextInt();
			String[] s = new String[h];
			char[][] level = new char[h][w];
			
			// setting game's height variable, -2 to account for array index, and floor
			int height = h - 2;
			
			// taking in game as string, into string array, then making the string array into 2D char array
			for(int j = 0; j < h; j++) {
				s[j] = input.next();
			} // end for
			for(int j = 0; j < s.length; j++) {
				level[j] = s[j].toCharArray();
			} // end for
			
			// finding luigi's location
			int luigi = 0;
			for(int j = 0; j < (w - 1); j++) {
				if(level[h - 2][j] == 'L') {
					luigi = j;
					break;
				} // end if
			} // end for
			
			// main logic, checking through each impossible part
			for(int j = luigi + 1; j < (w - 1); j++) {
				// counter variable and location of tallest @
				int count = 0;
				int hei = 0;
				
				// finding where walls are
				if(level[height][j] == '@') {
					for(int k = height; k >= 0; k--) { // going from bottom to top
						if(level[k][j] == '.') { // as soon as a . is found, break loop
							hei = k - 1;
							break;
						} // end if
						else if(level[k][j] == '@') { // add to counter with each @
							count++;
						} // end else if
					} // end for
					
					// comparing the @ counter to height & jump, there needs to be room to jump!
					if(count > height) {
						System.out.println(j+1);
						continue main1;
					} // end if
					if(count > jump) {
						System.out.println(j+1);
						continue main1;
					} // end if
					
					//next row over, cannot stand on wall
					for(int k = height; k > hei; k--) {
						
						if(level[k][j + 1] == '@') {
							System.out.println(j+1);
							continue main1;
						} // end if
					} // end for
					
					//current position, checking if blocked in
					for(int k = height; k > hei; k--) {
						
						if(level[k][j - 1] == '@') {
							System.out.println(j+1);
							continue main1;
						} // end if
					} // end for
					
				} // end if

			} // end for
			
			// printing if passed all tests, otherwise it would have continued the main loop
			System.out.println("CLEAR");
		} // end for
		input.close(); // eclipse made me do it
	} // end main
} // end class
