package advent3;

public class House {
	private int x = 0;
	private int y = 0;
	
	public House (int x, int y){
		this.x = x;
		this.y = y;
		
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public boolean isTheSameAs(House currentHouse) {
		if(this.getX() == currentHouse.getX() &&
		   this.getY() == currentHouse.getY()){
			return true;
		}
		else{
			return false;
		}
	}
}
