package advent2;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Wrap {

	public static void main(String[] args) throws IOException {
	    File inFile = new File ("input2.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    int totalAreaOfPaper = 0;
	    int totalRibbon = 0;
	    ArrayList<Integer> current = new ArrayList<Integer>();
	    
	    while (sc.hasNextLine())
	    {
	      line = sc.nextLine();
	      StringTokenizer st = new StringTokenizer(line, "x");
	      
	      while (st.hasMoreTokens()){
	    	  current.add(Integer.parseInt(st.nextToken()));
	      }
	      Collections.sort(current);
	      totalAreaOfPaper += areaOfGift(current) + slack(current);
	      totalRibbon += perimeterRibbon(current) + bowRibbon(current);
	      showGiftDimensions(current);
	      
	          
	      current.clear();
	      
	    }
	    System.out.println("END PROG");
	    System.out.println("Paper needed is: "+totalAreaOfPaper);
	    System.out.println("Ribbon needed is: "+totalRibbon);
	    sc.close();

	}

	private static int bowRibbon(ArrayList<Integer> current) {
		return current.get(0)*current.get(1)*current.get(2);
	}

	private static int perimeterRibbon(ArrayList<Integer> current) {
		return 2 * (current.get(0) + current.get(1));
	}

	private static int areaOfGift(ArrayList<Integer> current) {
		int answer = (2 * current.get(0) * current.get(1)) +
				 	 (2 * current.get(0) * current.get(2)) +
				 	 (2 * current.get(1) * current.get(2));
				 
		return answer;
	}

	private static int slack(ArrayList<Integer> current) {
		int answer = current.get(0) * current.get(1);
		return answer;
	}

	private static void showGiftDimensions(ArrayList<Integer> current) {
		for(int i = 0; i < current.size(); i++)
			System.out.println(current.get(i));
		
	}

}
