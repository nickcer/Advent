import java.util.ArrayList;

public class Point {
	int x = 0;
	int y = 0;
	int level = 0;
	Point(int x, int y, int level){
		this.x = x;
		this.y = y;
		this.level = level;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isWall() {
		/**
	    Find x*x + 3*x + 2*x*y + y + y*y.
	    Add the office designer's favorite number (your puzzle input).
	    Find the binary representation of that sum; count the number of bits that are 1.
	        If the number of bits that are 1 is even, it's an open space.
	        If the number of bits that are 1 is odd, it's a wall.
	        **/
		
		int puzzleInput = 1364;
		int result = x*x + 3*x + 2*x*y + y + y*y + puzzleInput;
		int count = Integer.bitCount(result);
		return count % 2 == 1;
	}
	public boolean equals(Point point){
		return this.x == point.getX() && this.y == point.getY();
	}
	public boolean isInvalid() {
		return x < 0 || y < 0;
	}
	public boolean isSuitable(ArrayList<Point> prev) {
		return !this.isInvalid() && !this.isWall() && !this.inPrevious(prev);
	}
	public boolean inPrevious(ArrayList<Point> prev) {
		for(int index = 0; index < prev.size(); index ++){
			if(this.equals(prev.get(index))){
				return true;
			}
		}
		return false;
	}	
}
