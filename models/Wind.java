

public class Wind extends Tile{
//	east, west, north, south
	private String direction;

	public Wind() {
		
	}
	
	public Wind(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
	
}
