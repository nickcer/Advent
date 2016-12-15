import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Advent {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String input = "yjdafjpo";
		String[] cache = new String[30000];
		for(int x = 0; x < cache.length; x++){
			cache[x] = stretcher(input+x);
		}
		
		ArrayList <String> keys = new ArrayList<String>();
		int count = 0;
		while(keys.size() < 64){
			String trip = triple(cache[count]);
			if(trip !=null){
				if(hasQuint(cache[count],cache,count + 1, trip)){
					keys.add(cache[count]);
				}
			}
			count++;
		}
		System.out.println("Final count is: "+(count-1));
	    System.out.println("Keys has a size of: "+keys.size());
	    System.out.println("END PROG");
	}
	private static boolean hasQuint(String string, String[] cache, int i, String trip) {
		String searchFor = trip.substring(0,1) + trip + trip.substring(0,1);
		int max = i + 1000;
		for(;i < max; i++){
			if(cache[i].contains(searchFor)){
				return true;
			}
		}
		return false;
	}
	private static String triple(String hash) {
		for(int x = 0; x < hash.length() - 2; x++){
			if(hash.charAt(x) == hash.charAt(x+1) && hash.charAt(x) == hash.charAt(x+2)){
				return hash.substring(x,x+3);
			}
		}
		return null;
	}
	private static String stretcher(String hash) {
		for(int x = 0; x < 2017; x++){
			 hash = getMD5(hash);
		}
		return hash;
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