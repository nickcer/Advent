package advent7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Circuit {
	
	static Map<String, Integer> cache = new HashMap<String, Integer>();
	public static void main (String [] args)throws IOException{
	    File inFile = new File ("input7.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    ArrayList<ArrayList<String>> instructions = new ArrayList<ArrayList<String>>();
	    
	    
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	StringTokenizer st = new StringTokenizer(line);
	    	ArrayList<String> currentInstruction = new ArrayList<String>();
	    	while(st.hasMoreTokens()){
	    		currentInstruction.add(st.nextToken().toString());
	    	}
	    	instructions.add(currentInstruction);

	    }//Instruction list full
	    
	    sc.close();
	    System.out.println("There are this many instructions:" + instructions.size());
	    System.out.println("The wire's value is:" + wireValue("a", instructions)); 
	    System.out.println("END PROG");
	}

	private static int wireValue(String wire, ArrayList<ArrayList<String>> instructions) {
		ArrayList<String> currentInstruction = findInstruction(wire, instructions);
		System.out.println("The current instruction is:" + instructions.indexOf(currentInstruction) + ":"+currentInstruction);
		int value = 0;
		
		if(cache.containsKey(wire)){
			System.out.println("Cache Hit!");
			return cache.get(wire);
		}
			
		
		switch(currentInstruction.size()){
			case 3:
				if(isNumeric(currentInstruction.get(0)))
					value = Integer.parseInt(currentInstruction.get(0)); //The base case, i.e. a raw value
				else
					value = wireValue(currentInstruction.get(0), instructions); //The lambda transition case
				break;	
			case 4:
				value = ~wireValue(currentInstruction.get(1), instructions); //The NOT case
				break;
			case 5:
				String operation = currentInstruction.get(1); // Can only be one of LSHIFT, RSHIFT, AND, OR
				if(operation.equals("LSHIFT"))
					value = wireValue(currentInstruction.get(0), instructions)
							<<Integer.parseInt(currentInstruction.get(2));
				else if (operation.equals("RSHIFT"))
					value = wireValue(currentInstruction.get(0), instructions)
							>>Integer.parseInt(currentInstruction.get(2));
				else if (operation.equals("AND"))
					if(isNumeric(currentInstruction.get(0)))
						value = Integer.parseInt(currentInstruction.get(0))
								&wireValue(currentInstruction.get(2), instructions);
					else			
						value = wireValue(currentInstruction.get(0), instructions)
							&wireValue(currentInstruction.get(2), instructions);
				else if (operation.equals("OR"))
					if(isNumeric(currentInstruction.get(0)))
						value = Integer.parseInt(currentInstruction.get(0))
								|wireValue(currentInstruction.get(2), instructions);
					else
						value = wireValue(currentInstruction.get(0), instructions)
								|wireValue(currentInstruction.get(2), instructions);
				break;
			}
		cache.put(wire, value);
		return value;
	}

	private static ArrayList<String> findInstruction(String wire, ArrayList<ArrayList<String>> instructions) {
		ArrayList<String> currentInstruction = null;
		for(int i = 0; i < instructions.size(); i++){
			currentInstruction = instructions.get(i);
			int instructionSize = currentInstruction.size();
			if(currentInstruction.get(instructionSize - 1).equals(wire)){
				break;
			}
		}
		return currentInstruction;
	}

	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
