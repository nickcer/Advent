import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Advent {

	public static void main(String[] args) throws FileNotFoundException {
		 File inFile = new File ("input.txt");
		    Scanner sc = new Scanner (inFile);
		    String line1 = "";
		    String line2 = "";
		    String line3 = "";
		    
		    int possibleTriangles = 0;
		    		    
		    while (sc.hasNextLine()){
		    	line1 = sc.nextLine();
		    	line2 = sc.nextLine();
		    	line3 = sc.nextLine();
		    	
		    	StringTokenizer st1 = new StringTokenizer(line1, " \t\n\r\f,");
		    	StringTokenizer st2 = new StringTokenizer(line2, " \t\n\r\f,");
		    	StringTokenizer st3 = new StringTokenizer(line3, " \t\n\r\f,");
		    	
		    	ArrayList<Integer> triangleSides1 = new ArrayList<Integer>();
		    	ArrayList<Integer> triangleSides2 = new ArrayList<Integer>();
		    	ArrayList<Integer> triangleSides3 = new ArrayList<Integer>();
		    	
		    	triangleSides1.add(new Integer(st1.nextToken()));
		    	triangleSides2.add(new Integer(st1.nextToken()));
		    	triangleSides3.add(new Integer(st1.nextToken()));
		    	
		    	triangleSides1.add(new Integer(st2.nextToken()));
		    	triangleSides2.add(new Integer(st2.nextToken()));
		    	triangleSides3.add(new Integer(st2.nextToken()));
		    	
		    	triangleSides1.add(new Integer(st3.nextToken()));
		    	triangleSides2.add(new Integer(st3.nextToken()));
		    	triangleSides3.add(new Integer(st3.nextToken()));
		    	
    	
		 	   /* Sort statement*/
		 	   Collections.sort(triangleSides1);
		 	   Collections.sort(triangleSides2);
		 	   Collections.sort(triangleSides3);
		 	   
		 	   if(triangleSides1.get(0) + triangleSides1.get(1) > triangleSides1.get(2)){
		 		   possibleTriangles++;
		 	   }
		 	   
		 	   if(triangleSides2.get(0) + triangleSides2.get(1) > triangleSides2.get(2)){
		 		   possibleTriangles++;
		 	   }
		 	   
		 	   if(triangleSides3.get(0) + triangleSides3.get(1) > triangleSides3.get(2)){
		 		   possibleTriangles++;
		 	   }

		    }
		    
		    
		    sc.close();
		    System.out.println("The number of possible triangles is: " + possibleTriangles);
		    System.out.println("END PROG");
	}

}
