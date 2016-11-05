import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Generic {
	public static void main (String [] args)throws Exception{
	    File inFile = new File ("input2.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	StringTokenizer st = new StringTokenizer(line, " \t\n\r\f,");

	    }
	    
	    
	    sc.close();

	    System.out.println("END PROG");
	}
}
