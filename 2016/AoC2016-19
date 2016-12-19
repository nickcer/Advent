import java.util.ArrayList;

public class Advent {
	public static void main(String[] args){
		//Part A
		// 2^6 - 1 => elf 2^6 - 1
		// 2^6 - 2 => elf 2^6 - 3
		// 2^6 - 3 => elf 2^6 - 5
		
		//2^22 > 3018458 (first such power of two)
		//2^22 - 3018458 = 1,175,845
		//2^22 - 2 * 1,175,845 = 1,842,613
		
		
		//int numberOfElves = 3018458;
		ArrayList<Integer> elves = null;
		for(int index = 1; index <= 300; index++){
//			if(index % 1000 == 0){
//				System.out.println(index);
//			}
			elves = new ArrayList<Integer>();
			for(int indexInner = 1; indexInner <= index; indexInner++){
				elves.add(indexInner);
			}
			int currentIndex = 0;
			int removeIndex = ((elves.size() / 2) + currentIndex) % elves.size();
			while(elves.size() > 1){
				elves.remove(removeIndex);
				currentIndex =  removeIndex > currentIndex ? (currentIndex +1) % elves.size() : currentIndex % elves.size();
				removeIndex = ((elves.size() / 2) + currentIndex) % elves.size();

			}
			for(int x = 0; x < elves.size(); x++){
				System.out.println("This elf wins: "+ elves.get(x));
			}
			System.out.println("----------------");
		}
		//PART B
		// 3^13 = 1,594,323 (the highest power without going over the puzzle input)
		// 3,018,458 - 1,594,323 = 1,424,135 //since this number is not bigger than the result of the above, we count by 1 to reach it. Therefore,this number is the answer.
	}
}