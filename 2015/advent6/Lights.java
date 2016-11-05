package advent6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lights {

	public static void main(String[] args)throws IOException {
	    File inFile = new File ("input6.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    ArrayList<String> current = new ArrayList<String>();
	    int[][] lights = new int[1000][1000];
	    
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	StringTokenizer st = new StringTokenizer(line, " \t\n\r\f,");
	    	
		    while (st.hasMoreTokens()){
		    	  current.add(st.nextToken());
		      }
		    printInstruction(current);
		    if(current.get(0).equals("toggle")){
		    	increase2(lights, Integer.parseInt(current.get(1)),
		    			Integer.parseInt(current.get(2)),
		    			Integer.parseInt(current.get(4)),
		    			Integer.parseInt(current.get(5)));
		    }
		    else if (current.get(1).equals("on")){
		    	increase1(lights, Integer.parseInt(current.get(2)),
		    			Integer.parseInt(current.get(3)),
		    			Integer.parseInt(current.get(5)),
		    			Integer.parseInt(current.get(6)));
		    }
		    else{
		    	decrease1(lights, Integer.parseInt(current.get(2)),
		    			Integer.parseInt(current.get(3)),
		    			Integer.parseInt(current.get(5)),
		    			Integer.parseInt(current.get(6)));
		    }
		    
		    current.clear();
	    }
	    
	    
	    sc.close();
	    System.out.println("Number of lights on is:"+getTotalBrightness(lights));
	    System.out.println("END PROG");

	}

	private static int getTotalBrightness(int[][] lights) {
		int count = 0;
		for(int i = 0; i <= 999; i++){
			for(int j = 0; j <= 999; j++){
					count += lights[i][j];
				}
			}
		return count;
	}

	private static void increase2(int[][] lights, int row1, int column1, int row2, int column2) {
		for(int i = row1; i <= row2; i++){
			for(int j = column1; j <= column2; j++){
				lights[i][j] += 2;
			}
		}
	}

	private static void decrease1(int[][] lights, int row1, int column1, int row2, int column2) {
		for(int i = row1; i <= row2; i++){
			for(int j = column1; j <= column2; j++){
				if(lights[i][j] != 0)
					lights[i][j] -= 1;
			}
		}
		
	}

	private static void increase1(int[][] lights, int row1, int column1, int row2, int column2) {
		for(int i = row1; i <= row2; i++){
			for(int j = column1; j <= column2; j++){
				lights[i][j] += 1;
			}
		}
		
	}

	private static void printInstruction(ArrayList<String> current) {
		for(int i = 0; i < current.size(); i++){
			System.out.println(current.get(i));
		}
		
	}

	private static int getNumOn(int[][] lights) {
		int count = 0;
		for(int i = 0; i <= 999; i++){
			for(int j = 0; j <= 999; j++){
				if(lights[i][j] == 1){
					count++;
				}
			}
		}
		return count;
	}

	private static void toggle(int[][] lights, int row1, int column1, int row2, int column2) {
		for(int i = row1; i <= row2; i++){
			for(int j = column1; j <= column2; j++){
				if(lights[i][j] == 0){
					lights[i][j] = 1;
				}
				else{
					lights[i][j] = 0;
				}
			}
		}
		
	}
	
	
	private static void turnOn(int[][] lights, int row1, int column1, int row2, int column2) {
		for(int i = row1; i <= row2; i++){
			for(int j = column1; j <= column2; j++){
				lights[i][j] = 1;
			}
		}
		
	}
	
	private static void turnOff(int[][] lights, int row1, int column1, int row2, int column2) {
		for(int i = row1; i <= row2; i++){
			for(int j = column1; j <= column2; j++){
				lights[i][j] = 0;
			}
		}
		
	}

}
