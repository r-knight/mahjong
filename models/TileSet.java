import java.util.ArrayList;


public class TileSet {
	private ArrayList<Tile> allTiles;
	
	public TileSet(){
		this.allTiles = buildDeck();	
	}
	
	private final ArrayList<Tile> buildDeck() {
		ArrayList<Tile> deck = new ArrayList<Tile>();
		
//		create winds tiles
		String[] winds = {"north","east", "south", "west"};
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				Tile temp = new Wind(winds[i]);
				temp.setName(winds[i]);
				temp.setSuite("wind");
				temp.setSelected(false);
				temp.setLocation(0);
				deck.add(temp);
			}
			
		}
		
//		create dragons tiles
		String[] dragons = {"white","green", "red"};
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				Tile temp = new Dragon(dragons[i]);
				temp.setName(dragons[i]);
				temp.setSuite("dragon");
				temp.setSelected(false);
				temp.setLocation(0);
				deck.add(temp);
			}
			
		}
		
//		create pins tiles
		for(int i = 1; i < 10; i++) {
			for(int j = 0; j < 4; j ++) {
				Tile temp = new Pin(i);
				temp.setName(Integer.toString(i));
				temp.setSuite("pin");
				temp.setSelected(false);
				temp.setLocation(0);
				deck.add(temp);
			}
		}
		
//		create bamboos tiles
		for(int i = 1; i < 10; i++) {
			for(int j = 0; j < 4; j ++) {
				Tile temp = new Bamboo(i);
				temp.setName(Integer.toString(i));
				temp.setSuite("bamboo");
				temp.setSelected(false);
				temp.setLocation(0);
				deck.add(temp);
			}
		}
		
//		create characters tiles
		for(int i = 1; i < 10; i++) {
			for(int j = 0; j < 4; j ++) {
				Tile temp = new Character(i);
				temp.setName(Integer.toString(i));
				temp.setSuite("character");
				temp.setSelected(false);
				temp.setLocation(0);
				deck.add(temp);
			}
		}
		
		
		return deck;
	}

	public ArrayList<Tile> getAllTiles() {
		return allTiles;
	}

	public void setAllTiles(ArrayList<Tile> allTiles) {
		this.allTiles = allTiles;
	}
	
	
}
