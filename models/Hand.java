

import java.util.List;
//import com.sjcdojo.mahjong.Player; // Temp
//import com.sjcdojo.mahjong.Tile; // Temp

public class Hand {
    private List<Tile> tiles;
    private Player player;
    private List<Meld> melds;
    private List<Tile> waitTiles;

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
        // TODO: Find the candidate tile to discard.
        refreshTilesInWait();
        return discardedTile;
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

    public void setTiles(List<Tile> tiles){
        this.tiles = tiles;
    }
}
