package advent1;

import java.util.Scanner;
import java.io.*;

public class NotQuiteLisp {
	public static void main(String[] args)throws IOException{
	    File inFile = new File ("input1a.txt");
	    Scanner sc = new Scanner (inFile);
	    
	    String line = "";
	    int floor = 0;
	    while (sc.hasNextLine())
	    {
	      line = sc.nextLine();
	    }
	    
	    sc.close();
	    for(int i = 0; i < line.length(); i++){
	    	if(line.charAt(i) == '('){
	    		floor++;
	    	}
	    	else{
	    		floor--;
	    	}
	    	if(floor == -1){
	    		System.out.println(i+1);
	    		break;
	    	}
	    	
	    }
	    System.out.println(floor);
	    System.out.println("End Prog");
		
	}

}