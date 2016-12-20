import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Advent {
	public static void main(String[] args)throws FileNotFoundException{
		 File inFile = new File ("input.txt");
		 Map<Long, Long> ips = new HashMap<Long, Long>();
		    Scanner sc = new Scanner (inFile);
		    String line = "";

		    while (sc.hasNextLine()){
		    	line = sc.nextLine();
		    	String[] linePieces = line.split("-");
		    	Long begin = Long.parseLong(linePieces[0]);
		    	Long end = Long.parseLong(linePieces[1]);
		    	
		    	ips.put(begin, end);
		    }
		    sc.close();
		    Map<Long, Long> sortedIps = new TreeMap<Long, Long>(ips);
		    printMap(sortedIps);
		    System.out.println("END PROG");
	}
	public static void printMap(Map<Long,Long> map) {
	    Set<Entry<Long, Long>> s = map.entrySet();
	    Iterator<Entry<Long, Long>> it = s.iterator();
	    long prevValue = 0;
	    long numIps = 0;
	    while ( it.hasNext() ) {
	       Map.Entry entry = (Map.Entry) it.next();
	       Long key = (Long)entry.getKey();
	       Long value = (Long) entry.getValue();
	       
	       if(prevValue + 1 < key ){
	    	   System.out.println("Beginning of Allowed IP range is:" + (prevValue + 1));
	    	   System.out.println(key + " => " + value);
	    	   numIps += key - prevValue - 1;
	       }
	       prevValue = value > prevValue ? value : prevValue;
	       
	    }//while
	    System.out.println("========================");
	    System.out.println("Number of allowed IPs: " + numIps);
	}//printMap
}