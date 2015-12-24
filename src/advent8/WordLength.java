package advent8;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordLength {
	public static void main (String [] args)throws Exception{
	    File inFile = new File ("input8.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    
	    int characterCodeTotal = 0;
	    int memTotal = 0;
	    int encodedTotal = 0;
	    
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	characterCodeTotal += line.length();
	    	memTotal += memTotalCalculator(line);
	    	encodedTotal += encodedTotalCalculator(line) + 6;//quotes on the end count for 6
	    	

	    }
	    
	    
	    sc.close();
	    System.out.println("Answer is " + (characterCodeTotal - memTotal));
	    System.out.println("Answer is " + (encodedTotal - characterCodeTotal));
	    System.out.println("END PROG");
	}

	private static int encodedTotalCalculator(String line) {
		int counter = 0;
		line = line.substring(1,line.length() - 1);
		//System.out.println(line);
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == '\\' || line.charAt(i) == '"'){
				counter++;
			}
			counter++;
		}
		return counter;
	}

	private static int memTotalCalculator(String line) {
		int counter = 0;
		line = line.substring(1,line.length() - 1);
		//System.out.println(line);
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == '\\'){
				if(line.charAt(i+1) == '\\' || line.charAt(i+1) == '"'){
					i++;
				}
				else if(line.charAt(i+1) == 'x'){
					i+=3;
				}
			}
			counter++;
		}
		return counter;
	}

}
