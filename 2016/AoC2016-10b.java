
public class Bot {
	private int number;
	private int highChip;
	private int lowChip;
	
	Bot(int number){
		this.setNumber(number); 
		this.highChip = -1;
		this.lowChip = 10000;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getHighChip(){
		return highChip;
	}
	public int getLowChip(){
		return lowChip;
	}
	public void setHighChip(int num){
		highChip = num;
	}
	public void setLowChip(int num){
		lowChip = num;
	}
	public boolean highChipIsEmpty() {
		return highChip == -1;
	}
	public boolean lowChipIsEmpty() {
		return lowChip == 10000;
	}
	public boolean has2Chips() {
		return !this.highChipIsEmpty() && !this.lowChipIsEmpty();
	}
}
