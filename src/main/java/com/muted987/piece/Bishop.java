package main.java.com.muted987.piece;

import main.java.com.muted987.Color;
import main.java.com.muted987.Coordinates;

import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop {

     public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
     }
}
