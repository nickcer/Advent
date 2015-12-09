package advent5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Interns {
	public static void main(String[] args) throws IOException {
	    File inFile = new File ("input5.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    
	    int numNice = 0;
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	
	    	//if(isNice(line)){
	    	if(isNice2(line)){
	    		numNice++;
	    	}
	    }
	    
	    sc.close();
	    System.out.println("There are this many nice:"+numNice);
	    System.out.println("END PROG");
	}

	private static boolean isNice2(String line) {
		return has2Pair(line) &&
				hasRepeats(line);
				
				
	}

	private static boolean hasRepeats(String line) {
		for(int i = 0; i<line.length() - 2; i++){
			if(line.charAt(i) == line.charAt(i+2)){
				return true;
			}
			
		}
		return false;
	}

	private static boolean has2Pair(String line) {
		for(int i = 0; i<line.length() - 1; i++){
				String pair = Character.toString(line.charAt(i))
						+ Character.toString(line.charAt(i+1));
				
				if(line.indexOf(pair, i + 2) > -1){
					return true;
				}
			}
			
			return false;
	}

	private static boolean isNice(String line) {
		return hasAtLeast3Vowels(line)
				&& hasDoubleLetter(line)
				&& !hasBannedString(line);
	}

	private static boolean hasDoubleLetter(String line) {
		for(int i = 0; i<line.length() - 1; i++){
			if(line.charAt(i) == line.charAt(i+1)){
				return true;
			}
			
		}
		return false;
	}

	private static boolean hasBannedString(String line) {
		return line.indexOf("ab") > -1 ||
				line.indexOf("cd") > -1 ||
				line.indexOf("pq") > -1 ||
				line.indexOf("xy") > -1;
	}

	private static boolean hasAtLeast3Vowels(String line) {
		
		int numVowels = 0;
		for(int i = 0; i<line.length(); i++){
			if(line.charAt(i) == 'a' ||
					line.charAt(i) == 'e' ||
					line.charAt(i) == 'i' ||
					line.charAt(i) == 'o' ||
					line.charAt(i) == 'u'){
				numVowels++;
			}
		}
		return numVowels >= 3;

	}

}
