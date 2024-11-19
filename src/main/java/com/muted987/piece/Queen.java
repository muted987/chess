package main.java.com.muted987.piece;

import main.java.com.muted987.Color;
import main.java.com.muted987.Coordinates;

import java.util.Set;

public class Queen extends Piece {

    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
