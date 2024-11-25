package main.java.com.muted987;

import main.java.com.muted987.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String boardFen = "k4r2/8/8/r7/4KN2/2q1N3/8/8 w - - 0 1";
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

