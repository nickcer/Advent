import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String input = "abbhdwsy";



        int count = 0;
        String password = "";
        String[] passwordArray = {"~","~","~","~","~","~","~","~"};

        while (password.length() < 8) {
            String hash = getMD5(input + count);
            if(hash.substring(0, 5).equals("00000")) {
                String position = hash.substring(5, 6);
                if(positionIsValid(position)){
                    int pos = Integer.parseInt(position);
                    if(passwordArray[pos].equals("~")){
                        passwordArray[pos] = hash.substring(6,7);
                        password += hash.substring(6, 7);
                    }
                }

            }
            count++;
        }

        for(int x = 0; x < passwordArray.length; x++)
            System.out.print(passwordArray[x]);
        System.out.println("END PROG");
    }

    private static boolean positionIsValid(String position) {
        if(position.equals("0") || position.equals("1") || position.equals("2") || position.equals("3") ||
                position.equals("4") || position.equals("5") || position.equals("6") || position.equals("7")){
            return true;
        }
        return false;
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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}

