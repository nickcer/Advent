import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Advent {
	public static void main(String[] args) throws FileNotFoundException {
		File inFile = new File ("input.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    ArrayList<String[]> instructionSet = new ArrayList<String[]>();
	    
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	instructionSet.add(line.split(" "));
	    }
	    sc.close();
	    int [] registers = new int[150];
	    registers['c'] = 1;
	    
	    for(int index = 0; index < instructionSet.size(); ){
	    	String[] currentInstruction = instructionSet.get(index);
	    	if(currentInstruction.length == 2){
	    		char register = currentInstruction[1].charAt(0);
	    		if(currentInstruction[0].equals("inc"))
	    			registers[register]++;
	    		else
	    			registers[register]--;
	    		//printRegisters(registers);
	    		index++;
	    	}
	    	else if(currentInstruction[0].equals("cpy")){
	    		int donor = 0;
	    		try{
	    			donor = Integer.parseInt(currentInstruction[1]);
	    		}
	    		catch(Exception e){
	    			donor = registers[currentInstruction[1].charAt(0)];
	    		}
	    		finally{
	    			registers[currentInstruction[2].charAt(0)] = donor;
	    			//printRegisters(registers);
	    			index++;
	    		}
	    	}
	    	else if(currentInstruction[0].equals("jnz")){
	    		if(currentInstruction[1].equals("1") || registers[currentInstruction[1].charAt(0)] != 0)
	    			index += Integer.parseInt(currentInstruction[2]);
	    		else{
	    			index++;
	    		}
	    	}
	    	else{
	    		System.out.println("DON'T GO HERE");
	    	}
	    }
	    System.out.println("Register A: "+registers['a']);
	    System.out.println("END PROG");
	}

	private static void printRegisters(int[] registers) {
		System.out.println(registers['a']+" "+registers['b']+" "+registers['c']+" "+registers['d']);
	}
}