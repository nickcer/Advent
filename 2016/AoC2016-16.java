
public class Advent {
	public static void main(String[] args){
		StringBuilder a = new StringBuilder("11100010111110100");
		int MAX_LENGTH = 35651584;
		//int MAX_LENGTH = 272;

		while(a.length() < MAX_LENGTH){
			StringBuilder b = new StringBuilder(a);
			b = reverse(b);
			b = replace01(b);
			a.append("0");
			a.append(b);
			System.out.println(a.length());
		}
		
		
		//System.out.println(a);

		StringBuilder fitsOnDisk = new StringBuilder(a.substring(0, MAX_LENGTH));
		StringBuilder checkSum = getCheckSum(fitsOnDisk);
		while(checkSum.length() % 2 == 0){
			checkSum = getCheckSum(checkSum);
		}
		System.out.println("The checksum is: " + checkSum);
		System.out.println("END PROG");
		
	}
	
    private static StringBuilder getCheckSum(StringBuilder fitsOnDisk) {
		StringBuilder checkSum = new StringBuilder();
    	for(int index = 0; index < fitsOnDisk.length(); index+=2){
    		if(fitsOnDisk.charAt(index) == fitsOnDisk.charAt(index + 1)){
    			checkSum.append("1");
    		}
    		else{
    			checkSum.append("0");
    		}
		}
    	return checkSum;
	}

	private static StringBuilder replace01(StringBuilder b) {
		StringBuilder result = new StringBuilder();
		for(int index = 0; index < b.length(); index++){
			if(b.charAt(index) == '1'){
				result.append("0");
			}
			else{
				result.append("1");
			}
		}
		return result;
	}

	public static StringBuilder reverse(StringBuilder b){
        if(b == null || b.equals("")){
            return b;
        }      
        StringBuilder reverse = new StringBuilder();
        for(int i = b.length() -1; i>=0; i--){
            reverse.append(b.substring(i, i+1));
        }
     
        return reverse;
    }
}