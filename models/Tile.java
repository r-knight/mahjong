


abstract public class Tile {
//	name will be variable depending on tile type, mostly useful for displaying on screen
	private String name;
//	suite will be the tile suites (ie: wind, bamboo...)
	private String suite;
//	selected can be used as a placeholder for many uses; may be superfluous
	private boolean selected;
//	location will decide where the tile is (ie: 0 is in wall, 1 is in player 1 hand, 2 is in player 2 hand...)
	private Integer location;
	
	public Tile() {
		
	}
	
	public Tile(String name, String suite, boolean selected, Integer location) {
		this.name = name;
		this.suite = suite;
		this.selected = selected;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}
	
	
	
	
	
	
}
