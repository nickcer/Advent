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
	    ArrayList<Bot> bots = new ArrayList<Bot>();
	    int[] outputChips = new int[1000];
	    
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	instructionSet.add(line.split(" "));
	    }
	    sc.close();
	    
	    for(int index = 0; index < instructionSet.size(); index++){
	    	if(isValueInstruction(instructionSet.get(index))){
	    		executeValueInstruction(instructionSet.get(index), bots, outputChips);
	    		instructionSet.remove(instructionSet.get(index));
	    	}
	    }
	    System.out.println("All inputs taken care of.");
	    while(instructionSet.size() > 0){
	    	for(int index = 0; index < instructionSet.size(); index++){
	    		String[] currentInstruction = instructionSet.get(index);
	    		if(hasBotWith2Chips(currentInstruction, bots)){
	    			executeBotInstruction(currentInstruction, bots, outputChips);
	    			instructionSet.remove(currentInstruction);
	    		}
	    	}
	    }
	    System.out.println(outputChips[0] * outputChips[1] * outputChips[2]);

	    System.out.println("END PROG");
	}

	private static boolean hasBotWith2Chips(String[] currentInstruction, ArrayList<Bot> bots) {
		Bot keyBot = null;
		int donorBotNumber = Integer.parseInt(currentInstruction[1]);
		keyBot = getOrCreateBot(donorBotNumber,bots);
		return keyBot.has2Chips();
	}

	private static void executeValueInstruction(String[] currentInstruction, ArrayList<Bot> bots, int[] outputChips) {
		Bot keyBot = null;
		int botNumber = Integer.parseInt(currentInstruction[5]);
		int value = Integer.parseInt(currentInstruction[1]);
		keyBot = getOrCreateBot(botNumber, bots);
		giveChip(keyBot, value);
	}

	private static void executeBotInstruction(String[] currentInstruction, ArrayList<Bot> bots, int[] outputChips){
		Bot keyBot = null;
		int botNumber = Integer.parseInt(currentInstruction[1]);
		keyBot = getOrCreateBot(botNumber, bots);
		donateChips(keyBot, currentInstruction, bots, outputChips);
	}
	
	private static boolean isValueInstruction(String[] instruction) {
		return instruction[0].equals("value");
	}

	private static Bot getOrCreateBot(int botNumber, ArrayList<Bot> bots) {
		for(int x = 0; x < bots.size(); x++){
			if(bots.get(x).getNumber() == botNumber){
				return bots.get(x);
			}
		}
		Bot newBot = new Bot(botNumber);
		bots.add(newBot);
		return newBot;
	}
	
	private static void giveChip(Bot receiverBot, int value) {
		if(receiverBot.highChipIsEmpty()&&receiverBot.lowChipIsEmpty()){//doesn't matter where we put the value, pick low
			receiverBot.setLowChip(value);
		}
		else if(receiverBot.lowChipIsEmpty() && !receiverBot.highChipIsEmpty()){
			if (value < receiverBot.getHighChip()){
				 receiverBot.setLowChip(value);				
			}
			else{//shift hands
				receiverBot.setLowChip(receiverBot.getHighChip());
				receiverBot.setHighChip(value);
			}
			
		}
		else if(!receiverBot.lowChipIsEmpty() && receiverBot.highChipIsEmpty()){
			if(value > receiverBot.getLowChip()){
				receiverBot.setHighChip(value);
			}
			else{//shift hands
				receiverBot.setHighChip(receiverBot.getLowChip());
				receiverBot.setLowChip(value);
			}
		}
		else{
			//hands are full lol
			System.out.println("My hands are full.");
		}
		if(receiverBot.getLowChip() == 17 && receiverBot.getHighChip() == 61){//numbers from puzzle
			System.out.println("My number is: " + receiverBot.getNumber());
		}
		
	}
	
	private static void donateChips(Bot donorBot, String[] instructionPieces, ArrayList<Bot> bots, int[] outputChips) {
		if(instructionPieces[5].equals("bot")){//low to bot
			int lowBotNumber = Integer.parseInt(instructionPieces[6]);
			Bot lowBot = getOrCreateBot(lowBotNumber, bots);
			giveLowChip(donorBot, lowBot);
		}
		else{ //low to output
			int outputNumber = Integer.parseInt(instructionPieces[6]);
			outputLowChip(donorBot,outputChips,outputNumber);
		}
		if(instructionPieces[10].equals("bot")){//high to bot
			int highBotNumber = Integer.parseInt(instructionPieces[11]);
			Bot highBot = getOrCreateBot(highBotNumber, bots);
			giveHighChip(donorBot, highBot);
		}
		else{ //high to output
			int outputNumber = Integer.parseInt(instructionPieces[11]);
			outputHighChip(donorBot,outputChips, outputNumber);
		}
	}
	
	private static void outputHighChip(Bot donorBot, int[] outputChips, int outputNumber) {
		outputChips[outputNumber] = donorBot.getHighChip();
		donorBot.setHighChip(-1);//-1 used to signify emptiness
		
	}

	private static void giveHighChip(Bot donorBot, Bot highBot) {
		giveChip(highBot,donorBot.getHighChip());
		donorBot.setHighChip(-1);//-1 used to signify emptiness
		
	}

	private static void outputLowChip(Bot donorBot, int[] outputChips, int outputNumber) {
		
		outputChips[outputNumber] = donorBot.getLowChip();//add randomly
		//outputChips.add
		donorBot.setLowChip(10000);//arbitrarily big number to mean 'empty' or no chip
		
	}

	private static void giveLowChip(Bot donorBot, Bot lowBot) {
		giveChip(lowBot,donorBot.getLowChip());
		donorBot.setLowChip(10000);//arbitrarily big number to mean 'empty' or no chip
		
	}
}
