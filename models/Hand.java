import java.util.List;
// import com.sjcdojo.mahjong.Player; // Temp
// import com.sjcdojo.mahjong.Tile; // Temp

public class Hand {
    private List<Tile> tiles;
    private Player player;
    private List<Meld> melds;
    private List<Tile> waitTiles;

    public Hand() {
    }

    public Hand(List<Tile> tiles, Player player) {
        this.tiles = tiles;
        this.player = player;
    }

    public Hand(Player player) {
        this.player = player;
    }
    // Draws one tile from the deck and adds to the Hand
    public void drawTile(Tile drewTile) {
        tiles.add(drewTile);
    }

    // Add claimed tile to the Hand
    public void claimTile(Tile claimedTile) {
        // TODO: Use this tile to create a Meld
        refreshTilesInWait();
    }

    // Discards a tile from Hand and returns it to the caller
    public Tile discard(Tile discardedTile) {
        
 
    	for(int i = 0; i < tiles.size(); i++ ) {
    		if(discardedTile == tiles.get(i)) {
    			System.out.println("Discard index: " + i);
        		System.out.println(player.getHand().getTiles());
        		System.out.println(player.getHand().getTiles().size());
        		System.out.println("Discard tile: " + tiles.get(i));
        		System.out.println("Discard suite: " + tiles.get(i).getSuite());
        		System.out.println("Discard name: " + tiles.get(i).getName());
    			Tile discardTile = tiles.get(i);
    			player.getDiscards().add(discardTile);
    			this.tiles.remove(discardTile);
    			System.out.println(player.getHand().getTiles());
    			System.out.println(player.getHand().getTiles().size());
    		}
    	}
        refreshTilesInWait();
        return discardedTile;
    }
    
//  Discard a tile from hand by index location, returns it to the caller
    public Tile discardByIndex(Integer index) {
    		System.out.println("Discard index: " + index);
    		System.out.println(player.getHand().getTiles());
    		System.out.println(player.getHand().getTiles().size());
    		System.out.println("Discard tile: " + tiles.get(index));
    		System.out.println("Discard suite: " + tiles.get(index).getSuite());
    		System.out.println("Discard name: " + tiles.get(index).getName());
	    	Tile discardTile = tiles.get(index);
			player.getDiscards().add(tiles.get(index));
			this.tiles.remove(tiles.get(index));
			System.out.println(player.getHand().getTiles());
			System.out.println(player.getHand().getTiles().size());
			
    	return discardTile;
    }

    // Checks tiles in the Hand and updates waitTiles list
    private void refreshTilesInWait() {
        // Check Hand against winning patterns to see what tiles are missing (use static methods in Table class)
    }

    // Checks the tiles in the Hand to see if it is a winner
    public boolean isWinner() {
        boolean result = false;

        // Check Hand against winning patterns (use static methods in Table class)

        return result;
    }

    // Check if tile is in waiting tiles list
    public boolean checkIfTileInWait(Tile tile) {
        boolean result = false;

        for (Tile rec : waitTiles) {
            if (rec == tile)
                return true;
        }

        return result;
    }

    // getters and setters
    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Meld> getMelds() {
        return melds;
    }

    public void setMelds(List<Meld> melds) {
        this.melds = melds;
    }

    public List<Tile> getWaitTitles() {
        return waitTiles;
    }

    public void setWaitTiles(List<Tile> waitTiles) {
        this.waitTiles = waitTiles;
    }
}
