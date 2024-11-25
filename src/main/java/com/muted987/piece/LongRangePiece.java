package main.java.com.muted987.piece;

import main.java.com.muted987.Board;
import main.java.com.muted987.BoardUtils;
import main.java.com.muted987.Color;
import main.java.com.muted987.Coordinates;

import java.util.List;

abstract public class LongRangePiece extends Piece{
    public LongRangePiece(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }
    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);
        if (result) {
            return isSquareAvailableForAttack(coordinates, board);
        }
        else {
            return false;
        }
    }

    @Override
    protected boolean isSquareAvailableForAttack(Coordinates coordinates, Board board) {
        List<Coordinates> coordinatesBetween;
        if (this.coordinates.file == coordinates.file) {
            coordinatesBetween = BoardUtils.getVerticalBetweenCoordinates(this.coordinates, coordinates);
        } else if (this.coordinates.rank.equals(coordinates.rank)) {
            coordinatesBetween = BoardUtils.getHorizontalBetweenCoordinates(this.coordinates, coordinates);
        } else {
            coordinatesBetween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
        }
        for (Coordinates c : coordinatesBetween) {
            if (!board.isSquareEmpty(c)) {
                return false;
            }
        }
        return true;
    }
}
