import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Advent {

	public static void main(String[] args) throws FileNotFoundException {
		 File inFile = new File ("input.txt");
		    Scanner sc = new Scanner (inFile);
		    String line1 = "";

		    ArrayList<Room> rooms = new ArrayList<Room>();
		    while (sc.hasNextLine()){
		    	line1 = sc.nextLine();
		    	
		    	String[] linePieces = line1.split("[-\\[\\]]");
		    	ArrayList<String> roomCodes = new ArrayList<String>();
		        for (int x=0; x<linePieces.length - 2; x++){
		            roomCodes.add(new String(linePieces[x]));
		        }
		        String sectorID = new String(linePieces[linePieces.length - 2]);
		        String checkSum = new String(linePieces[linePieces.length - 1]);
		        
		        rooms.add(new Room(roomCodes, sectorID, checkSum));
		    }
		    
		    int sumOfSectors = 0;
		    
		    for(int i = 0; i < rooms.size(); i++){
		    	if(rooms.get(i).isReal()){
		    		
		    		sumOfSectors += Integer.parseInt(rooms.get(i).getSectorID());
		    	}
		    }
		    System.out.println("The sum is: " + sumOfSectors);
		    sc.close();

		    System.out.println("END PROG");
	}
	

}
