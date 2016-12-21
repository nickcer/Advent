import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Advent {
	public static void main(String[] args)throws FileNotFoundException{
		ArrayList <String> perms = permutations("abcdefgh");
	    ArrayList <String> instructions = new ArrayList<String>();
	    File inFile = new File ("input.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	instructions.add(line);
	    }
	    sc.close();
	    
	    for(int i = 0; i < perms.size(); i++){
	    	String stringPermutation = perms.get(i);
	    	ArrayList<String> word = new ArrayList<String>();
	    	for(int j = 0; j < stringPermutation.length(); j++){
	    		word.add(stringPermutation.substring(j,j+1));
	    	}
	    	if(i%100 == 0){
	    		System.out.println("Checking hash number: "+ i);
	    	}
			for(int m = 0; m < instructions.size(); m++){
				line = instructions.get(m);
		    	String[] linePieces = line.split(" ");
		    	if(linePieces[0].equals("move"))
		    	{
		    		int removeIndex = Integer.parseInt(linePieces[2]);
		    		int insertIndex = Integer.parseInt(linePieces[5]);
		    		move(word, removeIndex, insertIndex);
		    	}
		    	else if(linePieces[0].equals("swap"))
		    	{
		    		if(linePieces[1].equals("letter")){
			    		String firstChar = linePieces[2];
			    		String secondChar = linePieces[5];
			    		swapLetter(word, firstChar, secondChar);
		    		}
		    		else if(linePieces[1].equals("position"))
		    		{
		    			int firstIndex = Integer.parseInt(linePieces[2]);
		    			int secondIndex = Integer.parseInt(linePieces[5]);
		    			swapIndex(word, firstIndex, secondIndex);
		    		}	    		
		    	}
		    	else if(linePieces[0].equals("reverse"))
		    	{
	    			int firstIndex = Integer.parseInt(linePieces[2]);
	    			int secondIndex = Integer.parseInt(linePieces[4]);
	    			reverseWord(word, firstIndex, secondIndex);
		    	}
		    	else if(linePieces[0].equals("rotate"))
		    	{
		    		if(linePieces[1].equals("right")){
		    			int numSteps = Integer.parseInt(linePieces[2]);
		    			rotateRight(word,numSteps);
		    		}
		    		else if(linePieces[1].equals("left")){
		    			int numSteps = Integer.parseInt(linePieces[2]);
		    			rotateLeft(word,numSteps);
		    		}
		    		else if(linePieces[1].equals("based")){
		    			String letter = linePieces[6];
		    			rotateLetter(word,letter);
		    		}
		    	}
		    }
	    	String answer = "fbgdceah";
	    	String guess = "";
	    	for(int k = 0; k < word.size(); k++){
	    		guess += word.get(k);
	    	}
	    	if(answer.equals(guess)){
	    		System.out.println("The permutation that resulted in the answer was: " + perms.get(i));
	    	}
	    }

		System.out.println("END PROG");
	}
	static ArrayList<String> permutations(String s) {
        if (s == null) {
            return null;
        }

        ArrayList<String> resultList = new ArrayList<String>();

        if (s.length() < 2) {
            resultList.add(s);

            return resultList;
        }

        int length = s.length();
        char currentChar;

        for (int i = 0; i < length; i++) {
            currentChar = s.charAt(i);

            String subString = s.substring(0, i) + s.substring(i + 1);

            ArrayList<String> subPermutations = permutations(subString);

            for (String item : subPermutations) {
                resultList.add(currentChar + item);
            }
        }

        return resultList;
    } 

	private static void rotateLetter(ArrayList<String> word, String letter) {
//		rotate based on position of letter X means that 
//		the whole string should be rotated to the right 
//		based on the index of letter X (counting from 0) 
//		as determined before this instruction does any rotations.
//		Once the index is determined, rotate the string 
//		to the right one time, plus a number of times equal 
//		to that index, plus one additional time if the index 
//		was at least 4.
		int index = word.indexOf(letter);
		rotateRight(word,1);
		rotateRight(word,index);
		if(index >= 4){
			rotateRight(word,1);
		}
	}

	private static void rotateLeft(ArrayList<String> word, int numSteps) {
		Collections.rotate(word, numSteps * -1);
	}

	private static void rotateRight(ArrayList<String> word, int numSteps) {
		Collections.rotate(word, numSteps);
	}

	private static void reverseWord(ArrayList<String> word, int firstIndex, int secondIndex) {
		ArrayList<String> toReverse = new ArrayList<String>();
		for(int index = firstIndex; index <= secondIndex; index++){
			toReverse.add(word.remove(firstIndex));
		}
		Collections.reverse(toReverse);
		for(int index = firstIndex; index <= secondIndex; index++){
			word.add(index, toReverse.remove(0));
		}
		
	}

	private static void swapIndex(ArrayList<String> word, int firstIndex, int secondIndex) {
		Collections.swap(word, firstIndex, secondIndex);
		
	}

	private static void swapLetter(ArrayList<String> word, String firstChar, String secondChar) {
		int firstIndex = word.indexOf(firstChar);
		int secondIndex = word.indexOf(secondChar);
		Collections.swap(word, firstIndex, secondIndex);
	}

	private static void move(ArrayList<String> word, int removeIndex, int insertIndex) {
//		move position X to position Y means that the letter 
//		which is at index X should be removed from the string, 
//		then inserted such that it ends up at index Y.
		String temp = word.remove(removeIndex);
		word.add(insertIndex, temp);
	}

	private static void printWord(ArrayList<String> word) {
		for(int index = 0; index < word.size(); index++)
			System.out.print(word.get(index));
		System.out.println("");
		
	}
}