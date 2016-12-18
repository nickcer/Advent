import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Advent {
public static ArrayList<String> validPaths = new ArrayList<String>();
	public static void main(String[] args)throws NoSuchAlgorithmException{
		String input = "pgflpeqp";
		Queue<Location> positions = new LinkedList<Location>();
		Point currentPoint = new Point(1,1);
		Location location = new Location(input, currentPoint);
		positions.add(location);
		
		String fullPath = moveIterative(positions);
		
		System.out.println("The path is: " + fullPath);
//		for(int index = 0; index < validPaths.size(); index ++){
//			System.out.println(validPaths.get(index));
//		}
		System.out.println("END PROG");
	}
	private static String moveIterative(Queue<Location> positions) {
		
		Location currentLocation = null;
		while(positions.size() > 0)
		{
			currentLocation = positions.poll();
			
			if(currentLocation.getCurrentPoint().isVaultRoom()){
				validPaths.add(currentLocation.getPath());
				System.out.println(currentLocation.getPath().length() - "pgflpeqp".length());
			}
			else{
				String hash = getMD5(currentLocation.getPath());
				char up = hash.charAt(0);
				char down = hash.charAt(1);
				char left = hash.charAt(2);
				char right = hash.charAt(3);
				
				boolean upOpen = isOpen(up);
				boolean downOpen = isOpen(down);
				boolean leftOpen = isOpen(left);
				boolean rightOpen = isOpen(right);
				
				Point upPoint = new Point(currentLocation.getCurrentPoint().getX(), currentLocation.getCurrentPoint().getY() - 1);
				Point downPoint = new Point(currentLocation.getCurrentPoint().getX(), currentLocation.getCurrentPoint().getY() + 1);
				Point leftPoint = new Point(currentLocation.getCurrentPoint().getX() - 1, currentLocation.getCurrentPoint().getY());
				Point rightPoint = new Point(currentLocation.getCurrentPoint().getX() + 1, currentLocation.getCurrentPoint().getY());
				
				if(upOpen && isValid(upPoint)){
					positions.add(new Location(currentLocation.getPath() + "U", upPoint));
				}
				if(downOpen && isValid(downPoint)){
					positions.add(new Location(currentLocation.getPath() + "D", downPoint));
				}
				if(leftOpen && isValid(leftPoint)){
					positions.add(new Location(currentLocation.getPath() + "L", leftPoint));
				}
				if(rightOpen && isValid(rightPoint)){
					positions.add(new Location(currentLocation.getPath() + "R", rightPoint));
				}
			}
		}
		return currentLocation.getPath();
	}
	private static String move(Queue<Location> positions) {
		//Used for part 1 - a recursive solution
		Location currentLocation = positions.poll();
				
		if(currentLocation.getCurrentPoint().isVaultRoom()){
			validPaths.add(currentLocation.getPath());
			return currentLocation.getPath();
		}
		String hash = getMD5(currentLocation.getPath());
		char up = hash.charAt(0);
		char down = hash.charAt(1);
		char left = hash.charAt(2);
		char right = hash.charAt(3);
		
		boolean upOpen = isOpen(up);
		boolean downOpen = isOpen(down);
		boolean leftOpen = isOpen(left);
		boolean rightOpen = isOpen(right);
		
		Point upPoint = new Point(currentLocation.getCurrentPoint().getX(), currentLocation.getCurrentPoint().getY() - 1);
		Point downPoint = new Point(currentLocation.getCurrentPoint().getX(), currentLocation.getCurrentPoint().getY() + 1);
		Point leftPoint = new Point(currentLocation.getCurrentPoint().getX() - 1, currentLocation.getCurrentPoint().getY());
		Point rightPoint = new Point(currentLocation.getCurrentPoint().getX() + 1, currentLocation.getCurrentPoint().getY());
		
		if(upOpen && isValid(upPoint)){
			positions.add(new Location(currentLocation.getPath() + "U", upPoint));
		}
		if(downOpen && isValid(downPoint)){
			positions.add(new Location(currentLocation.getPath() + "D", downPoint));
		}
		if(leftOpen && isValid(leftPoint)){
			positions.add(new Location(currentLocation.getPath() + "L", leftPoint));
		}
		if(rightOpen && isValid(rightPoint)){
			positions.add(new Location(currentLocation.getPath() + "R", rightPoint));
		}
			
		return move(positions);
	}
	private static boolean isValid(Point point) {
		return point.getX() >=1 && point.getX() <= 4 && point.getY() >=1 && point.getY() <= 4;
	}
	private static boolean isOpen(char ch) {
		return ch == 'b' || ch == 'c' ||ch == 'd' ||ch == 'e' ||ch == 'f';
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