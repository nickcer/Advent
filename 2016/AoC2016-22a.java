import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Advent {
	public static void main(String[] args)throws FileNotFoundException{
	    ArrayList <String> instructions = new ArrayList<String>();
	    readInstructions(instructions);
	    int MAX_X = 31;
	    int MAX_Y = 30;
	    
	    Node[][] nodes = new Node[MAX_Y + 1][MAX_X + 1];
	    for (String instruction : instructions) {
	        String[] linePieces = instruction.split("[T%xy\\- ]+");

	        int x = Integer.parseInt(linePieces[1]);
	        int y = Integer.parseInt(linePieces[2]);
	        int size = Integer.parseInt(linePieces[3]); 
	        int used = Integer.parseInt(linePieces[4]);
	        int available = Integer.parseInt(linePieces[5]);
	        int usedPercentage = Integer.parseInt(linePieces[6]);

	        nodes[y][x] = new Node(x,y,size,used,available,usedPercentage);
	    }
	    int viablePairs = getViablePairs(nodes, MAX_X, MAX_Y);
	    System.out.println("The number of viable pairs is: " + viablePairs);
	    //First, we need to get the empty space beside the goal data
	    //The goal data is at (0,MAX_X)
	    //We need the shortest path from the empty disk to (0, MAX_X -1)
	    Node empty = getEmptyNode(nodes, MAX_X, MAX_Y);
	    //System.out.println(empty.getX() + " "+empty.getY());
	    ArrayList<Node> prev = new ArrayList<Node>();
	    Queue<NodeLocation> q = new LinkedList<NodeLocation>();
	    prev.add(empty);
	    NodeLocation currentLocation = new NodeLocation(empty,0);
	    int numStepsToBesideGoal = getNumStepsToBesideGoal(nodes, empty, prev, q, currentLocation);
	    System.out.println("The number of Steps to get the empty space right is: " + numStepsToBesideGoal);
	    //Now we need 5 moves to get the data 1 square to the left. We need one more move for the final data swap.
	    //The data must move MAX_X -1 spaces. Therefore
	    //we need an additional 5 * (31 - 1) + 1 moves
	    System.out.println("In total, we need this many moves: "+ (numStepsToBesideGoal + 5 * (MAX_X -1) + 1));
	    
	    System.out.println("END PROG");	    
	}

	private static int getNumStepsToBesideGoal(Node[][] nodes, Node current, ArrayList<Node> prev, Queue<NodeLocation> q, NodeLocation currentLocation) {
		if(current.getX() == 30 && current.getY() == 0){
			return currentLocation.getLevel();
		}
		ArrayList<Node> adjacentNodes = getAdjacentNodes(current, nodes);
		
		for(Node node : adjacentNodes){
			if(isSmall(node) && !isInPrev(node, prev)){
				//System.out.println("Adding Node at: " + node.getX() + "," + node.getY());
				prev.add(node);
				q.add(new NodeLocation(node, currentLocation.getLevel() + 1));
			}
		}
		NodeLocation nextLocation = q.poll();
		return getNumStepsToBesideGoal(nodes, nextLocation.getNode(), prev , q, nextLocation);
	}

	private static boolean isSmall(Node node) {
		return node.getSize() < 300;
	}

	private static boolean isInPrev(Node node, ArrayList<Node> prev) {
		for(Node p: prev){
			if(p.getX() == node.getX() && p.getY() == node.getY()){
				return true;
			}
		}
		return false;
	}

	private static ArrayList<Node> getAdjacentNodes(Node current, Node[][] nodes) {
		int x = current.getX();
		int y = current.getY();
		
		Node up = null;
		Node down = null;
		Node left = null;
		Node right = null;
		
		ArrayList<Node> adjacentNodes = new ArrayList<Node>();
		if(x + 1 < 31 + 1){
			right = nodes[y][x+1];
			adjacentNodes.add(right);
		}
		if(x - 1 >= 0){
			left = nodes[y][x - 1];
			adjacentNodes.add(left);
		}
		if(y + 1 < 30 + 1){
			down = nodes[y + 1][x];
			adjacentNodes.add(down);
		}
		if(y - 1 >= 0){
			up = nodes[y - 1][x];
			adjacentNodes.add(up);
		}
		return adjacentNodes;
		
	}

	private static Node getEmptyNode(Node[][] nodes, int MAX_X, int MAX_Y) {
		for(int x = 0; x <= MAX_X; x++){
			for(int y = 0; y <= MAX_Y; y++){
				if(nodes[y][x].getUsed() == 0){
					return nodes[y][x];
				}
			}
		}
		return null;
	}

	private static int getViablePairs(Node[][] nodes, int MAX_X, int MAX_Y) {
		int count = 0; 
		
		for (int x = 0; x <= MAX_X; x++){
			for(int y = 0; y <= MAX_Y; y++){
				Node currentA = nodes[y][x];
				
				for(int i = 0; i <= MAX_X; i++){
					for(int j = 0;j <= MAX_Y; j++){
						Node currentB = nodes[j][i];
						if(isViable(currentA, currentB)){
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	private static boolean isViable(Node currentA, Node currentB) {

//	    Node A is not empty (its Used is not zero).
//	    Nodes A and B are not the same node.
//	    The data on node A (its Used) would fit on node B (its Avail).
		return currentA.getUsed()!=0 && currentA != currentB && currentA.getUsed() <= currentB.getAvailable();

	}

	private static void readInstructions(ArrayList<String> instructions) throws FileNotFoundException {
	    File inFile = new File ("input.txt");
	    Scanner sc = new Scanner (inFile);
	    String line = "";
	    while (sc.hasNextLine()){
	    	line = sc.nextLine();
	    	instructions.add(line);
	    }
	    sc.close();
		
	}
}