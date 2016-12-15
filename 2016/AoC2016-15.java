public class Advent {
	public static void main(String[] args){
//		Disc #1 has 17 positions; at time=0, it is at position 15.
//		Disc #2 has 3 positions; at time=0, it is at position 2.
//		Disc #3 has 19 positions; at time=0, it is at position 4.
//		Disc #4 has 13 positions; at time=0, it is at position 2.
//		Disc #5 has 7 positions; at time=0, it is at position 2.
//		Disc #6 has 5 positions; at time=0, it is at position 0.
		int t = 0;
		while(!allSlotsAligned(t)){
			t++;
		}
		System.out.println("Drop the ball at time: " + t);
	}

	private static boolean allSlotsAligned(int t) {
		int firstPosition = (15 + 1 + t) % 17 ;
		int secondPosition = (2 + 2 + t) % 3 ;
		int thirdPosition = (4 + 3 + t) % 19 ;
		int fourthPosition = (2 + 4 + t) % 13 ;
		int fifthPosition = (2 + 5 + t) % 7 ;
		int sixthPosition = (0 + 6 + t) % 5 ;
		int seventhPosition = (0 + 7 + t) % 11 ;
		
		return firstPosition == 0 &&
				secondPosition == 0 &&
				thirdPosition == 0 &&
				fourthPosition == 0 &&
				fifthPosition == 0 &&
				sixthPosition == 0 &&
				seventhPosition == 0;
	}
}