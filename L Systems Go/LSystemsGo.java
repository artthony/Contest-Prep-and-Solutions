import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

public class LSystemsGo {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(new File("DATA22.txt"));
    
    for(int i = 0; i < 10; i++){
      int r = input.nextInt();
      int iter = input.nextInt();
      String axiom = input.next();
      int[] alpha = new int[r];
      
//      for(int j = 97, k = 0; j < 122, k < 26; j++, k++){
//        alpha[k] = (char)j;
//      }
      
//      HashMap<String, String> rules = new HashMap<String, String>();
      ArrayList<String> letter = new ArrayList<String>();
      ArrayList<String> change = new ArrayList<String>();
      for(int j = 0; j < r; j++){
        letter.add(input.next());
        change.add(input.next()); 
//        rules.put(input.next(), input.next());
      }
      
      for(int j = 0; j < iter; j++){
        String axiomInstance = "";
        for(int k = 0; k < axiom.length(); k++){
          String ax = Character.toString(axiom.charAt(k));
          for(int l = 0; l < r; l++){
            if(ax.equals(letter.get(l))){
              axiomInstance += change.get(l);
            }
          }
        }
        axiom = axiomInstance; 
      }
      char axStart = axiom.charAt(0);
      char axEnd = axiom.charAt(axiom.length()-1);
      int axLen = axiom.length();
      System.out.println(axStart + "" + axEnd + " " + axLen);
    }
  }
}