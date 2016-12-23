
public class Node {
	private int x;
	private int y;
	private int size;
	private int used;
	private int available;
	private int usedPercentage;
	
	public Node(int x, int y, int size, int used, int available, int usedPercentage) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.used = used;
		this.available = available;
		this.usedPercentage = usedPercentage;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getUsed() {
		return used;
	}

	public void setUsed(int used) {
		this.used = used;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getUsedPercentage() {
		return usedPercentage;
	}

	public void setUsedPercentage(int usedPercentage) {
		this.usedPercentage = usedPercentage;
	}



}
