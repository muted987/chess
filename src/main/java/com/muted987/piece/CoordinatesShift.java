package main.java.com.muted987.piece;

import main.java.com.muted987.File;

public class CoordinatesShift {
    public final int fileShift;
    public final int rankShift;

    public CoordinatesShift(int fileShift, int rankShift) {
        this.fileShift = fileShift;
        this.rankShift = rankShift;
    }

    @Override
    public String toString(){
        return Integer.toString(fileShift) + Integer.toString(rankShift);
    }
}
