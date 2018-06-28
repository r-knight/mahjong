//package com.mahjong.mvc.models;
//import com.sjcdojo.mahjong.Player; // Temp
//import com.sjcdojo.mahjong.Tile; // Temp


public class MeldTile extends Tile {
    private Player prevPlayer; // not null if tile was claimed.

    public MeldTile() {
    }

    public MeldTile(Player prevPlayer) {
        this.prevPlayer = prevPlayer;
    }

    public Player getPrevPlayer() {
        return prevPlayer;
    }

    public void setPrevPlayer(Player prevPlayer) {
        this.prevPlayer = prevPlayer;
    }
}
