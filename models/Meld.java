//package com.mahjong.mvc.models;
import java.util.List;

public class Meld {
    private List<MeldTile> meldTiles;
    private int type; // 0: run / 1: triplet / 2: quad
    private int mode; // 0: open / 1: concealed

    public Meld() {
    }

    public Meld(List<MeldTile> meldTiles, int type, int mode) {
        this.meldTiles = meldTiles;
        this.type = type;
        this.mode = mode;
    }

    public List<MeldTile> getMeldTiles() {
        return meldTiles;
    }

    public void setMeldTiles(List<MeldTile> meldTiles) {
        this.meldTiles = meldTiles;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
