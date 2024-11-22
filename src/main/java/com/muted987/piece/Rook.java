package main.java.com.muted987.piece;

import main.java.com.muted987.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rook extends LongRangePiece implements IRook {

    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    protected Set<CoordinatesShift> getPieceMoves() {
        return getRockMoves();
    }
}
