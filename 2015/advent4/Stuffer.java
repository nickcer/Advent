package advent4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Stuffer {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(getMD5("abcdef609043"));
		
		String input = "yzbqklnj";
	    System.out.println("END PROG");
	    
	    int count = 0;
	    
	    while (!isNumber(input,count)){
	    	count++;
	    }

	}
    private static boolean isNumber(String input, int count) {
		String guess = getMD5(input + count);
		if(guess.substring(0, 6).equals("000000")){
			System.out.println(count);
			return true;
		}
		else{
			return false;
		}
	}
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
