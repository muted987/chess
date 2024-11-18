package main.java.com.muted987;

import main.java.com.muted987.piece.Knight;
import main.java.com.muted987.piece.Pawn;
import main.java.com.muted987.piece.Piece;
import main.java.com.muted987.piece.Rook;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();
    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    public void setupDefaultPiecesPositions() {
        //set pawns
        for (File file : File.values()) {
            setPiece(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPiece(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));
        }
        //set rook
        setPiece(new Coordinates(File.A, 1), new Rook(Color.WHITE, new Coordinates(File.A, 1)));
        setPiece(new Coordinates(File.H, 1), new Rook(Color.WHITE, new Coordinates(File.H, 1)));
        setPiece(new Coordinates(File.A, 8), new Rook(Color.BLACK, new Coordinates(File.A, 8)));
        setPiece(new Coordinates(File.H, 8), new Rook(Color.BLACK, new Coordinates(File.H, 8)));
        //set knight
        setPiece(new Coordinates(File.B, 1), new Knight(Color.WHITE, new Coordinates(File.B, 1)));


    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates){
        return pieces.get(coordinates);
    }
}