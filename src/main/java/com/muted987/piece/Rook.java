package main.java.com.muted987.piece;

import main.java.com.muted987.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rook extends Piece {

    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int i = 0, j = 0; i <= 7; i++) {
            result.add(new CoordinatesShift(j, i));
            result.add(new CoordinatesShift(j, -i));
            result.add(new CoordinatesShift(i, j));
            result.add(new CoordinatesShift(-i, j));
        }
        System.out.println("result = " + result);
        return result;
    }
    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);
        if (result) {
            List<Coordinates> coordinatesBetween = BoardUtils.getRowsCoordinatesBetween(this.coordinates, coordinates);
            for (Coordinates c : coordinatesBetween) {
                if (!board.isSquareEmpty(c)) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

}
