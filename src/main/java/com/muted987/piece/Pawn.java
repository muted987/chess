package main.java.com.muted987.piece;

import main.java.com.muted987.Color;
import main.java.com.muted987.Coordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        if (color == Color.WHITE) {
            return new HashSet<>(Arrays.asList(
                    new CoordinatesShift(0, 1)
            ));
        }
        else {
            return new HashSet<>(Arrays.asList(
                    new CoordinatesShift(0, -1)
            ));
        }
    }
}
