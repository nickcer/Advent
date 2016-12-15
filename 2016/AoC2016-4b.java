import java.util.ArrayList;


public class Room {

	private ArrayList<String> roomCodes = null;
	private String sectorID = "";
	private String checkSum = "";

	public Room(ArrayList<String> roomCodes, String sectorID, String checkSum) {
		this.setRoomCodes(roomCodes);
		this.setSectorID(sectorID);
		this.setCheckSum(checkSum);
				
	}

	public ArrayList<String> getRoomCodes() {
		return roomCodes;
	}

	public void setRoomCodes(ArrayList<String> roomCodes) {
		this.roomCodes = roomCodes;
	}

	public String getSectorID() {
		return sectorID;
	}

	public void setSectorID(String sectorID) {
		this.sectorID = sectorID;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public boolean isReal() {

		if(frequencyStringOfRoomCodes().equals(checkSum)){
			return true;
		}
		return false;
	}

	private String frequencyStringOfRoomCodes() {
		String codes = "";
		int[] frequencies = new int[256];
		char[] top5 = new char[5];
		
		for(int i = 0; i < roomCodes.size(); i++){
			codes += roomCodes.get(i);
		}
		
		String decoded = applyCaesar(codes, Integer.parseInt(sectorID));
		//System.out.println("The decoded string is: " + decoded);
		if(decoded.equals("northpoleobjectstorage"))
			System.out.println(decoded + " has a sectorID of: "+ sectorID);
		

		for(int i = 0; i < codes.length(); i++){

			frequencies[codes.charAt(i)]++;
		}
		
		for( int i = 0; i < top5.length; i++){
			top5[i] = getHighestIndex(frequencies);

		}
		
		String frequencyString = "";
		for( int i = 0; i < top5.length; i++){
			frequencyString += top5[i];
		}

		return frequencyString;
		
		
		
		
	}
	public String applyCaesar(String text, int shift)
	{
	    char[] chars = text.toCharArray();
	    for (int i=0; i < text.length(); i++)
	    {
  	    	int delta = shift % 26;

	    	if((int)chars[i] + delta <= 122)
	    		chars[i] += delta;
	    	else
	    		chars[i] = (char)(97 + ((int)chars[i] + delta) - 123);
	    }
	    return new String(chars);
	}
	private char getHighestIndex(int[] frequencies) {
		int max = -1;
		int highestIndex = -1;
		for(int i = 0; i < frequencies.length; i++){
			if(frequencies[i] > max){
				max = frequencies[i];
				highestIndex = i;
			}
		}
		frequencies[highestIndex] = -99;
		return (char)highestIndex;
	}
}
