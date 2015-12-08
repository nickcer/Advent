package advent3;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class RoundHouse {
	public static void main(String[] args) throws IOException {
	    File inFile = new File ("input3.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    ArrayList<House> housesVisited = new ArrayList<House>();

	    int currentX = 0;
	    int currentY = 0;
	    
	    int currentXRobo = 0;
	    int currentYRobo = 0;
	    
	    housesVisited.add(new House(currentX,currentY));
	    
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	
	    	for(int i = 0; i < line.length(); i+=2){
	    		char direction = line.charAt(i);
	    		switch (direction){
	    		case '^':
	    			currentY++;
	    			break;
	    		case 'v':
	    			currentY--;
	    			break;
	    		case '<':
	    			currentX--;
	    			break;
	    		case '>':
	    			currentX++;
	    			break;
	    		
	    		}
	    		House currentHouse = new House(currentX, currentY);
	    		if(isNewHouse(currentHouse, housesVisited)){
	    			housesVisited.add(currentHouse);
	    		}
	    	}
	    	
	    	for(int i = 1; i < line.length(); i+=2){
	    		char direction = line.charAt(i);
	    		switch (direction){
	    		case '^':
	    			currentYRobo++;
	    			break;
	    		case 'v':
	    			currentYRobo--;
	    			break;
	    		case '<':
	    			currentXRobo--;
	    			break;
	    		case '>':
	    			currentXRobo++;
	    			break;
	    		
	    		}
	    		House currentHouseRobo = new House(currentXRobo, currentYRobo);
	    		if(isNewHouse(currentHouseRobo, housesVisited)){
	    			housesVisited.add(currentHouseRobo);
	    		}
	    	}
	    }
	    System.out.println("Santa and Robo visited this many unique houses:" + housesVisited.size());

	    sc.close();
	    System.out.println("END PROG");
	}

	private static boolean isNewHouse(House currentHouse, ArrayList<House> housesVisited) {
		for(int i = 0; i < housesVisited.size(); i++ )
		{
			House previousHouse = housesVisited.get(i);
			if(previousHouse.isTheSameAs(currentHouse)){
				return false;
			}
		}
		return true;
	}

}
