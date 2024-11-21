package main.java.com.muted987.piece;

import main.java.com.muted987.Board;
import main.java.com.muted987.BoardUtils;
import main.java.com.muted987.Color;
import main.java.com.muted987.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {

     public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    protected Set<CoordinatesShift> getPieceMoves() {
        //bottom-left to top right

        Set<CoordinatesShift> result = new HashSet<>();

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, i));
        }
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, -i));
        }
        //top left to bottom right

        return result;
    }
    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
         boolean result = super.isSquareAvailableForMove(coordinates, board);
         if (result) {
             List<Coordinates> coordinatesBetween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
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
