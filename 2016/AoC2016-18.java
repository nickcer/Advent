public class Advent {
	public static void main(String[] args){
		StringBuilder currentRow = new StringBuilder(".^^^.^.^^^^^..^^^..^..^..^^..^.^.^.^^.^^....^.^...^.^^.^^.^^..^^..^.^..^^^.^^...^...^^....^^.^^^^^^^");
		StringBuilder nextRow = new StringBuilder("");
		int numSafeTiles = 0;
		
		for(int index = 0; index < 400000; index++){

			numSafeTiles += getSafeTiles(currentRow);
			for(int indexInner = 0; indexInner < currentRow.length(); indexInner++){
				char centerTile = currentRow.charAt(indexInner);
				char leftTile = indexInner - 1 >= 0 ? currentRow.charAt(indexInner - 1):'.';
				char rightTile = indexInner + 1 <= currentRow.length() - 1? currentRow.charAt(indexInner + 1):'.';
				
				nextRow.append(nextTile(leftTile,centerTile,rightTile));

			}
			currentRow = new StringBuilder(nextRow);
			nextRow = new StringBuilder("");
		}
		
		System.out.println("The number of safe tiles is: " + numSafeTiles);
	}

	private static String nextTile(char leftTile, char centerTile, char rightTile) {
//		It's a Trap IFF
//	    Its left and center tiles are traps, but its right tile is not.
//	    Its center and right tiles are traps, but its left tile is not.
//	    Only its left tile is a trap.
//	    Only its right tile is a trap.
		if(leftTile == '^' && centerTile == '^' && rightTile == '.')
			return "^";
		if(leftTile == '.' && centerTile == '^' && rightTile == '^')
			return "^";
		if(leftTile == '^' && centerTile == '.' && rightTile == '.')
			return "^";
		if(leftTile == '.' && centerTile == '.' && rightTile == '^')
			return "^";
					
		return ".";
	}

	private static int getSafeTiles(StringBuilder currentRow) {
		int safe = 0;
		for(int index = 0; index < currentRow.length(); index++){
			if(currentRow.charAt(index) == '.'){
				safe++;
			}
		}
		return safe;
	}
}