import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Advent {
	public static void main(String[] args) {
		Point current = new Point(1,1,0);
		Point destination = new Point(31,39,0);
		ArrayList<Point> prev = new ArrayList<Point>();
		Queue<Point> q = new LinkedList<Point>();
		
		int level = move(current,prev,destination,q);
		int count = 0;
		for(int index = 0; index < prev.size(); index ++){
			if(prev.get(index).getLevel() <=50){
				count++;
			}
		}
		System.out.println(count);
		System.out.println(level);
	    System.out.println("END PROG");
	}

	private static int move(Point current,ArrayList<Point> prev, Point destination, Queue<Point> q) {
		if(current.equals(destination)){
			return current.getLevel();
		}
		Point up = new Point(current.getX(),current.getY() + 1,current.getLevel() + 1);
		Point down = new Point(current.getX(),current.getY() - 1, current.getLevel() + 1);
		Point left = new Point(current.getX() - 1, current.getY(),current.getLevel() + 1);
		Point right = new Point(current.getX() + 1, current.getY(),current.getLevel() + 1);

		if(up.isSuitable(prev))
			q.add(up);
		if(down.isSuitable(prev))
			q.add(down);
		if(left.isSuitable(prev))
			q.add(left);
		if(right.isSuitable(prev))
			q.add(right);
		if(!current.inPrevious(prev)){
			prev.add(current);
		}
		return move(q.poll(), prev, destination, q);		
	}
}