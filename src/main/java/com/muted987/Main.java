package main.java.com.muted987;

import main.java.com.muted987.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String boardFen = "8/1q3B2/8/b2Q3B/8/1p6/2N3R1/8 w - - 0 1";
        Board board = (new BoardFactory()).fromFEN(boardFen);


//        Piece piece = board.getPiece(new Coordinates(File.B, 8));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//
//
//
        Game game = new Game(board);
        game.gameLoop();
    }
}

