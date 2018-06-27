import java.util.List;
import com.sjcdojo.mahjong.Player; // Temp
import com.sjcdojo.mahjong.Tile; // Temp

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
    public Tile discard() {
        // TODO: Find the candidate tile to discard.
        refreshTilesInWait();
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
    public List<Tile> getTitles() {
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
