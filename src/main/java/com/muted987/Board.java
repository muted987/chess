package main.java.com.muted987;

import main.java.com.muted987.piece.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();
    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }
    public void removePiece(Coordinates coordinates) {
        pieces.remove(coordinates);
    }
    public  void movePiece(Coordinates from, Coordinates to) {
        Piece piece = getPiece(from);
        removePiece(from);
        setPiece(to, piece);
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
        setPiece(new Coordinates(File.G, 1), new Knight(Color.WHITE, new Coordinates(File.G, 1)));
        setPiece(new Coordinates(File.B, 1), new Knight(Color.WHITE, new Coordinates(File.B, 1)));
        setPiece(new Coordinates(File.G, 8), new Knight(Color.BLACK, new Coordinates(File.G, 8)));
        setPiece(new Coordinates(File.B, 8), new Knight(Color.BLACK, new Coordinates(File.B, 8)));
        //set bishop
        setPiece(new Coordinates(File.C, 8), new Bishop(Color.BLACK, new Coordinates(File.C, 8)));
        setPiece(new Coordinates(File.C, 1), new Bishop(Color.WHITE, new Coordinates(File.C, 1)));
        setPiece(new Coordinates(File.F, 1), new Bishop(Color.WHITE, new Coordinates(File.F, 1)));
        setPiece(new Coordinates(File.F, 8), new Bishop(Color.BLACK, new Coordinates(File.F, 8)));
        //set king
        setPiece(new Coordinates(File.E, 1), new King(Color.WHITE, new Coordinates(File.E, 1)));
        setPiece(new Coordinates(File.E, 8), new King(Color.BLACK, new Coordinates(File.E, 8)));
        //set queen
        setPiece(new Coordinates(File.D, 8), new Queen(Color.BLACK, new Coordinates(File.D, 8)));
        setPiece(new Coordinates(File.D, 1), new Queen(Color.WHITE, new Coordinates(File.D, 1)));
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

    public List<Piece> getPiecesByColor(Color color) {
        List<Piece> result = new ArrayList<>();
        for (Piece piece : pieces.values()) {
            if (piece.color == color) {
                result.add(piece);
            }
        }
        return result;
    }

    public boolean isSquareUnderAttackByColor(Coordinates coordinates, Color color) {
        List<Piece> pieces = getPiecesByColor(color);
        for (Piece piece : pieces) {
            Set<Coordinates> attackedSquares = piece.getAttackedSquares(this);

            if (attackedSquares.contains(coordinates)) {
                return true;
            }
        }
        return false;
    }
}
