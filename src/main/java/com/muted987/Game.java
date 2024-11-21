package main.java.com.muted987;

import main.java.com.muted987.piece.Piece;

import java.util.Set;

public class Game {

    private final Board board;
    private BoardConsoleRender renderer = new BoardConsoleRender();
    private InputCoordinates input = new InputCoordinates();
    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            renderer.render(board);
            System.out.println("\n");
            if (isWhiteToMove) {
                System.out.println("White move");
            }
            else {
                System.out.println("Black move");
            }
            //input
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );
            //A1B1
            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> avalableMoveSquares = piece.getAvailableMoveSquares(board);
            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(avalableMoveSquares);
            //make move
            board.movePiece(sourceCoordinates, targetCoordinates);
            //pass move
            isWhiteToMove =!isWhiteToMove;
        }
    }
}
