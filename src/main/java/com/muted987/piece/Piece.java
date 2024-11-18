package main.java.com.muted987.piece;

import main.java.com.muted987.Color;
import main.java.com.muted987.Coordinates;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
